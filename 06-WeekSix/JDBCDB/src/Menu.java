import java.util.Scanner;

public class Menu {
    // Method to display the menu and handle user input
    public void showMenu()  {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to JDBC Database");
        System.out.println("Please select: ");
        while(true){
            System.out.println("1- List Data");
            System.out.println("2- Add Data");
            System.out.println("3- Delete Data");
            System.out.println("4- Update Data");
            System.out.println("5- Exit...\n");

            System.out.print("Select: ");
            int select = input.nextInt();
            switch (select){
                case 1:
                    // List data option
                    DBConnection.getData();
                    System.out.println("1 selected\n");
                    break;
                case 2:
                    // Add data option
                    System.out.println("2 selected");
                    System.out.print("Enter id: ");
                    int id = input.nextInt();
                    input.nextLine(); // Buffer Cleaner
                    System.out.print("Enter name: ");
                    String name = input.nextLine();
                    System.out.print("Enter position: ");
                    String position = input.nextLine();
                    System.out.print("Enter salary: ");
                    int salary = input.nextInt();
                    DBConnection.addData(id,name,position,salary);
                    break;
                case 3:
                    // Delete data option
                    System.out.println("3 selected");
                    System.out.println("Enter id: ");
                    int idDeleted = input.nextInt();
                    DBConnection.deleteData(idDeleted);
                    break;
                case 4:
                    // Update data option
                    System.out.println("4 selected");
                    System.out.print("Enter id: ");
                    int idUpdate = input.nextInt();
                    input.nextLine(); // Buffer Cleaner
                    System.out.print("Enter name: ");
                    String nameUpdate = input.nextLine();
                    System.out.print("Enter position: ");
                    String positionUpdate = input.nextLine();
                    System.out.print("Enter salary: ");
                    int salaryUpdate = input.nextInt();
                    DBConnection.updateData(idUpdate,nameUpdate,positionUpdate,salaryUpdate);
                    break;
                case 5:
                    // Exit option
                    System.out.println("Leaving...");
                    System.exit(0);
                default:
                    // Handling unexpected input
                    throw new IllegalStateException("Unexpected value: " + select);
            }
        }
    }
}
