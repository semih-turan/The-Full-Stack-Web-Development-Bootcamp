import java.util.Scanner;
public class Toolstore extends NormalLocation{

    Toolstore(Player player) {
        super(player, "Market");
    }

    // Print market menu
    public void printMenu(){
        System.out.println("Market'e Hoşgeldiniz! ");
        System.out.println("1-Ekmek");
        System.out.println("2-Silah");
        System.out.println("3-Zirh");
        System.out.println("4-Market'ten Ayrıl");
        System.out.println("5-Oyun'u kapat!");
    }

    // Buy method
    public void buy(){
        Food food = new Food();
        Weapon weapon = new Weapon();
        Armor armor = new Armor();
        Scanner scan = new Scanner(System.in);

        int selectItem = 0;
        boolean isFinish=false;

        while(!isFinish){
            printMenu();
            selectItem = scan.nextInt();

            if(player.getMoney() <= 0 ){
                System.out.println("Paran kalmadi!");
                break;
            }
            switch (selectItem){
                case 1:
                    if(player.getMoney()<food.getPrice()){
                        System.out.println("Ekmek alacak paran yok!");
                        break;
                    }
                    player.setHealth(player.getHealth()+food.getHealing());
                    player.setMoney(player.getMoney()-food.getPrice());
                    System.out.println("Saglik: "+ player.getHealth());
                    System.out.println("Para: " + player.getMoney());
                    break;
                case 2:
                    if(player.getMoney() < weapon.getPrice() ){
                        System.out.println("Silah alacak paran yok!");
                        break;
                    }
                    player.setDamage(player.getDamage()+weapon.getDamage());
                    player.setMoney(player.getMoney()-weapon.getPrice());
                    System.out.println("Hasar: "+ player.getDamage());
                    System.out.println("Para: " + player.getMoney());
                    break;
                case 3:
                    if(player.getMoney() < armor.getPrice() ){
                        System.out.println("Zirh alacak paran yok!");
                        break;
                    }
                    player.setHealth(player.getHealth()+armor.getHealing());
                    player.setMoney(player.getMoney()-armor.getPrice());
                    System.out.println("Saglik: "+ player.getHealth());
                    System.out.println("Para: " + player.getMoney());
                    break;
                case 4:
                    System.out.println("Marketten ayriliyorsunuz...");
                    isFinish =true;
                    break;
                case 5:
                    System.out.println("Oyundan ayriliyorsunuz...");
                    System.exit(0);
                    break;
            }
        }

    }
}
