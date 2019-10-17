package lesson13.statistic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileIO {

    public Stream<String> read(String fileName) throws IOException {
        return Files.lines(Paths.get(fileName));
    }

    public void write(String fileName, Stream<String> output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            output.forEach(s -> writeWrapper(s, writer));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeWrapper(String str, BufferedWriter writer) {
        try {
            writer.write(str);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
