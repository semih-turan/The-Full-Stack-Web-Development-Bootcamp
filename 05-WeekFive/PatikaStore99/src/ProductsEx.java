public abstract class ProductsEx extends BrandsEx {
    private int productID;
    private String productName;
    private int discount;
    private int stockAmount;
    private int unitCost;
    public ProductsEx(int ID, String name, int productID, String productName, int discount, int stockAmount, int unitCost) {
        this.productID = productID;
        this.productName = productName;
        this.discount = discount;
        this.stockAmount = stockAmount;
        this.unitCost = unitCost;
    }
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }
}
