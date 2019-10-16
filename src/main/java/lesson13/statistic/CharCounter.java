package lesson13.statistic;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CharCounter {
    private final Map<Character, Integer>  charToNumber = new HashMap<>();

    public CharCounter() {

    }

    public Map<Character,Integer> getFileStatistic(String fileName) {
        readFile(fileName);
        return this.charToNumber;
    }

    private void addChar(char symbol) {
        symbol = Character.toLowerCase(symbol);
        if (charToNumber.containsKey(symbol)) {
            int counter = charToNumber.get(symbol);
            charToNumber.put(symbol, ++counter);
        } else {
            charToNumber.put(symbol, 1);
        }
    }

    private void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String input;
            while ((input = reader.readLine()) != null) {
                input = input.replaceAll("\\s", "");
                input.chars().forEach(c -> addChar((char) c));
            }
        } catch (IOException e) {
            System.out.println("Exception while reading file " + e);
        }
    }
}
