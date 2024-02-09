/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        String username, password, newPassword;
        int ans;
        // Prompting user input
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your username: ");
        username = input.nextLine();
        System.out.print("Please enter your password: ");
        password = input.nextLine();

        if ((username.equals("admin")) && (password.equals("1234"))) {
            System.out.println("Login successfully!");
        } else {
                System.out.println("Login failed!");
                System.out.println("Do you want to reset your password?");
                System.out.println("1-Yes");
                System.out.println("2-No");
                ans = input.nextInt();
                input.nextLine(); // Cleaning buffer
                // Select 1
                if (ans == 1) {
                    System.out.print("Please enter your new password: ");
                    newPassword = input.nextLine();
                    System.out.println(newPassword);
                    if (newPassword.equals(password)) {
                        System.out.println("Don't use your previous password!"); // Check previous password
                    } else {
                        System.out.println("Login successfully!");
                    }
                } else { // Select 2
                    System.out.println("Login Failed!");
                }
            }
        }
    }
}