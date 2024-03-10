public class Dungeon extends Location{
    public Dungeon() {
        super("Nehir", "Zombi", 5, 1);
    }

    @Override
    public boolean getLocation() {
        return false;
    }
}
