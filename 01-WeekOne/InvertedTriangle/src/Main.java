/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Please enter place value: ");
        n = input.nextInt();

        // Printing result
        for(int i=n; i>=1;i--){
            for(int j=1; j<=2*i-1;j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}