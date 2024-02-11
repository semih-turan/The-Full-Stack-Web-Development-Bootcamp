/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variable and prompting input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = input.nextInt();

        // Upper Diamond
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j < (n - i); j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i + 1); k++) {
                System.out.print("*");
            }
            System.out.println(" ");

        }
       // Lower Diamond
        for(int i=n; i>=1;i--){
            for (int j=1; j <= n-i+1; j++) {
                System.out.print(" ");
            }
            for (int k=1; k<=2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}