/**
 * @author Semih Turan
 * @since  february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declare variables
        double km, pricePerKm = 0.10, price,totalPrice;
        int age;
        boolean isOneWayTicket;

        // Prompting user inputs
        System.out.print("Please enter distance as a km: ");
        km = input.nextDouble();

        System.out.print("Please enter your age: ");
        age = input.nextInt();

        System.out.println("Please choose your ticket type: ");
        System.out.println("1- One Way");
        System.out.println("2- Two Way");
        int userInput = input.nextInt();
        isOneWayTicket = userInput == 1;

        // Calculates total price for each situation
        if(km>=0 && age>=0){
            if(age<12){
                price = ((km*pricePerKm)-(km*pricePerKm)*0.5);
                totalPrice = isOneWayTicket ? price : ((price-(price*0.2))*2);
                System.out.println(totalPrice+" ₺");
            } else if (age>12 && age<=24) {
                price = ((km*pricePerKm)-(km*pricePerKm)*0.1);
                totalPrice = isOneWayTicket ? price : ((price-(price*0.2))*2);
                System.out.println(totalPrice+" ₺");
            } else if (age>=65) {
                price = ((km*pricePerKm)-(km*pricePerKm)*0.3);
                totalPrice = isOneWayTicket ? price : ((price-(price*0.2))*2);
                System.out.println(totalPrice+" ₺");
            } else {
                price = (km*pricePerKm);
                totalPrice = isOneWayTicket ? price : (price*2);
                System.out.println(totalPrice+" ₺");
            }
        }else {
            System.out.println("Invalid inputs!");
        }

    }
}