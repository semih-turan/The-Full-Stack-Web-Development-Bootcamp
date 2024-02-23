/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Prompt the user to enter the matrix elements
        int[][] matrix = promptMatrix();

        // Print the original matrix
        printMatrix(matrix,"A");

        // Print the transpose of the matrix
        printMatrix(transposeMatrix(matrix),"A^T");
    }
    // Method to transpose the matrix
    public static int[][] transposeMatrix(int[][] matrix){
        int rowIndex = matrix.length;
        int colIndex = matrix[0].length;
        int[][] transposeMatrix = new int[colIndex][rowIndex];

        // Performing transpose operation
        for(int row=0; row < rowIndex; row++){
            for(int col = 0; col < colIndex; col++){
                transposeMatrix[col][row] = matrix[row][col];
            }
        }
        return transposeMatrix;
    }

    // Method to prompt matrix elements from the user
    public static int[][] promptMatrix(){
        Scanner input = new Scanner(System.in);
        int rowIndex;
        int colIndex;

        do {
            // Prompt the user to enter the number of rows and columns
            System.out.print("Please enter row index of matrix: ");
            rowIndex = input.nextInt();
            System.out.print("Please enter column index of matrix: ");
            colIndex = input.nextInt();

            // Check if both row and column indices are positive
            if (rowIndex > 0 && colIndex > 0) {
                break; // Break the loop if both indices are positive
            } else {
                System.out.println("Row and column indices must be greater than 0. Please try again.");
            }
        } while (true);

        // Create a matrix with the specified dimensions
        int[][] matrix = new int[rowIndex][colIndex];

        // Prompt the user to enter each element of the matrix
        for(int row=0; row < rowIndex; row++){
            for(int col = 0; col < colIndex; col++){
                System.out.print("Please enter " + (row+1) + ".row and "+ (col+1) + ".col value: ");
                matrix[row][col]= input.nextInt();
            }
        }
        // Print a blank line
        System.out.println();
        return matrix;
    }

    // Method to print the matrix
    public static void printMatrix(int[][] matrix,String name ) {

        // Print the name of the matrix
        System.out.println(name +" Matrix" + " : ");

        // Print each row of the matrix
        for (int[] row : matrix) {
            // Print each element of the row
            for (int col : row) {
                System.out.print(col + " ");
            }
            // Move to the next line after printing each row
            System.out.println();
        }
        // Print a blank line to separate matrices
        System.out.println();
    }
}