public class CellPhones extends ProductsEx {
    private int memory;
    private double screenSize;
    private int batteryCapacity;
    private int ram;
    private String color;

    public CellPhones(int ID, String name, int productID, String productName, int discount, int stockAmount, int unitCost, int memory, double screenSize, int batteryCapacity, int ram, String color) {
        super(ID, name, productID, productName, discount, stockAmount, unitCost);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryCapacity = batteryCapacity;
        this.ram = ram;
        this.color = color;
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

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
