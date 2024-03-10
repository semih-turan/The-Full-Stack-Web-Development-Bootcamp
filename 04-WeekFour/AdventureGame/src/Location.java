import java.util.Scanner;

public abstract class Location {
    protected static Scanner input;
    protected Player player;
    protected String name;
    protected String hostileName;
    protected int hostileDamage;
    protected int hostileHealth;

    Location(Player player){
        this.player = player;
    }
    Location(String name, String hostileName, int hostileDamage, int hostileHealth){
        this.name = name;
        this.hostileName = hostileName;
        this.hostileDamage = hostileDamage;
        this.hostileHealth = hostileHealth;
    }

    public abstract boolean getLocation();

    public String getHostileName() {
        return hostileName;
    }

    public void setHostileName(String hostileName) {
        this.hostileName = hostileName;
    }

    public int getHostileDamage() {
        return hostileDamage;
    }

    public void setHostileDamage(int hostileDamage) {
        this.hostileDamage = hostileDamage;
    }

    public int getHostileHealth() {
        return hostileHealth;
    }

    public void setHostileHealth(int hostileHealth) {
        this.hostileHealth = hostileHealth;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}