/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       // Declare variables
        Scanner input = new Scanner(System.in);
        int n,sum=1;
        System.out.print("Please enter number: ");
        n=input.nextInt();

        // Finding loop
        for(int i=2; i<n; i++){
            if(n%i==0){
                sum+=i;
            }
        }
        // Printing result
        if(sum==n){
            System.out.print(n+" is a perfect number.");
        }else {
            System.out.print(n+" is not a perfect number.");
        }
    }
}