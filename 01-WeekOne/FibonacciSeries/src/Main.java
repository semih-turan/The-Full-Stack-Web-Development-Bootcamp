/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Declare variables
        int elementsNumber, cacheNumber, firstNumber=0, secondNumber=1;
        System.out.println("Welcome to Fibonacci Calculator!");

        // Prompting user input
        System.out.print("Please enter number of elements: ");
        elementsNumber = input.nextInt();

        // Calculate fibonacci numbers
        for(int index=0; index<=elementsNumber;index++){
            System.out.print(firstNumber+ " ");
            cacheNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = cacheNumber;
        }
    }
}