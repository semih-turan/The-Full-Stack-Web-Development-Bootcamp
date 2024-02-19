/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      // Declare variable
      Scanner input = new Scanner(System.in);
      double [] arr = {1.0,2.0,3.0,4.0,5.0};
      double sum = 0.0;

      // Calculates harmonic series and printing result
      for(int element = 0; element < arr.length; element++){
          sum += 1.0/arr[element];
      }
        System.out.println("Harmonic Average is " + sum);
    }
}