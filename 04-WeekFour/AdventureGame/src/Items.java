public abstract class Items {
    private int id;
    private String name;
    private int damage;
    private int healing;
    private int price;

    public Items(int id, String name, int damage, int healing, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.healing = healing;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
