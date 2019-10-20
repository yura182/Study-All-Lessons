package lesson14.length;

import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Finder finder = new Finder();
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison" ,"Ringo Starr","Pete Best", "Stuart Sutcliffe");

        String longest = finder.find(names, Comparator.comparingInt(String::length)).orElse("");

        System.out.println(longest);
    }
}
