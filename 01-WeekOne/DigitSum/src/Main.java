/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        int number, baseValue, tempNumber, result=0;

        // Prompting input
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter number: ");
        number = input.nextInt();

        // Decide how many digits
        tempNumber=number;
        while(tempNumber!=0){
            tempNumber /= 10;
        }

        // Sum of digits
        tempNumber=number;
        while(tempNumber!=0){
            baseValue = tempNumber %10;
            result+=baseValue;
            tempNumber/=10;
        }

        // Printing result
        System.out.println("Sum of digits are "+result);
    }
}