/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declaring variables
        int select, choose, right = 3;
        double balance = 1500, amountMoney;
        String username, password;

        Scanner input = new Scanner(System.in);
        System.out.println("|---------------Welcome Kodluyoruz Bank!-----------------|");

        // Main loop
        while (right > 0) {
            // Prompting input
            System.out.print("Please enter your username: ");
            username = input.nextLine();
            System.out.print("Please enter your password: ");
            password = input.nextLine();

            // Validation
            if (username.equals("Patika") && password.equals("dev123")) {
                System.out.println("Hello Patika, Welcome to Kodluyoruz Bank!");

                // Menu loop
                do {
                    System.out.println("|---Please select the action you want to perform---|");
                    System.out.println("|1-Deposit Cash------------------------------------|");
                    System.out.println("|2-Withdraw Cash-----------------------------------|");
                    System.out.println("|3-Check Balance-----------------------------------|");
                    System.out.println("|4-Exit--------------------------------------------|");
                    System.out.println("|--------------------------------------------------|");
                    System.out.print("Select: ");
                    select = input.nextInt();

                    switch (select) {
                        case 1: // Deposit cash
                            System.out.println("Enter deposit amount");
                            amountMoney = input.nextDouble();
                            balance += amountMoney;
                            System.out.println("Your cash has been accepted.");
                            break;
                        case 2: // Withdraw cash
                            System.out.println("Enter withdraw amount");
                            amountMoney = input.nextDouble();
                            if (amountMoney > balance) {
                                System.out.println("Insufficient balance!");
                            } else {
                                balance -= amountMoney;
                                System.out.println("Please withdraw your money from tray.");
                            }
                            break;
                        case 3: // Checking balance
                            System.out.println("Balance = " + balance);
                            break;
                        case 4: // Exiting
                            System.out.println("Thank you for choosing us.");
                            break;
                        default:
                            System.out.println("Invalid selection!");
                    }

                    // Checking user behaviour
                    if (select != 4) {
                        do {
                            System.out.println("Do you want to perform another transaction?");
                            System.out.println("1-Yes");
                            System.out.println("2-No");
                            choose = input.nextInt();
                            if (choose == 1 || choose == 2) {
                                break;
                            } else {
                                System.out.println("Please choose 1 or 2!");
                            }
                        } while (true);

                        if (choose == 2) {
                            System.out.println("Thank you for choosing us.");
                            break;
                        }
                    }

                } while (select != 4);
                break;
            } else { // Remaining rights for username or password
                right--;
                System.out.println("Invalid username or password. Try again...");
                if (right == 0) {
                    System.out.println("Your account has been blocked. Please contact your bank.");
                } else {
                    System.out.println("Your remaining attempts: " + right);
                }
            }
        }
    }
}