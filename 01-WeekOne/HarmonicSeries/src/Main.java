/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables and prompting input
        double n, sum=0;
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter n: ");
        n = input.nextDouble();

        // Calculates harmonic series and printing result
        for(double i=1; i<=n;i++){
            sum +=1/i;
        }
        System.out.print("Result: "+ sum);
    }
}