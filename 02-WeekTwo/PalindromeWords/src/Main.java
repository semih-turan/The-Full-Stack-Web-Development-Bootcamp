/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declare variables and prompting inputs
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the word you want to check: ");
        String checkWord = input.nextLine();
        boolean resultWord = isPalindrome(checkWord);

        // Printing result
        if (resultWord) {
            System.out.println(checkWord + " is a palindrome.");
        } else {
            System.out.println(checkWord + " is not palindrome.");
        }
    }

    // Checks palindrome or not method
    static boolean isPalindrome(String str) {
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return str.equals(reverse);
    }

}