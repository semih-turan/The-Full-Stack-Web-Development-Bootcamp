/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      // Declare variable and prompting input from user
        int a, b, c;
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter first number: ");
        a = input.nextInt();
        System.out.print("Please enter second number: ");
        b = input.nextInt();
        System.out.print("Please enter third number: ");
        c = input.nextInt();

        // Print result
        System.out.println("Result: " + (a+b*c-b));
    }
}