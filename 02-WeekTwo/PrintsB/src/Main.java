/**
 * @author Semih Turan
 * @since february 2024
 */
public class Main {
    public static void main(String[] args) {
        // Declare variable
        String[][] letterB = new String[5][4];

        // Print * for creating letter B
        for (int rowIndex = 0; rowIndex < letterB.length; rowIndex++) {
            for (int colIndex = 0; colIndex < letterB[rowIndex].length; colIndex++) {
                if (rowIndex == 0 || rowIndex == 2 || rowIndex == 4) {
                    letterB[rowIndex][colIndex] = " * ";
                } else if (colIndex == 0 || colIndex == 3) {
                    letterB[rowIndex][colIndex] = " * ";
                } else {
                    letterB[rowIndex][colIndex] = "   ";
                }
            }
        }

        // Printing result
        for (String[] row : letterB){
            for (String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
}