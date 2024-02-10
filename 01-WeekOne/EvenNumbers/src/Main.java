/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        Scanner input = new Scanner(System.in);
        double number, sum=0, average;
        int counter=0;

        // Prompting input
        System.out.print("Please enter number: ");
        number = input.nextDouble();
        input.nextLine(); // Buffer cleaner

        // Loop until desired number and sum desired values
        for(int i=1; i<=number; i++){
            if(i%3==0 && i%4==0){
                sum += i;
                counter++;
            }
        }
        // Printing average as a result
        if(counter>0){
            average = sum/counter;
            System.out.println("Average is "+average);
        } else {
            System.out.println("No number divisible by both 3 and 4 was found between 0 and " + number + ".");
        }
    }
}