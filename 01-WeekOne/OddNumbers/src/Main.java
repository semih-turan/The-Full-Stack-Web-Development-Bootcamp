/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        Scanner input = new Scanner(System.in);
        double number, sum=0;

        // Sum numbers which is even and multiple of four
        do {
            System.out.print("Enter number: ");
            number = input.nextDouble();
            if(number%2==0 && number%4==0){
                sum += number;
            }
        }
        while(number%2==0);
        // Printing result
        System.out.print("Total is "+sum);
    }
}