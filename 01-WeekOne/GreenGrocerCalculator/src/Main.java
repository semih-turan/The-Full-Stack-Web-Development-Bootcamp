/**
 * @author Semih Turan
 * @since february 2024
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Declaring variables
        double pearKg, appleKg, tomatoesKg, bananaKg, aubergineKg;
        double pearPrice = 2.14, applePrice = 3.67, tomatoesPrice = 1.11;
        double bananaPrice = 0.95, auberginePrice = 5.00, totalPrice;
        char turkishLira = '₺';

        Scanner input = new Scanner(System.in);

        // User prompting input for vegetables
        System.out.print("How many kilograms of pears? : ");
        pearKg = input.nextDouble();

        System.out.print("How many kilograms of apples? : ");
        appleKg = input.nextDouble();

        System.out.print("How many kilograms of tomatoes? : " );
        tomatoesKg = input.nextDouble();

        System.out.print("How many kilograms of bananas? : " );
        bananaKg = input.nextDouble();

        System.out.print("How many kilograms of aubergines? : ");
        aubergineKg = input.nextDouble();

        // Calculating total price
        totalPrice = (pearKg*pearPrice) + (appleKg*applePrice) + (tomatoesKg*tomatoesPrice)
                     + (bananaKg*bananaPrice) + (aubergineKg*auberginePrice);
        System.out.print("Total Price: "+totalPrice + turkishLira);
        }
    }
