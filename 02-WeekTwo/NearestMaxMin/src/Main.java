/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declare variables
        int [] arr = {15,12,788,1,-1,-778,2,0};
        int insertionPoint;

        // Sorting array and prompting input
        Arrays.sort(arr);
        System.out.print("Please enter search value: ");
        int userInput = input.nextInt();

        // Insertion point
        insertionPoint = Arrays.binarySearch(arr, userInput) ;

        // Printing result
        System.out.println(Arrays.toString(arr));
       while (true){
           if((-(insertionPoint) - 1) == 0){
               System.out.println("Minimum value is " + arr[0]);
               System.out.println("Maximum value is  " + arr[0]);
               break;
           } else if ( (-(insertionPoint) - 1) >= arr.length) {
               System.out.println("Minimum value is " + arr[arr.length-1]);
               System.out.println("Maximum value is  " + arr[arr.length-1]);
               break;
           }
           System.out.println("Minimum value is " + arr[(-(insertionPoint) - 1)-1]);
           System.out.println("Maximum value is  " + arr[(-(insertionPoint) - 1)]);
           break;
       }
    }
}