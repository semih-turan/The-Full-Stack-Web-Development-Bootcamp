package core;

import javax.swing.*;

public class Helper {

    // Method to check if a JTextField is empty
    public static boolean isFieldEmpty (JTextField field) {
        return field.getText().trim().isEmpty(); // Returns true if the field is empty, false otherwise
    }

    // Method to display an information message using JOptionPane
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                "Info",
                JOptionPane.INFORMATION_MESSAGE); // Display an information message dialog
    }

    // Method to display a confirmation dialog and get user confirmation
    public static boolean confirm(String string) {
        optionPaneTR(); // Set options for the JOptionPane in Turkish
        String message;
        if (string.equals("sure")) {
            message = "Are you sure you want to do this ?"; // Default confirmation message
        } else {
            message = string;
        }
        // Show a confirmation dialog and return true if user selects Yes, false if No
        return JOptionPane.showConfirmDialog(null,message,"Please confirm !", JOptionPane.YES_NO_OPTION) == 0;
    }

    // Method to set options for JOptionPane to Turkish
    public static void optionPaneTR() {
        // Set button text for OK, Yes, and No options in Turkish
        UIManager.put("OptionPane.okButtonText" , "OK");
        UIManager.put("OptionPane.yesButtonText" , "Yes");
        UIManager.put("OptionPane.noButtonText" , "No");
    }

    // Method to check if any of the JTextFields in the array is empty
    public static boolean isFieldListEmpty(JTextField[] jTextFields) {
        for (JTextField field : jTextFields) {
            if (isFieldEmpty(field)) {
                return true; // Returns true if any field is empty
            }
        }
        return false; // Returns false if all fields are non-empty
    }
}
