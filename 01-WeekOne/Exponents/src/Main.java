/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        Scanner input = new Scanner(System.in);
        int x, y, sum=1;

        // Prompting input
        System.out.print("Please enter number: ");
        x = input.nextInt();
        System.out.print("Please enter prime: ");
        y = input.nextInt();

        // Calculates prime number and printing result
        for(int i=1; i<=y; i++){
            sum *=x;
        }
        System.out.print("Result: "+sum);
    }
}