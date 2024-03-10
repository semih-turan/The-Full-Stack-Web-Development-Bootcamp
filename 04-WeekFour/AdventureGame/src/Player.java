import java.util.Scanner;
public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    Scanner input = new Scanner(System.in);

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Player(String name) {
        this.name = name;
    }

    public void selectChar(){
        int selectChar;
        boolean isSelect = false;
        do{
            // User input validation
            while(!input.hasNextInt()){
                System.out.println("Lutfen gecerli bir numara girin!");
                System.out.print("Karakter seciniz:  ");
                input.next();
            }
            selectChar = input.nextInt();
            if(selectChar > 3 || selectChar < 1){
                System.out.println("Lutfen 1 ile 3 arasinda bir secim yapiniz!");
                System.out.print("Karakter seciniz:  ");
            }else{
                isSelect =true;
            }
        }while(!isSelect);

        switch (selectChar){
            case 1:
                initPlayer(new Geralt());
                break;
            case 2:
                initPlayer(new Ciri());
                break;
            case 3:
                initPlayer(new Yennefer());
                break;
        }

        System.out.println("\n"+this.getName() + " ,baslangic icin çok iyi bir secim yaptin...\n");
    }

    public void selectLoc(){

    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
}
