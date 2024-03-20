import java.util.HashMap;
import java.util.Map;

public class Products extends Brands{
    private int productID;
    private int productName;
    private Map<Integer,String> productDB = new HashMap<>();

    public Map<Integer, String> getProductDB() {
        return productDB;
    }

    public void setProductDB(int ID, String name) {
        this.productDB.put(ID,name);
    }

    public Integer getProductID(String name) {
        for (Map.Entry<Integer, String> entry : productDB.entrySet()) {
            if (entry.getValue().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
