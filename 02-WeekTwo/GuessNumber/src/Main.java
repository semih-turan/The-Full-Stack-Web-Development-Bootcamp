/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(100); // Generate a random number between 0 and 99

        Scanner scanner = new Scanner(System.in);
        int attempt = 0; // Number of attempts
        int guess;
        int[] wrongGuesses = new int[5]; // Array to store wrong guesses
        boolean win = false; // Flag to track if the game is won
        boolean wrongInput = false; // Flag to track if there's a wrong input

        System.out.println("Welcome to the Number Guessing Game!");

        while (attempt < 5) {
            System.out.print("Please enter your guess (0-99): ");
            guess = scanner.nextInt();

            if (guess < 0 || guess > 99) {
                System.out.println("Please enter a number between 0 and 99.");
                if (wrongInput) {
                    attempt++;
                    System.out.println("You have made too many wrong inputs. Remaining attempts: " + (5 - attempt));
                } else {
                    wrongInput = true;
                    System.out.println("Your attempts will be penalized for wrong inputs from now on.");
                }
                continue;
            }

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                win = true;
                break;
            } else {
                System.out.println("Oops! Wrong guess.");
                if (guess > targetNumber) {
                    System.out.println(guess + " is greater than the target number.");
                } else {
                    System.out.println(guess + " is smaller than the target number.");
                }

                wrongGuesses[attempt++] = guess;
                System.out.println("Remaining attempts: " + (5 - attempt));
            }
        }

        if (!win) {
            System.out.println("Game Over! You didn't guess the number.");
            if (!wrongInput) {
                System.out.println("Your guesses: " + Arrays.toString(wrongGuesses));
                System.out.println("Target number: " + targetNumber);
            }
        }

        scanner.close();
    }
}
