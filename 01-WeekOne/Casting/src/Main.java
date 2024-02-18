/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variable
        int numberOne;
        double numberTwo;
        Scanner input = new Scanner(System.in);

        //  Prompting inputs
        System.out.print("Please enter a integer number: ");
        numberOne = input.nextInt();
        System.out.print("Please enter a float number: ");
        numberTwo = input.nextDouble();

        // Casting
        double numberOneCasting = numberOne;
        int numberTwoCasting = (int) numberTwo;

        // Printing results
        System.out.println("Explicit Casting (int -> double ) : " + numberOneCasting);
        System.out.println("Implicit Casting (double -> int) : " + numberTwoCasting);
    }
}