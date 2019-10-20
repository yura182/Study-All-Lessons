package lesson13.statistic;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String inFileName = "./temp/file.in";
        String outFileName = "./temp/file.out";
        FileIO fileIO = new FileIO();
        SymbolCounter symbolCounter = new SymbolCounter(fileIO);
        Map<Character, Integer> symbolToNumber;


        try {
            symbolToNumber = symbolCounter.getFileStatistic(inFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        symbolToNumber.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach((k) -> System.out.println(k.getKey() + " - " + k.getValue()));

        Stream<String> output = symbolToNumber.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey().toString() + " - " + e.getValue());

        fileIO.write(outFileName, output);

    }
}
