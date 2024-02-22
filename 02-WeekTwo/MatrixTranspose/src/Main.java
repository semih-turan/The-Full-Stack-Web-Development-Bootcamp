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

        // Prompt the user to enter the number of rows and columns
        System.out.print("Please enter row index of matrix: ");
        int rowIndex = input.nextInt();
        System.out.print("Please enter column index of matrix: ");
        int colIndex = input.nextInt();

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