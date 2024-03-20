/**
 * @author Semih Turan
 * @since march 2024
 */
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        simulateMatches("ÇİFTLİ SİSTEM", 10, 3, "GALATASARAY", "BURSASPOR", "FENERBAHÇE", "BEŞİKTAŞ", "BAŞAKŞEHİR", "TRABZONSPOR");
        simulateMatches("TEKLİ SİSTEM", 14, 4, "GALATASARAY", "BURSASPOR", "FENERBAHÇE", "SAMSUNSPOR", "BEŞİKTAŞ", "BAŞAKŞEHİR", "TRABZONSPOR", "BAY");
    }

    public static void simulateMatches(String systemName, int totalRounds, int teamsPerRound, String... teams) {
        System.out.println(systemName + "\n" + "----------");

        ArrayList<String> teamList = new ArrayList<>();
        Collections.addAll(teamList, teams);

        for (int i = 1; i <= totalRounds; i++) {
            System.out.println("\n" + "Hafta " + i + "\n" + "----------");
            Collections.shuffle(teamList);

            for (int j = 0; j < teamList.size(); j += teamsPerRound) {
                for (int k = 0; k < teamsPerRound; k++) {
                    System.out.print(teamList.get(j + k) + " ");
                }
                System.out.println();
            }
        }
    }
}
