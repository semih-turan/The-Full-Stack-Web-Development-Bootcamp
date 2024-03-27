/**
 * @author Semih Turan
 * @since march
 */
import java.io.*;
import java.util.Scanner;
public class Main {
    private static final String FILE_PATH = "notepad.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print the last saved text when the program starts
        printLastSavedText();

        // Ask the user to enter text or ":q" to exit
        System.out.print("Enter text or \":q\" to exit: ");
        String text = scanner.nextLine();

        // Keep prompting the user for input until ":q" is entered
        while (!text.equals(":q")) {
            try {
                // Save the entered text to the file
                saveToFile(text);
                System.out.println("Text saved successfully.");
            } catch (IOException e) {
                System.out.println("Failed to save text!");
                System.out.println(e.getMessage());
            }
            // Ask for input again
            System.out.print("Enter text or \":q\" to exit: ");
            text = scanner.nextLine();
        }
        // Close the scanner when done
        scanner.close();
    }

    // Method to print the last saved text from the file
    private static void printLastSavedText() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            System.out.println("Last saved text:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Last saved text not found!");
        }
    }

    // Method to save text to the file
    private static void saveToFile(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(text);
        }
    }
}