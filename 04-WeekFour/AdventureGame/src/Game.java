import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);
    private int forestCount = 0;
    private int caveCount = 0;
    private int riverCount = 0;

    // Start game method
    public void start(){
        int speed = 50;
        Random random = new Random();
        printSlowMotion("Kullanıcı adınızı giriniz: ", speed);
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        printSlowMotion("Değerli "+ player.getName().toUpperCase() + " bu karanlık ve sisli adaya hoşgeldin...\n",speed);
        System.out.println("##################################################################");
        printLogo();
        System.out.println("##################################################################\n\n");
        printSlowMotion("Karanlık bir dönemde, dünya kaos ve tehlikeyle sarılmışken, bir kahramanın\n", speed);
        printSlowMotion("çağrısı yankılanıyor. Hangi kaderin onu beklediğini bilmeden, seçimlerinin\n",speed);
        printSlowMotion("ağırlığı altında, bu kahramanın adı dilden dile dolaşıyor:\n\n",speed);
        printSlowMotion("1-Geralt \n2-Ciri \n3-Yennefer\n\n",speed);
        printSlowMotion("Siz, bu kahramanlardan birini seçmelisiniz.\n", speed);
        printSlowMotion("Karakterini seç (1,2 veya 3): ",speed);

        player.selectChar();
        // Create classes
        SafeHouse safeHouse = new SafeHouse(player);
        Toolstore toolStore = new Toolstore(player);
        AbandonTower abandonTower = new AbandonTower();
        Cave cave = new Cave();
        Dungeon dungeon = new Dungeon();

        while(true){
            if(forestCount > 0 && caveCount > 0 && riverCount > 0){ // Win condition
                System.out.println("Oyunu kazandınız!");
                System.exit(0);
            }
            // Print menu
            System.out.println("##################################################################");
            System.out.println("-----------------------BOLGELER-----------------------------------");
            System.out.println("##################################################################");
            printSlowMotion("1- Yedi Kediler Hanı [Guvenli Yer]\n",speed);
            printSlowMotion("2- Hattori [Tuccar]\n",speed);
            printSlowMotion("3- Terkedilmis Kule [Savas]\n",speed);
            printSlowMotion("4- Magara [Savas]\n",speed);
            printSlowMotion("5- Zindan [Savas]\n",speed);
            printSlowMotion("6- Cikis yap...\n",speed);
            printSlowMotion("Lutfen gitmek istediginiz bolgeyi seciniz: \n",speed);

            int selectLoc;
            boolean isSelect = false; // Flag for menu selection
            do{
                // User input validation
                while(!input.hasNextInt()){ // Accept only integer character
                    printSlowMotion("Lutfen gecerli bir numara girin!\n",speed);
                    printSlowMotion("Karakter seciniz:  \n",speed);
                    input.next();
                }
                selectLoc = input.nextInt();
                if(selectLoc > 6 || selectLoc < 1){
                    printSlowMotion("Lutfen 1 ile 6 arasinda bir secim yapiniz!\n",speed);
                    printSlowMotion("Karakter seciniz:  \n",speed);
                }else{
                    isSelect =true;
                }
            }while(!isSelect);

            switch (selectLoc){
                case 1: // Go to safehouse
                    safeHouse.getLocation();
                    break;
                case 2: // Go to toolstore
                    toolStore.buy();
                    break;
                case 3: // Go to abandon tower
                    int firstAttackForest = random.nextInt(1,3); // Random generator for decide first attacker
                    while(true){
                        printSlowMotion(player.getCharName()+ " eski dostu Tris ile karşılaştı.\n",speed);
                        printSlowMotion(player.getCharName()+ "Tris, seninle burada karşılaşmak sürpriz oldu.\n",speed);
                        printSlowMotion("Tris: "+ player.getCharName()+" , seninle her zaman isbirligi yapmaktan memnuniyet duyarim. Ancak, bu sefer isler biraz karmasik.\n",speed);
                        printSlowMotion("Dis ses: wuuuuuwwww...wuwuwuwwww..\n",speed);
                        printSlowMotion("Terkedilmiş kulede, "+ player.getCharName()+ " eski dostu Werewolf ile karşılaştı. Ancak, bu dostu artık bir lanetin pençesinde.\n",speed);
                        printSlowMotion("Tris: "+player.getCharName()+ " , Kaer Morhen'da kurtlar 101 dersinde değiliz!\n",speed);
                        printSlowMotion(player.getCharName()+ "Tris, sözlerine dikkat et!. Werewolf benim eski bir dostum...\n",speed);
                        printSlowMotion("Werewolf: "+ player.getCharName()+ " , bana yardim etmelisin. Kule'de bir cadi var. Iksiri icin kanıma ihtiyaci var.\n",speed);
                        printSlowMotion(player.getCharName()+ ": Kimse sana zarar vermez. Hadi gidelim...\n",speed);
                        printSlowMotion("...  ... ... ...",speed);
                        printSlowMotion("Cadi gorundu.! Saldirin!\n",speed);
                        printSlowMotion("Dusman: "+ abandonTower.getHostileName()+"\n",speed);
                        printSlowMotion("Hasar: " + abandonTower.getHostileDamage()+"\n",speed);
                        printSlowMotion("Saglik: " + abandonTower.getHostileHealth()+"\n",speed);
                        while(true){
                            if(firstAttackForest == 1){ // First attacker is player
                                abandonTower.setHostileHealth(abandonTower.getHostileHealth()- player.getDamage());
                                System.out.println("Düşman cani: " + abandonTower.getHostileHealth()+"\n");
                                player.setHealth(player.getHealth()- abandonTower.getHostileDamage());
                                System.out.println("Kalan can: " + player.getHealth()+"\n");
                                if(player.getHealth()<0 || abandonTower.getHostileHealth() < 0 ){
                                    if(player.getHealth()> abandonTower.getHostileHealth()){
                                        printSlowMotion(player.getName()+" kazandin! Terkedilmis Kule'de Cadi'yi oldurdun!\n",speed);
                                        player.setMoney(player.getMoney()+20);
                                        abandonTower.setHostileHealth(100);
                                        printSlowMotion("Kazanilan odul: " + player.getMoney() + " kadar para kazandin.\n",speed);
                                        forestCount++;
                                        break;
                                    }else{
                                        printSlowMotion("Kaybettiniz!\n",speed);
                                        printSlowMotion("Çıkış yapılıyor...\n",speed);
                                        System.exit(0);
                                    }
                                }
                            }else{ // Hostile is first attacker
                                player.setHealth(player.getHealth() - abandonTower.getHostileDamage());
                                printSlowMotion("Kalan canin: " + player.getHealth()+"\n",speed);
                                abandonTower.setHostileHealth(abandonTower.getHostileHealth()- player.getDamage());
                                printSlowMotion("Dusman cani" + abandonTower.getHostileHealth()+"\n",speed);
                                if(player.getHealth()<0 || abandonTower.getHostileHealth() < 0 ){
                                    if(player.getHealth()> abandonTower.hostileHealth){
                                        printSlowMotion(player.getName()+" kazandin! Terkedilmis Kule'de Cadi'yi oldurdun!\n",speed);
                                        player.setMoney(player.getMoney()+20);
                                        abandonTower.setHostileHealth(100);
                                        printSlowMotion("Kazanilan odul: " + player.getMoney() + " kadar para kazandin.\n",speed);
                                        forestCount++;
                                        break;
                                    }else{
                                        printSlowMotion("Kaybettiniz!\n",speed);
                                        printSlowMotion("Cikis yapiliyor...\n",speed);
                                        System.exit(0);
                                    }
                                }
                            }

                        }
                        break;
                    }
                    break;
                case 4: // Cave
                    int firstAttackCave = random.nextInt(1,3); // Random generator for decide first attacker
                    while(true){
                        printSlowMotion("Magaraya girdin. Kedigozu iksiri yada mesaleni hazir tut!\n",speed);
                        printSlowMotion("Hay aksi dusman goruldu!\n",speed);
                        printSlowMotion("Düşman: "+cave.getHostileName()+"\n",speed);
                        printSlowMotion("Hasar: " +cave.getHostileDamage()+"\n",speed);
                        printSlowMotion("Saglik: " + cave.getHostileHealth()+"\n",speed);
                        while(true){

                            if(firstAttackCave == 1){ // First attacker is player
                                cave.setHostileHealth(cave.getHostileHealth()- player.getDamage());
                                printSlowMotion("Düşman cani: " + cave.getHostileHealth()+"\n",speed);
                                player.setHealth(player.getHealth()- cave.getHostileDamage());
                                printSlowMotion("Kalan can: " + player.getHealth()+"\n",speed);
                                if(player.getHealth()<0 || cave.getHostileHealth() < 0 ){
                                    if(player.getHealth()> cave.getHostileHealth()){
                                        printSlowMotion(player.getName()+" kazandın!\n",speed);
                                        cave.setHostileHealth(100);
                                        caveCount++;
                                        break;
                                    }else{
                                        printSlowMotion("Kaybettiniz!\n",speed);
                                        printSlowMotion("Çıkış yapılıyor...\n",speed);
                                        System.exit(0);
                                    }
                                }
                            }else{ // Hostile is first attacker
                                player.setHealth(player.getHealth() - cave.getHostileDamage());
                                printSlowMotion("Kalan can: " + player.getHealth()+"\n",speed);
                                cave.setHostileHealth(cave.getHostileHealth()- player.getDamage());
                                printSlowMotion("Düşman canı" + cave.getHostileHealth()+"\n",speed);
                                if(player.getHealth()<0 || cave.getHostileHealth() < 0 ){
                                    if(player.getHealth()> cave.hostileHealth){
                                        printSlowMotion(player.getName()+" kazandın!\n",speed);
                                        caveCount++;
                                        break;
                                    }else{
                                        printSlowMotion("Kaybettiniz!\n",speed);
                                        printSlowMotion("Çıkış yapılıyor...\n",speed);
                                        System.exit(0);
                                    }
                                }
                            }

                        }
                        break;
                    }
                    break;
                case 5: // Dungeon
                    int firstAttackRiver = random.nextInt(1,3); // Random generator for decide first attacker
                    while(true){
                        printSlowMotion("Zifiri karanlik zindan mi? Kim boyle yerler insa eder ki? Kral Foltest mi?\n",speed);
                        printSlowMotion("Yoksa Hattori'nin sarap tuccarlari mi? Mahzenler ve zindanlar...\n",speed);
                        printSlowMotion("Saraplar ve tutsaklar...\n",speed);
                        printSlowMotion("Dusman goruldu!!\n",speed);
                        printSlowMotion("Dusman: "+ dungeon.getHostileName()+"\n",speed);
                        printSlowMotion("Hasar: " + dungeon.getHostileDamage()+"\n",speed);
                        printSlowMotion("Saglik: " + dungeon.getHostileHealth()+"\n",speed);
                        while(true){

                            if(firstAttackRiver == 1){ // First attacker is player
                                dungeon.setHostileHealth(dungeon.getHostileHealth()- player.getDamage());
                                printSlowMotion("Düşman cani: " + dungeon.getHostileHealth()+"\n",speed);
                                player.setHealth(player.getHealth()- dungeon.getHostileDamage());
                                printSlowMotion("Kalan can: " + player.getHealth()+"\n",speed);
                                if(player.getHealth()<0 || dungeon.getHostileHealth() < 0 ){
                                    if(player.getHealth()> dungeon.getHostileHealth()){
                                        printSlowMotion(player.getName()+" kazandın!\n",speed);
                                        dungeon.setHostileHealth(100);
                                        riverCount++;
                                        break;
                                    }else{
                                        printSlowMotion("Kaybettiniz!\n",speed);
                                        printSlowMotion("Çıkış yapılıyor...\n",speed);
                                        System.exit(0);
                                    }
                                }
                            }else{ // Hostile is first attacker
                                player.setHealth(player.getHealth()- dungeon.getHostileDamage());
                                printSlowMotion("Kalan can: " + player.getHealth()+"\n",speed);
                                dungeon.setHostileHealth(dungeon.getHostileHealth()- player.getDamage());
                                printSlowMotion("Düşman canı" + dungeon.getHostileHealth()+"\n",speed);
                                if(player.getHealth()<0 || dungeon.getHostileHealth() < 0 ){
                                    if(player.getHealth()> dungeon.hostileHealth){
                                        printSlowMotion(player.getName()+" kazandın!\n",speed);
                                        riverCount++;
                                        break;
                                    }else{
                                        printSlowMotion("Kaybettiniz!\n",speed);
                                        printSlowMotion("Çıkış yapılıyor...\n",speed);
                                        System.exit(0);
                                    }
                                }
                            }

                        }
                        break;
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
            }

        }
    }

    // Print logo method
    public void printLogo(){
        String logo = "██╗    ██╗██╗████████╗██╗  ██╗ ██████╗███████╗██████╗  \n" +
                "██║    ██║██║╚══██╔══╝██║  ██║██╔════╝██╔════╝██╔══██╗       \n" +
                "██║ █╗ ██║██║   ██║   ███████║██║     █████╗  ██████╔╝       \n" +
                "██║███╗██║██║   ██║   ██╔══██║██║     ██╔══╝  ██╔══██╗       \n" +
                "╚███╔███╔╝██║   ██║   ██║  ██║╚██████╗███████╗██║  ██║       \n" +
                " ╚══╝╚══╝ ╚═╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚══════╝╚═╝  ╚═╝       \n" +
                "                                                             \n" +
                "███████╗███████╗███████╗ █████╗ ███╗   ██╗███████╗███████╗██╗\n" +
                "██╔════╝██╔════╝██╔════╝██╔══██╗████╗  ██║██╔════╝██╔════╝██║\n" +
                "█████╗  █████╗  ███████╗███████║██╔██╗ ██║█████╗  ███████╗██║\n" +
                "██╔══╝  ██╔══╝  ╚════██║██╔══██║██║╚██╗██║██╔══╝  ╚════██║██║\n" +
                "███████╗██║     ███████║██║  ██║██║ ╚████║███████╗███████║██║\n" +
                "╚══════╝╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚══════╝╚═╝\n";
        //System.out.println(logo);
        printSlowMotion(logo,5);
    }

    // Print slow motion effects
    public void printSlowMotion(String text, int speed) {
        try {
            for (char item : text.toCharArray()) {
                System.out.print(item);
                Thread.sleep(speed);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
