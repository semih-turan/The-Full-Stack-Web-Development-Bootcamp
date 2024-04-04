import business.UserManager;
import view.LoginGUI;

// Entry point of the application
public class App {
    public static void main(String[] args) {

        // Create an instance of the LoginGUI to start the application
        LoginGUI loginGUI = new LoginGUI();

        // Create an instance of the UserManager to manage user-related operations
        UserManager userManager = new UserManager();

        // Example: Retrieve user information from the database and pass it to the AdminGUI
        // AdminGUI adminGUI = new AdminGUI(userManager.findByLogin("admin","1234"));
    }
}
