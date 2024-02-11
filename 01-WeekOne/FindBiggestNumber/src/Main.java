/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variable
        Scanner input = new Scanner(System.in);
        int count,n, bigN, smallN, firstN;

        //Prompting input
        System.out.println("How many numbers do you want to enter?");
        count = input.nextInt();
        System.out.print("Please enter 1. number: ");
        firstN = input.nextInt();
        smallN = firstN;
        bigN = firstN;

        // Sorting
        for(int i=2; i<=count; i++){

            System.out.print("Please enter "+ i+" .number: ");
            n=input.nextInt();

            if(n>bigN){
                bigN=n;
            }
            if(n<smallN){
                smallN =n;
            }
        }
        //Printing result
        System.out.println("The smallest number is "+smallN+".");
        System.out.println("The biggest number is "+bigN+".");
    }
}