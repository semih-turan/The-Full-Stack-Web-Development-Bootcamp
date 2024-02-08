/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Declare variables
        double x, y;
        System.out.println("--------Calculator---------");
        System.out.println("Please select method: ");
        System.out.println("1- Addition: ");
        System.out.println("2- Subtraction: ");
        System.out.println("3- Multiplication: ");
        System.out.println("4- Division: ");
        int method = input.nextInt();

        // Prompting inputs
        System.out.print("Please enter first number: ");
        x = input.nextDouble();
        System.out.print("Please enter second number: ");
        y = input.nextDouble();

        // Calculate and print result
        switch(method) {
            case 1:
                System.out.println("Result: "+(x+y));
                break;
            case 2:
                System.out.println("Result: "+(x-y));
                break;
            case 3:
                System.out.println("Result: "+(x*y));
                break;
            case 4:
                System.out.println("Result: "+(x/y));
                break;
        }
    }
}