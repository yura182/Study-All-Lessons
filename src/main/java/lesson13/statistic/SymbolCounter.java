package lesson13.statistic;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SymbolCounter {
    private final Map<Character, Integer>  charToNumber = new HashMap<>();
    private final FileIO fileIO;

    public SymbolCounter(FileIO fileIO) {
        this.fileIO = fileIO;
    }

    public Map<Character,Integer> getFileStatistic(String fileName) throws IOException{
        if (fileName == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        parseSymbols(fileIO.read(fileName));
        return this.charToNumber;
    }

    private void parseSymbols(Stream<String> stringStream) {
        stringStream.map(string -> string.replaceAll("\\s", ""))
                .flatMapToInt(CharSequence::chars)
                .map(Character::toLowerCase)
                .forEach(c -> addSymbol((char)c));
    }

    private void addSymbol(char symbol) {
        if (charToNumber.containsKey(symbol)) {
            int counter = charToNumber.get(symbol);
            charToNumber.put(symbol, ++counter);
        } else {
            charToNumber.put(symbol, 1);
        }
    }
}
