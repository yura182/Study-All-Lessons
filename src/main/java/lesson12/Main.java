package lesson12;


import java.util.Collection;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> numberToString = new HashMap<>();
        for (int i = 0; i < 95; i += 16) {
            numberToString.put(i, "Hello" + " " + i);
        }

        numberToString.put(96, "Hello new96");

        System.out.println(numberToString.isEmpty());
        System.out.println(numberToString.size());

        Set<Integer> keys = numberToString.keys();
        Collection<String> values = numberToString.values();
        keys.forEach(k-> System.out.print(k + " "));
        System.out.println();
        values.forEach(v -> System.out.println(v + " "));
        System.out.println();
        System.out.println(numberToString.getByKey(96));
    }
}
