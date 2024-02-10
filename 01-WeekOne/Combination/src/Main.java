/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variable
        Scanner input = new Scanner(System.in);
        double n, r, factN=1, factR=1, factS=1;

        // Prompting user inputs
        System.out.print("Please enter n: ");
        n = input.nextDouble();
        System.out.print("Please enter r: ");
        r = input.nextDouble();

        // Calculates factorial
        for(int i=1; i<=n; i++) {factN *=i;}
        for(int j=1; j<=r; j++) {factR *=j;}
        for(int k=1; k<=(n-r); k++) {factS *=k;}

        // Calculates combination(// C(n,r) = n! / (r! * (n-r)!)) and printing result
        System.out.println("Result: " + factN/(factR*factS));
    }
}