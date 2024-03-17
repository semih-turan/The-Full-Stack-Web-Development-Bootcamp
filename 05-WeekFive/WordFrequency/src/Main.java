/**
 * @author Semih Turan
 * @since march 2024
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declare variable
        int maxCount = 0;
        String frequency = null;

        // Prompting user input
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your words: ");
        String words = input.nextLine();

        // Split input words
        String[] splitWords = words.split("\\s+");
        System.out.println(Arrays.toString(splitWords));

        // Creating HashMap in order to count each word
        Map<String, Integer> wordsCountMap = new HashMap<>();

        // Mapping each word
        for(String word : splitWords){
            wordsCountMap.put(word,wordsCountMap.getOrDefault(word,0)+1);
        }

        System.out.println(wordsCountMap);

        // Find most frequent word
        for(Map.Entry<String, Integer> entry : wordsCountMap.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                frequency = entry.getKey();
            }
        }

        // Printing result
        if(frequency != null){
            System.out.println("Most frequent word: " + frequency + " Count: " + maxCount);
        }else{
            System.out.println("No words found!");
        }
    }
}