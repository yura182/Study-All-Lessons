package lesson13.practice.counter;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String in = "./temp/file.in";
        String out = "./temp/file.out";
        CharCounter charCounter = new CharCounter();

        try (BufferedReader reader = new BufferedReader(new FileReader(in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {
            int input;
            while ((input = reader.read()) != -1) {
                charCounter.addChar((char) input);
            }

            writer.write(charCounter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
