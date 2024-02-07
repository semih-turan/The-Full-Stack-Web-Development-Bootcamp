/**
 * @author Semih Turan
 * @since february 2024
 * */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables for price, price with tax, and tax ratio
        float price, taxRatio;

        // Prompting user to enter price
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Price: ");
        price = input.nextFloat();

        // Determining tax ratio based on price range
        taxRatio = (float) ((price>0 && price<1000.0) ? 18.0 : 8.0);

        // Printing Result
        System.out.println("Price without VAT: "+(price));
        System.out.println("Price including VAT: " + (price+(price*taxRatio/100.0)));
        System.out.println("Tax Ratio : "+taxRatio+ " %");
    }
}