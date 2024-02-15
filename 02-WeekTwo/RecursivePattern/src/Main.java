/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Define variable and prompting user input
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter n value: ");
        int userInput = input.nextInt();
        int processValue = recursiveProcessMinus(userInput);
        recursiveProcessPlus(processValue,userInput);
    }

    // Subtract until 0 or minus int and printing result
    public static int recursiveProcessMinus(int processValue){
        if(processValue <=0) return processValue;
        System.out.print(processValue +" ");
        return recursiveProcessMinus(processValue-5);
    }

    // Add until userInput value and printing result
    public static void recursiveProcessPlus(int processValue, int userInput){
        if (userInput>=processValue) {
            System.out.print(processValue + " ");
            recursiveProcessPlus(processValue + 5, userInput);
        }
    }
}