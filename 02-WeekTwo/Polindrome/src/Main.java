/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {

    // Polindrome check method
    static boolean isPolindrome(int number){
        int cacheNumber = number, reverseNumber = 0, lastPlace;
        while(cacheNumber!=0){
            lastPlace = cacheNumber % 10;
            reverseNumber = (reverseNumber*10)+lastPlace;
            cacheNumber /= 10;
        }
        return number == reverseNumber;
    }

    // Main Method
    public static void main(String[] args) {
        // Prompting input
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number to check: ");
        int checkNumber = input.nextInt();
        // Printing result
        System.out.println("Result: "+isPolindrome(checkNumber));
    }
}