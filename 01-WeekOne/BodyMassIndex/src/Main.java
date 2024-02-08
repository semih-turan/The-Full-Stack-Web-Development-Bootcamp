/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // User prompting input such as height and weight
        System.out.println("Please enter your height(m): ");
        double height = input.nextDouble();

        System.out.println("Please enter your weight(kg): ");
        double weight = input.nextDouble();

        // Calculating Body Mass Index
        double bmi = weight/(height*height);
        System.out.println("Your Body Mass Index is: "+bmi);
        }
    }