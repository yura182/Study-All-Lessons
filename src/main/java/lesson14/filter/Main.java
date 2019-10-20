package lesson14.filter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Filter filter = new Filter();
        List<String> list = Arrays.asList("one", "two", "three", "four", "five");
        List<String> filteredList = filter.filter(list, x->x.length() == 4);
        filteredList.forEach(System.out::println);
    }
}
