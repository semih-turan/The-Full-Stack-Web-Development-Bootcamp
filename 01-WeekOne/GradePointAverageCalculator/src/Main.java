/**
 * @author Semih Turan
 * @since february 2024
 * */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables and store grades and result
        float mathScore, physicsScore, turkishScore, historyScore, musicScore, result;

        // Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Taking input for each lecture
        System.out.println("Please Enter Math Grade: ");
        mathScore = input.nextFloat();

        System.out.println("Please Enter Physics Grade: ");
        physicsScore = input.nextFloat();

        System.out.println("Please Enter Turkish Grade: ");
        turkishScore = input.nextFloat();

        System.out.println("Please Enter History Grade: ");
        historyScore = input.nextFloat();

        System.out.println("Please Enter Music Grade: ");
        musicScore = input.nextFloat();

        // Calculating average grade
        result = (mathScore+physicsScore+turkishScore+historyScore+musicScore)/5;

        // Printing result
        System.out.println("------------------------------");
        System.out.println("Grade Point Average Calculator");
        System.out.println("------------------------------");
        System.out.println("Total Average Point: " + result);
        System.out.println("Status: " + (result>=60 ? "Congratulations! Passed the Class":"Failed the Class :("));
    }
}