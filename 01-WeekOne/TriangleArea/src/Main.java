/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Variables and store edges and area
        int edgeA, edgeB, edgeC;
        double u, area;
        boolean isTriangle;
        // Scanner object to take user input
        //java.util.Scanner input = new java.util.Scanner(System.in);
        Scanner input = new Scanner(System.in);

        // Taking input for each edge
        System.out.println("Please enter first edge of the triangle: ");
        edgeA = input.nextInt();

        System.out.println("Please enter second edge of the triangle: ");
        edgeB = input.nextInt();

        System.out.println("Please enter third edge of the triangle: ");
        edgeC = input.nextInt();

        // Checking triangle
        isTriangle = (edgeA+edgeB>edgeC) && (edgeA + edgeC > edgeB) && (edgeB + edgeC > edgeA);
        System.out.println(isTriangle);

        // Calculating area
        u = (edgeA + edgeB + edgeC) / 2.0;
        area = Math.sqrt(u * (u - edgeA) * (u - edgeB) * (u - edgeC));

        // Printing result
        System.out.println("Triangle Area");
        System.out.println("-------------");
        System.out.println(isTriangle ? area : "This is not a triangle!");
    }
}