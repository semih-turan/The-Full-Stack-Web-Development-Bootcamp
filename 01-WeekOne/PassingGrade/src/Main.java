/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Variables and store grades and result
        float mathScore,physicsScore, turkishScore, historyScore, musicScore, result;
        int counter = 5; // Count satisfy lecture number
        // Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Taking input for each lecture and validate status
        System.out.print("Please Enter Math Grade: ");
        mathScore = input.nextFloat();
        if(mathScore<=0 || mathScore>100){
            System.out.println("Invalid score!");
            mathScore = 0;
            counter-=1;
        }
        System.out.print("Please Enter Physics Grade: ");
        physicsScore = input.nextFloat();
        if(physicsScore<=0 || physicsScore>100){
            System.out.println("Invalid score!");
            physicsScore = 0;
            counter-=1;
        }
        System.out.print("Please Enter Turkish Grade: ");
        turkishScore = input.nextFloat();
        if(turkishScore<=0 || turkishScore>100){
            System.out.println("Invalid score!");
            turkishScore = 0;
            counter-=1;
        }
        System.out.print("Please Enter History Grade: ");
        historyScore = input.nextFloat();
        if(historyScore<=0 || historyScore>100){
            System.out.println("Invalid score!");
            historyScore = 0;
            counter-=1;
        }
        System.out.print("Please Enter Music Grade: ");
        musicScore = input.nextFloat();
        if(musicScore<=0 || musicScore>100){
            System.out.println("Invalid score!");
            musicScore = 0;
            counter-=1;
        }
        // Calculating average grade
        if(counter<=0) {
            result = (mathScore + physicsScore + turkishScore + historyScore + musicScore);
        }else{
            result = (mathScore + physicsScore + turkishScore + historyScore + musicScore) / counter;
        }
        // Printing result
        if(result >= 55){
            System.out.println("Congratulations! Passed the Class");
            System.out.println("Your average grade is: "+ result);
        }else{
            System.out.println("You failed!. Your average grade is lower than 55");
            System.out.println("Your average grade is: "+ result);
        }
    }
}