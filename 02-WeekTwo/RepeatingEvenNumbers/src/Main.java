/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    
    // Finding method
    static boolean isFind(int[] arr, int value){
        for(int i : arr){
            if(i == value){
                return true;
            }
        }
      return  false;
    }

    public static void main(String[] args) {
        // Declare variable
        int [] arr = {4, 7, 2, 4, 2, 8, 8, 4, 1, 6, 4, 1};
        int [] duplicateArr = new int[arr.length];
        int startIndex = 0;

        // Main loop through arrays
        for(int indexArr = 0; indexArr < arr.length; indexArr++){
            for(int indexDublicate = 0; indexDublicate < arr.length; indexDublicate++){
                if((indexArr != indexDublicate)&&(arr[indexArr]==arr[indexDublicate]) && (arr[indexArr] % 2 == 0)){
                    if(!isFind(duplicateArr,arr[indexArr])){
                        duplicateArr[startIndex++] = arr[indexArr];
                    }
                    break;
                }
            }
        }

        // Remove zeros and printing results
        for (int value : duplicateArr){
            if(value != 0){
                System.out.println(value);
            }
        }
        }
    }