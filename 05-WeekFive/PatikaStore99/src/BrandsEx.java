import java.util.TreeMap;

public class BrandsEx {
    private int brandsID;
    private String brandsName;

    private TreeMap<Integer, String> brandList = new TreeMap<>();

    public BrandsEx() {
    }

    public TreeMap<Integer, String> getBrandList() {
        return brandList;
    }

    public void setBrandList(int ID, String name) {
        this.brandList.putIfAbsent(ID, name);
    }

    public int getBrandsID() {
        return brandsID;
    }

    public void setBrandsID(int brandsID) {
        this.brandsID = brandsID;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }
}
