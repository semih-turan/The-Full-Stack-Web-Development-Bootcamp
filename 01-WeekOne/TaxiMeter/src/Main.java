import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declare variables and total taxi fare
        double km, taxiFare, initCharge = 10.0, meteredFare = 2.20;

        // Prompting user input for km
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter KM: ");
        km = input.nextDouble();

        // Calculating taxi fare
        taxiFare = initCharge+(km*meteredFare);

        // Printing taxi fare
        System.out.print(taxiFare<20 ? "Taxi Fare is: 20.0": "Taxi Fare is: " + taxiFare );
    }
}