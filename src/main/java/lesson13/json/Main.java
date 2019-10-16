package lesson13.json;

import com.google.gson.Gson;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "user.json";
        User user = new User("Bob", "Barker", 27);
        Gson gson = new Gson();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(gson.toJson(user));
        } catch (IOException e ) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            User newUser = gson.fromJson(new FileReader(fileName), User.class);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
