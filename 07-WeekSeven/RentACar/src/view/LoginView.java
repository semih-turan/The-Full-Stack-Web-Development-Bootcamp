package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame{
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;

    public LoginView()  {
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Rent A Car");
        this.setSize(400,400);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width -this.getSize().width)/2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height -this.getSize().height)/2;
        this.setLocation(x,y);
        this.setVisible(true);

    }
}
