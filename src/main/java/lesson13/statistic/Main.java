package lesson13.statistic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String in = "file.in";
        String out = "file.out";
        CharCounter charCounter = new CharCounter();
        Map<Character, Integer> symbolToNumber = charCounter.getFileStatistic(in);

        symbolToNumber.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach((k) -> System.out.println(k.getKey() + " - " + k.getValue()));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {
            symbolToNumber.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach((k) -> {
                        try {
                            writer.write(k.getKey() + " - " + k.getValue());
                            writer.newLine();
                        } catch (IOException e) {
                            System.out.println("Exception while writing file " + e);
                        }
                    });
        } catch (IOException e) {
            System.out.println("Exception while opening file " + e);
        }
    }
}
