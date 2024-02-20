/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        Scanner input = new Scanner(System.in);
        int n, elements;

        // Prompting input
        System.out.print("Please enter array's length: ");
        n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Please enter array's elements: ");

        // Inserting elements into array
        for (int index = 1; index <= n; index++){
            System.out.print(index + ". Element : ");
            elements = input.nextInt();
            arr[index-1] = elements;
        }

        // Sorting array and printing result
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}