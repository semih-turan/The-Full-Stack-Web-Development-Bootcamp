/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Declare variables and prompting input
        int year;
        System.out.print("Please enter year: ");
        year = input.nextInt();

        // Printing result
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if(year% 400 ==0){
                    System.out.print(year + " is a bissextile");
                }
                else {
                System.out.print(year + " is a not bissextile");
                }
            } else {
                System.out.print(year + " is a bissextile");
            }
        } else {
            System.out.print(year + " is not a bissextile");
        }
    }
}