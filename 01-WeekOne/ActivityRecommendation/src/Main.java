/**
 * @author Semih Turan
 * @since   february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        double temperature; // Declare temperature variable
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter weather temperature: ");
        temperature = input.nextDouble();

        // Checking temp. and print advice
        if(temperature>25) {
            System.out.println("You can go to swimming");
        } else if ( temperature>=15){
            System.out.println("You can go to picnic");
        } else if (temperature>=5) {
            System.out.println("You can go to cinema");
        } else {
            System.out.println("You can ski");
        }
    }
}