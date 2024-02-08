/**
 * @author Semih Turan
 * @since february 2024
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompting user input, radius and alfa angle
        double r = input.nextDouble();
        double alfa = input.nextDouble();

        // Calculating circle area
        double area = (Math.PI*r*r*alfa)/360.0;
        System.out.print(area);
    }
}