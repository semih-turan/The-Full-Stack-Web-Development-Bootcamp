import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
public class  Notebooks extends Products {
    private int ID;
    private int unitPrice;
    private int discount;
    private int stockQuantity;
    private String name;
    private String brandsName;

    private int ram;
    private int memory;
    private double screenSize;

    public Notebooks(int ID, String brandsName, int unitPrice, int discount, int stockQuantity, String name, int ram, int memory, double screenSize) {
        this.ID = ID;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.stockQuantity = stockQuantity;
        this.name = name;
        this.ram = ram;
        this.memory = memory;
        this.screenSize = screenSize;
    }

    public Notebooks() {}

    public String toString() {
        return "ID: " + ID +
                ", Name: " + name +
                ", Price: " + unitPrice +
                ", Discount: " + discount +
                ", Stock: " + stockQuantity +
                ", RAM: " + ram +
                "GB, Storage: " + memory +
                "GB, Screen Size: " + screenSize + " inch";
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
