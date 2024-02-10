/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        Scanner input = new Scanner(System.in);
        double number;
        System.out.print("Please enter upper limit of number which powers of 4 and 5: ");
        number=input.nextDouble();
        // Printing results
        for(int i=1,j=1, k=0; i<=number || j<=number; k++, i*=4, j*=5){
            System.out.println("4^ "+k +" = "+ i);
            System.out.println("5^ "+k +" = "+j);
        }
    }
}