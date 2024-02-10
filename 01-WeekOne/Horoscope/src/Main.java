/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Declare variables
        int month, day;

        // Prompting inputs
        System.out.println("Please enter your birth day: ");
        day = input.nextInt();
        input.nextLine();
        System.out.println("Please enter your birth month: ");
        month = input.nextInt();
        input.nextLine();

        // Deciding horoscope and printing result
        if((month == 1) && (day<=31 && day >=22)){
            System.out.println("Your horoscope is Aquarius.");
        } else if ((month == 1) && (day<=21 && day >=1)){
            System.out.println("Your horoscope is Capricorn.");
        } else if ((month == 2) && (day<=28 && day >=20)){
            System.out.println("Your horoscope is Pisces.");
        } else if ((month == 2) && (day<=19 && day >=1)){
             System.out.println("Your horoscope is Aquarius.");
        } else if ((month == 3) && (day<=31 && day >=21)){
            System.out.println("Your horoscope is Aries.");
        } else if ((month == 3) && (day<=20 && day >=1)){
            System.out.println("Your horoscope is Pisces.");
        } else if ((month == 4) && (day<=31 && day >=21)){
            System.out.println("Your horoscope is Taurus .");
        } else if ((month == 4) && (day<=20 && day >=1)){
            System.out.println("Your horoscope is Aries.");
        } else if ((month == 5) && (day<=31 && day >=22)){
            System.out.println("Your horoscope is Gemini.");
        } else if ((month == 5) && (day<=21 && day >=1)){
            System.out.println("Your horoscope is Taurus .");
        } else if ((month == 6) && (day<=31 && day >=23)){
            System.out.println("Your horoscope is Cancer.");
        } else if ((month == 6) && (day<=22 && day >=1)){
            System.out.println("Your horoscope is Gemini.");
        } else if ((month == 7) && (day<=31 && day >=23)){
            System.out.println("Your horoscope is Leo.");
        } else if ((month == 7) && (day<=22 && day >=1)){
            System.out.println("Your horoscope is Cancer.");
        } else if ((month == 8) && (day<=31 && day >=23)){
            System.out.println("Your horoscope is Virgo.");
        } else if ((month == 8) && (day<=22 && day >=1)){
            System.out.println("Your horoscope is Leo.");
        } else if ((month == 9) && (day<=31 && day >=23)){
            System.out.println("Your horoscope is Libra.");
        } else if ((month == 9) && (day<=22 && day >=1)){
            System.out.println("Your horoscope is Virgo.");
        } else if ((month == 10) && (day<=31 && day >=22)){
            System.out.println("Your horoscope is Scorpio.");
        } else if ((month == 10) && (day<=22 && day >=1)){
            System.out.println("Your horoscope is Libra.");
        } else if ((month == 11) && (day<=31 && day >=22)){
            System.out.println("Your horoscope is Sagittarius.");
        } else if ((month == 11) && (day<=21 && day >=1)){
            System.out.println("Your horoscope is Scorpio.");
        } else if ((month == 12) && (day<=31 && day >=22)){
            System.out.println("Your horoscope is Capricorn.");
        } else if ((month == 12) && (day<=21 && day >=1)){
            System.out.println("Your horoscope is Sagittarius.");
        } else {
            System.out.println("Invalid date!");
        }
    }
}