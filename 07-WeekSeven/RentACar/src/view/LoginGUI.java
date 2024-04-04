package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;

// Represents the graphical user interface for user login
public class LoginGUI extends Layout {
    private JPanel container;
    private JPanel w_top;
    private JLabel label_welcome;
    private JLabel label_welcome2;
    private JTextField field_username;
    private JPasswordField field_password;
    private JButton button_login;
    private JLabel label_username;
    private JLabel label_password;
    private final UserManager userManager;

    // Constructor for LoginGUI
    public LoginGUI() {
        // Initialize UserManager
        this.userManager = new UserManager();

        // Add container to the JFrame
        this.add(container);

        // Initialize GUI and set dimensions
        this.guiInitialize(500, 500);

        // Action listener for login button
        button_login.addActionListener(e -> {
            // Check if username or password fields are empty
            if (Helper.isFieldEmpty(this.field_username) || Helper.isFieldEmpty(this.field_password)) {
                Helper.showMessage("Please fill in all fields.");
            } else {
                // Attempt to find user by login credentials
                User loginUser = this.userManager.findByLogin(this.field_username.getText(), this.field_password.getText());

                // If user not found, show error message
                if (loginUser == null) {
                    Helper.showMessage("User not found.");
                } else {
                    // If user found, open the AdminGUI window and pass the user object
                    AdminGUI adminGUI = new AdminGUI(loginUser);
                    dispose(); // Close the login window
                }
            }
        });
    }
}
