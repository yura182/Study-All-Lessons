package lesson13.practice;

import java.io.*;

public class FileReaderTest {
    public static void main(String[] args) {
        String inFile = "./temp/testIn.txt";
        String outFile = "./temp/testOut.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line );
                writer.newLine();
                System.out.println(line);
            }
        } catch (IOException e ) {
            System.out.println("Exception while reading file " + e);
        }
    }
}
