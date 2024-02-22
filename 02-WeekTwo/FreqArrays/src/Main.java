/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables and prompting inputs
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter array size: ");
        int arrSize = input.nextInt();

        int [] arr = promptArr(arrSize);
        int [][] resultArr = new int[arr.length][2];

        // Duplicate array and checks repeating values
        int resultArrIndex = 0;
        for (int k : arr) {
            boolean alreadyExist = false;
            for (int j = 0; j < resultArrIndex; j++) {
                if (resultArr[j][1] == k) {
                    alreadyExist = true;
                    resultArr[j][0]++;
                    break;
                }
            }
            if (!alreadyExist) {
                resultArr[resultArrIndex][1] = k;
                resultArr[resultArrIndex][0] = 1;
                resultArrIndex++;
            }
        }

        // Printing results
        System.out.println();
        System.out.println("Result:");
        for(int i=0; i < resultArrIndex; i++){
            System.out.println("Number " + resultArr[i][1] + " repeating "+ resultArr[i][0] + " times.");

        }
    }
    // Prompts users for array elements and returns the entire array
    public static int[] promptArr(int arrSize){
        // Declare variables
        int [] arr = new int[arrSize];
        Scanner input = new Scanner(System.in);
        int arrMember;

        // Prompts array elements and returns the entire array
        for(int index = 0; index < arrSize; index++){
            System.out.print(index+1 + " . member is ");
            arrMember = input.nextInt();
            arr[index] = arrMember;
        }
        return arr;
    }
}