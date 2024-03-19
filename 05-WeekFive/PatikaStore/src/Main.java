/**
 * PatikaStore Product Management System
 * Author: Semih Turan
 * Since: March 2024
 */
import java.util.*;
public class Main {
    static HashMap<Integer, Brand> brands = new HashMap<>();
    static HashMap<Integer, Product> products = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createBrand();
        createProduct();

        int select = -1;
        while (select != 0) {
            System.out.println("PatikaStore Product Management Panel");
            System.out.println("1 - Notebook Panel");
            System.out.println("2 - Smartphone Panel");
            System.out.println("3 - Brand List");
            System.out.println("0 - Exit");
            System.out.print("Select : ");
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    notebookPanel();
                    break;
                case 2:
                    smartphonePanel();
                    break;
                case 3:
                    listBrand();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
        scanner.close();
    }

    // Method to create some initial brand objects
    static void createBrand() {
        brands.put(1, new Brand(1, "Samsung"));
        brands.put(2, new Brand(2, "Lenovo"));
        brands.put(3, new Brand(3, "Apple"));
        brands.put(4, new Brand(4, "Huawei"));
        brands.put(5, new Brand(5, "Casper"));
        brands.put(6, new Brand(6, "Asus"));
        brands.put(7, new Brand(7, "HP"));
        brands.put(8, new Brand(8, "Xiaomi"));
        brands.put(9, new Brand(9, "Monster"));
    }

    // Method to create some initial product objects
    static void createProduct() {
        products.put(1, new Notebook(1, 7000.0, 0.0, 10, "HUAWEI Matebook 14", brands.get(4), 16, 512, 14.0));
        products.put(2, new Notebook(2, 3699.0, 0.0, 20, "LENOVO V14 IGL", brands.get(2), 8, 1024, 14.0));
        products.put(3, new Notebook(3, 8199.0, 0.0, 15, "ASUS Tuf Gaming", brands.get(6), 32, 2048, 15.6));

        products.put(4, new SmartPhone(4, 3199.0, 0.0, 30, "SAMSUNG GALAXY A51", brands.get(1), 128, 6.5, 32, 4000.0, 6, "Black"));
        products.put(5, new SmartPhone(5, 7379.0, 0.0, 25, "iPhone 11 64 GB", brands.get(3), 64, 6.1, 5, 3046.0, 6, "Blue"));
        products.put(6, new SmartPhone(6, 4012.0, 0.0, 35, "Redmi Note 10 Pro 8GB", brands.get(8), 128, 6.5, 35, 4000.0, 12, "White"));
    }

    // Method to list available brands
    static void listBrand() {
        System.out.println("Brands\n--------------");
        for (Map.Entry<Integer, Brand> entry : brands.entrySet()) {
            System.out.println("- " + entry.getValue().name);
        }
    }

    // Method to handle notebook panel operations
    static void notebookPanel() {
        int select = -1;
        while (select != 0) {
            System.out.println("\nNotebook Panel");
            System.out.println("1 - List Notebooks");
            System.out.println("2 - Add Notebook");
            System.out.println("3 - Update Notebook");
            System.out.println("4 - Delete Notebook");
            System.out.println("0 - Main Menu");
            System.out.print("Select : ");
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    listNotebook();
                    break;
                case 2:
                    addNotebook();
                    break;
                case 3:
                    updateNotebook();
                    break;
                case 4:
                    deleteNotebook();
                    break;
                case 0:
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid Selection!");
            }
        }
    }

    // Method to handle smartphone panel operations
    static void smartphonePanel() {
        int select = -1;
        while (select != 0) {
            System.out.println("\nSmartphone Panel");
            System.out.println("1 - List Smartphones");
            System.out.println("2 - Add Smartphone");
            System.out.println("3 - Update Smartphone");
            System.out.println("4 - Delete Smartphone");
            System.out.println("0 - Main Menu");
            System.out.print("Selection : ");
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    listSmartphone();
                    break;
                case 2:
                    addSmartphone();
                    break;
                case 3:
                    updateSmartphone();
                    break;
                case 4:
                    deleteSmartphone();
                    break;
                case 0:
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid Selection!");
            }
        }
    }

    // Method to list smartphones
    static void listSmartphone() {
        System.out.println("\nSmartphone List\n");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                     | Price     | Brand     | Storage    | Screen Size | Camera | Battery | RAM | Color     |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            if (product instanceof SmartPhone smartPhone) {
                System.out.printf("| %-2d | %-32s | %-9.2f | %-9s | %-10d | %-11.1f | %-6d | %-7.1f | %-3d | %-9s |\n",
                        smartPhone.id, smartPhone.productName, smartPhone.unitPrice, smartPhone.brand.name,
                        smartPhone.storage, smartPhone.screenSize, smartPhone.camera, smartPhone.battery, smartPhone.ram, smartPhone.color);
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }

    // Method to add a new smartphone
    static void addSmartphone() {
        System.out.println("Add Smartphone");
        System.out.print("Product Name: ");
        String productName = scanner.next();
        System.out.print("Unit Price: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Discount Ratio: ");
        double discountRatio = scanner.nextDouble();
        System.out.print("Stock Quantity: ");
        int stockQuantity = scanner.nextInt();
        System.out.print("Brand ID: ");
        int brandId = scanner.nextInt();
        Brand brand = brands.get(brandId);
        System.out.print("Storage: ");
        int storage = scanner.nextInt();
        System.out.print("Screen Size: ");
        double screenSize = scanner.nextDouble();
        System.out.print("Camera: ");
        int camera = scanner.nextInt();
        System.out.print("Battery: ");
        double battery = scanner.nextDouble();
        System.out.print("RAM: ");
        int ram = scanner.nextInt();
        System.out.print("Color: ");
        String color = scanner.next();

        int newProductId = brands.size() + 1;
        products.put(newProductId, new SmartPhone(newProductId, unitPrice, discountRatio, stockQuantity, productName, brand, storage, screenSize, camera, battery, ram, color));
        System.out.println("New mobile phone added successfully!");
    }

    // Method to update smartphone information
    static void updateSmartphone() {
        System.out.println("Update Smartphone");
        System.out.print("Enter the product ID to update: ");
        int productId = scanner.nextInt();
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            if (product instanceof SmartPhone smartphone) {
                System.out.print("New Product Name: ");
                smartphone.productName = scanner.next();
                System.out.print("New Unit Price: ");
                smartphone.unitPrice = scanner.nextDouble();
                System.out.print("New Discount Ratio: ");
                smartphone.discountRatio = scanner.nextDouble();
                System.out.print("New Stock Quantity: ");
                smartphone.stockQuantity = scanner.nextInt();
                System.out.print("New Storage: ");
                smartphone.storage = scanner.nextInt();
                System.out.print("New Screen Size: ");
                smartphone.screenSize = scanner.nextDouble();
                System.out.print("New Camera: ");
                smartphone.camera = scanner.nextInt();
                System.out.print("New Battery: ");
                smartphone.battery = scanner.nextDouble();
                System.out.print("New RAM: ");
                smartphone.ram = scanner.nextInt();
                System.out.print("New Color: ");
                smartphone.color = scanner.next();
                System.out.println("The mobile phone has been updated successfully!");
            } else {
                System.out.println("No mobile phone found with this ID.");
            }
        }
    }

    // Method to delete a smartphone
    static void deleteSmartphone() {
        System.out.println("Delete Smartphone");
        System.out.print("Enter the product ID to be deleted: ");
        int productId = scanner.nextInt();
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("The product was successfully deleted!");
        } else {
            System.out.println("No product with this ID was found.");
        }
    }

    // Method to list notebooks
    static void listNotebook() {
        System.out.println("\nNotebook List\n");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                   | Price     | Brand     | Storage  | Screen Size | RAM |");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            if (product instanceof Notebook notebook) {
                System.out.printf("| %-2d | %-30s | %-9.2f | %-9s | %-8d | %-11.1f | %-3d |\n",
                        notebook.id, notebook.productName, notebook.unitPrice, notebook.brand.name, notebook.storage, notebook.screenSize, notebook.ram);
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    // Method to delete a notebook
    static void deleteNotebook() {
        System.out.println("Delete Notebook");
        System.out.print("Enter the product ID to be deleted: ");
        int productId = scanner.nextInt();
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("The product was successfully deleted!");
        } else {
            System.out.println("No product found with this ID.");
        }
    }

    // Method to update notebook information
    static void updateNotebook() {
        System.out.println("Update Notebook");
        System.out.print("Enter the product ID to update: ");
        int productId = scanner.nextInt();
        if (products.containsKey(productId)) {
            Product  product = products.get(productId);
            if (product instanceof Notebook notebook) {
                System.out.print("New Product Name: ");
                notebook.productName = scanner.next();
                System.out.print("New Unit Price: ");
                notebook.unitPrice = scanner.nextDouble();
                System.out.print("New Discount Ratio: ");
                notebook.discountRatio = scanner.nextDouble();
                System.out.print("New Stock Quantity: ");
                notebook.stockQuantity = scanner.nextInt();
                System.out.print("New Storage: ");
                notebook.storage = scanner.nextInt();
                System.out.print("New Screen Size: ");
                notebook.screenSize = scanner.nextDouble();
                System.out.print("New Ram: ");
                notebook.ram = scanner.nextInt();
                System.out.println("Notebook updated successfully!");
            } else {
                System.out.println("No notebook with this ID was found.");
            }
        }
    }

    // Method to add a new notebook
    static void addNotebook() {
        System.out.println("Add Notebook");
        System.out.print("Product Name: ");
        String productName = scanner.next();
        scanner.next();
        System.out.print("Unit Price: ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Discount Ratio: ");
        double discountRatio = scanner.nextDouble();
        System.out.print("Stock Quantity: ");
        int stockQuantity = scanner.nextInt();
        System.out.print("Brand ID: ");
        int brandId = scanner.nextInt();
        Brand brand = brands.get(brandId);
        System.out.print("Storage: ");
        int storage = scanner.nextInt();
        System.out.print("Screen Size: ");
        double screenSize = scanner.nextDouble();
        System.out.print("RAM: ");
        int ram = scanner.nextInt();

        int newProductId = products.size() + 1;
        products.put(newProductId, new Notebook(newProductId, unitPrice, discountRatio, stockQuantity, productName, brand, ram, storage, screenSize));
        System.out.println("New notebook added successfully!");
    }
}

// Brand class to represent a brand
class Brand {
    int id;
    String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Product class to represent a product
class Product {
    int id;
    double unitPrice;
    double discountRatio;
    int stockQuantity;
    String productName;
    Brand brand;

    public Product(int id, double unitPrice, double discountRatio, int stockQuantity, String productName, Brand brand) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.discountRatio = discountRatio;
        this.stockQuantity = stockQuantity;
        this.productName = productName;
        this.brand = brand;
    }
}

// Notebook class representing a notebook product, inheriting from Product class
class Notebook extends Product {
    int ram;
    int storage;
    double screenSize;

    public Notebook(int id, double unitPrice, double discountRatio, int stockQuantity, String productName, Brand brand, int ram, int storage, double screenSize) {
        super(id, unitPrice, discountRatio, stockQuantity, productName, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }
}

// SmartPhone class representing a smartphone product, inheriting from Product class
class SmartPhone extends Product {
    int storage;
    double screenSize;
    int camera;
    double battery;
    int ram;
    String color;

    public SmartPhone(int id, double unitPrice, double discountRatio, int stockQuantity, String productName, Brand brand, int storage, double screenSize, int camera, double battery, int ram, String color) {
        super(id, unitPrice, discountRatio, stockQuantity, productName, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.camera = camera;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }
}