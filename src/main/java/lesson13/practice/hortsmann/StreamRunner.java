package lesson13.practice.hortsmann;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRunner {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("testIn.txt"));
        Stream<String> numbers = lines
                .map(s -> s.replaceFirst("^\\D+", ""))
                .map(s -> s.split("\\D+"))
                .flatMap(Stream::of);
        int sum = numbers.flatMapToInt(s -> IntStream.of(Integer.parseInt(s))).reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }
}
