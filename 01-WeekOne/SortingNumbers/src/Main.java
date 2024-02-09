/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables
        int x, y, z;

        // Prompting inputs
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter first number: ");
        x = input.nextInt();
        System.out.print("Please enter second number: ");
        y = input.nextInt();
        System.out.print("Please enter third number: ");
        z = input.nextInt();

        // Sorting and printing result
        if(x>y && x>z){
            if(y>z){
                System.out.println("Sorting... "+x+">"+y+">"+z);
            } else{
                System.out.println("Sorting... "+x+">"+z+">"+y);
            }
        } else if (y>x && y>z){
            if(x>z){
                System.out.println("Sorting... "+y+">"+x+">"+z);
            } else{
                System.out.println("Sorting... "+y+">"+z+">"+x);
            }
        }
        else {
            if (x>y){
                System.out.println("Sorting... "+z+">"+x+">"+y);
            } else{
                System.out.println("Sorting... "+z+">"+y+">"+x);
            }
        }
    }
}