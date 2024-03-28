package core;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setTheme(){
        // Theme name = Nimbus
        for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }

    public static void showMessage(String str){
        String msg;
        String title = switch (str) {
            case "fill" -> {
                msg = "Please fill in all fields!";
                yield "Error!";
            }
            case "done" -> {
                msg = "Process successful";
                yield "Result";
            }
            case "notFound" -> {
                msg = "Record not found!";
                yield "Not Found";
            }
            default -> {
                msg = str;
                yield "Message";
            }
        };

        JOptionPane.showMessageDialog(null,msg,
                title,JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean isFieldEmpty(JTextField[] fieldList){
        for(JTextField field: fieldList){
            if(isFieldEmpty(field)) return true;
        }
        return false;
    }

    public static int getLocationPoint(String type, Dimension size){
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }
}
