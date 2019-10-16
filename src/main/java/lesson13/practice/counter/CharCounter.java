package lesson13.practice.counter;

import java.util.HashMap;
import java.util.Map;

public class CharCounter{
    private final Map<Character, Integer>  charsToNumber = new HashMap<>();

    public CharCounter() {

    }

    public void addChar(char symbol) {
        symbol = Character.toLowerCase(symbol);
        if (charsToNumber.containsKey(symbol)) {
            int counter = charsToNumber.get(symbol);
            charsToNumber.put(symbol, ++counter);
        } else {
            charsToNumber.put(symbol, 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : charsToNumber.entrySet()) {
            out.append(entry.getKey())
                    .append(" - ")
                    .append(entry.getValue())
                    .append('\n');
        }
        return out.toString();
    }
}
