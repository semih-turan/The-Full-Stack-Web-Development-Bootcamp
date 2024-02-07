/**
 * @author Semih Turan
 * @since february 2024
 * */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    float price, taxPrice, taxRatio;

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Price: ");
        price = input.nextFloat();
        taxRatio = (float) ((price>0 && price<1000.0) ? 18.0 : 8.0);

        System.out.println("Price without VAT: "+(price));
        System.out.println("Price including VAT: " + (price+(price*taxRatio/100.0)));
        System.out.println("Tax Ratio : "+taxRatio+ " %");
    }
}