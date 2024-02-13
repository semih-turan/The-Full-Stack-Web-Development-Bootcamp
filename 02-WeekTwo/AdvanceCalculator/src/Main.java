/**
 * @author Semih Turan
 * @since february 2024
 */
import java.util.Scanner;
public class Main {
    // Plus operator
    static void plus() {
        // Declare variable and scanner
        Scanner scan = new Scanner(System.in);
        int number, result = 0, increment = 1;
        System.out.print("How many numbers do you want to enter? ");
        int countNumber = scan.nextInt();
        // Adding loop
        while (increment<=countNumber) {
            System.out.print(increment++ + ". number :");
            number = scan.nextInt();
            if (number == 0) {
                break;
            }
            result += number;
        }
        // Printing result
        System.out.println("Result : " + result);
    }

    // Minus operator
    static void minus() {
        // Declare variable and scanner
        Scanner scan = new Scanner(System.in);
        System.out.print("How many numbers do you want to enter? ");
        int countNumber = scan.nextInt();
        int number, result = 0;

        // Minus loop
        for (int increment = 1; increment <= countNumber; increment++) {
            System.out.print(increment + ". number :");
            number = scan.nextInt();
            if (increment == 1) {
                result += number;
                continue;
            }
            result -= number;
        }
        // Printing result
        System.out.println("Result : " + result);
    }
    // Times operator
    static void times() {
        // Declare variable and scanner
        Scanner scan = new Scanner(System.in);
        int number, result = 1, increment = 1;
        System.out.print("How many numbers do you want to enter? ");
        int countNumber = scan.nextInt();

        // Times loop
        while (increment<=countNumber) {
            System.out.print(increment++ + ". number :");
            number = scan.nextInt();

            if (number == 1)
                break;
            if (number == 0) {
                result = 0;
                break;
            }
            result *= number;
        }
        // Printing result
        System.out.println("Result : " + result);
    }

    // Divide operator
    static void divided() {
        // Declare variable and scanner
        Scanner scan = new Scanner(System.in);
        System.out.print("How many numbers do you want to enter? ");
        int countNumber = scan.nextInt();
        double number, result = 0.0;
        // Dividing loop
        for (int increment = 1; increment <= countNumber; increment++) {
            System.out.print(increment + ". number :");
            number = scan.nextDouble();
            if (increment != 1 && number == 0) {
                System.out.println("0 is invalid.");
                continue;
            }
            if (increment == 1) {
                result = number;
                continue;
            }
            result /= number;
        }
        // Printing result
        System.out.println("Result : " + result);
    }

    // Calculates power of number
    static void power() {
        // Declare variable and scanner
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter base value :");
        int base = scan.nextInt();
        System.out.print("Please enter power value :");
        int exponent = scan.nextInt();
        int result = 1;

        // Calculating power of number
        for (int increment = 1; increment <= exponent; increment++) {
            result *= base;
        }
        // Printing result
        System.out.println("Result : " + result);
    }

    // Calculate factorial
    static void factorial() {
        // Declare variable and scanner
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter number :");
        int n = scan.nextInt();
        int result = 1;
        // Calculating factorial
        for (int increment = 1; increment <= n; increment++) {
            result *= increment;
        }
        // Printing result
        System.out.println("Result : " + result);
    }

    // Calculate modulus of number
    static void modulus(){
        // Declare variable and scanner
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter modulus of ... : ");
        int number = scan.nextInt();
        System.out.print("Please enter with respect to ... : ");
        int wrtNumber = scan.nextInt();
        // Printing result
        System.out.println("Result: " + number%wrtNumber);
    }

    // Calculate rectangle area and perimeter
    static void rectangleAreaAndPerimeter(){
        // Declare variable and scanner
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter one side of rectangle: ");
        int sideOne = scan.nextInt();
        System.out.print("Please enter another side of rectangle: ");
        int sideTwo = scan.nextInt();
        // Printing result
        System.out.println("Results: ");
        System.out.println("Area : " +sideOne*sideTwo);
        System.out.println("Perimeter: " + (sideOne+sideTwo)*2);
    }

    // Show menu
    static void showMenu(){
        String menu = """
                1- Addition operation
                2- Subtraction operation
                3- Multiplication operation
                4- Division operation
                5- Exponential calculation
                6- Factorial calculation
                7- Modulus calculation
                8- Rectangle area and perimeter calculation
                0- Exit""";
        System.out.println(menu);
    }
    public static void main(String[] args) {
        // Declare variable and define scanner
        Scanner scan = new Scanner(System.in);
        int select;
        // Menu Selection
        do {
            showMenu();
            System.out.print("Please select an action:");
            select = scan.nextInt();
            switch (select) {
                case 1:
                    plus();
                    break;
                case 2:
                    minus();
                    break;
                case 3:
                    times();
                    break;
                case 4:
                    divided();
                    break;
                case 5:
                    power();
                    break;
                case 6:
                    factorial();
                    break;
                case 7:
                    modulus();
                    break;
                case 8:
                    rectangleAreaAndPerimeter();
                    break;
                default:
                    System.out.println("You entered an incorrect value, try again.");
            }
        } while (select != 0);
    }
}