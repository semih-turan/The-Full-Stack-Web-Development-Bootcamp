/**
 * @author Semih Turan
 * @since march 2024
 */
import java.io.BufferedReader;
import java.io.FileReader;
public class Main {
    public static void main(String[] args) {

        // Declare variable and initializer
        int sum = 0;
        FileReader file;
        file = null;

        try {
            // Open the file named "data.txt"
            file = new FileReader("data.txt");

            // Wrap FileReader in a BufferedReader for efficient reading
            BufferedReader input = new BufferedReader(file);
            String line;

            // Read each line from the file and add its integer value to the counter
            while((line = input.readLine()) != null){
                sum += Integer.parseInt(line);
            }

            // Print the result
            System.out.println("Result is " + sum + ".");

            // Close the BufferedReader and FileReader
            input.close();
            file.close();
        } catch (Exception e) {
            // Print error message if an exception occurs
            System.out.println(e.getMessage());
        }
    }
}