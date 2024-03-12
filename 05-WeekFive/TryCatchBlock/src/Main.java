/**
 * @author Semih Turan
 * @since march 2024
 */
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int index;
        Scanner input = new Scanner(System.in);

        // Prompting input
        System.out.println();
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.print("To get the element in the given array please enter the index number: ");
        index = input.nextInt();

        // Call index method
        indexOf(arr,index);
    }

    // Index method
    static public void indexOf(int[] arr, int index){
        try{
            System.out.println(arr[index]); // Check whether the given index is inside or outside the array
        }catch(ArrayIndexOutOfBoundsException e){ // Throw error message
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
}