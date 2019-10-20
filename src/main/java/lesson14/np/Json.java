package lesson14.np;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json<T> {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public String toJson(T object) {
        return GSON.toJson(object);
    }
}
