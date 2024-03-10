
public class SafeHouse extends NormalLocation {

    SafeHouse(Player player) {
        super(player, "Guvenli Ev");
    }

    public boolean getLocation() {
        System.out.println("Suan Guvenli Ev'desiniz...");
        if(player.getHealth()>=100){
            System.out.println("Güvenli evin keyfini cikar...");
            System.out.println("Sağlığınız: " + player.getHealth());
            System.out.println("Paranız: " + player.getMoney());
            System.out.println("Hasarınız: " + player.getDamage());
        }else{
            player.setHealth(player.getHealth()*25/100+ player.getHealth());
            if(player.getHealth()>100){
                player.setHealth(100);
            }
            System.out.println("Sağlığınız: " + player.getHealth());
            System.out.println("Iyilestiniz...");
        }
        return true;
    }

}
