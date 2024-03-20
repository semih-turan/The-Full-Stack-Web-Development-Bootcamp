import java.util.HashMap;
import java.util.Map;

public class Brands {
    private String brandID;
    private String brandName;
    private Map<String,String> brandDB = new HashMap<>();

    public Map<String, String> getBrandDB(String brandName) {
        return brandDB;
    }
    public void setBrandDB(String ID, String name) {
        this.brandDB.put(ID,name);
    }

    public Integer getBrandID(String name) {
        for (Map.Entry<String, String> entry : brandDB.entrySet()) {
            if (entry.getValue().equals(name)) {
                return entry.getKey();
            }
        }
        return null; // Marka ismi bulunamazsa null döndürür
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
