import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class ManagementPanel{
    static Scanner input = new Scanner(System.in);

    public static void run(){
        while(true) {
            Products products = new Products();
            Notebooks notebooks = new Notebooks();
            notebooks.setBrandDB(1,"Apple");
            notebooks.setBrandDB(2,"ZamZung!");
            notebooks.setProductDB(10,"Notebook");
            int choose = 0;

            ArrayList<Notebooks> notebookList = new ArrayList<>();
            if(choose == 1 ){
                brandsName = notebooks.getBrandName(1);
            }
            notebookList.add(new Notebooks(1,"Samsung",1,10,100,"Macbook Pro",8,128,14));


            System.out.println(notebooks.getBrandID("ZamZung!"));

            for (Notebooks notebook : notebookList) {
                System.out.println(notebook);
            }

            System.out.println("Patika Store Product Management Panel");
            System.out.println("=====================================");
            System.out.println("1-Notebook Settings\n" +
                               "2-SmartPhone Settings\n" +
                               "3-List Brands\n" +
                               "0-Exit\n");

            System.out.print("Please select: ");

            switch (input.nextInt()) {
                case 1:
                    int selection = -1;
                    while(selection != 0){
                        System.out.println("1-Add Notebook");
                        System.out.println("2-Delete Notebook");
                        System.out.println("3-List Notebook");
                        System.out.println("0-Previous Menu\n");
                        System.out.print("Please select: ");

                        selection = input.nextInt();

                        switch(selection){
                            case 1:
                                System.out.println("Add Notebook\n");

                                System.out.print("Please enter notebook Id: ");
                                int id = input.nextInt();
                                input.nextLine();

                                System.out.print("Please enter notebook name: ");
                                String name = input.nextLine();

                                System.out.print("Please enter productId: ");
                                int productId = input.nextInt();

                                System.out.print("Please enter productName: ");
                                String productName = input.nextLine();

                                System.out.print("Please enter brandsName: ");
                                String brandsName = input.nextLine();

                                System.out.print("Please enter discount: ");
                                int discount = input.nextInt();

                                System.out.print("Please enter stockAmount: ");
                                int stockAmount = input.nextInt();

                                System.out.print("Please enter unitCost: ");
                                int unitCost = input.nextInt();


                                System.out.println("Successfully added! ");
                                break;
                            case 2:
                                System.out.println("Delete Notebook\n");
                                break;
                            case 3:
                                System.out.println("List Notebook\n");
                                break;
                            case 0:
                                System.out.println("Previous Menu\n");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Go to smartPhone\n");
                    break;
                case 3:
                    System.out.println("Go to brand list\n");
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }

        }

    }
}