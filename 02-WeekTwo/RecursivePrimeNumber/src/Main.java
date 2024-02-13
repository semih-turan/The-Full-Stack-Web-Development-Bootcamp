/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    // Prime number checking method
    static boolean isPrime(int number,int divisor){
        if(divisor == number){
            return true;
        }
        if(number % divisor == 0){
            return false;
        }
        return isPrime(number,divisor+1);
    }

    // Main method
    public static void main(String[] args) {
        // Declare variable and prompting input
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int userInput = input.nextInt();

        // Printing result
        boolean isPrimeResult = isPrime(userInput,2);
        if(isPrimeResult){
            System.out.println(userInput+" is a prime number.");
        }else{
            System.out.println(userInput+" is not a prime number.");
        }
    }
}