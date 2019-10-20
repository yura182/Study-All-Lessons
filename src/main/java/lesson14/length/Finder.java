package lesson14.length;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Finder {
    public <T> Optional<T> find(Stream<T> stream, Comparator<T> comparator) {
        return stream
                .reduce((accumulator, element) -> comparator
                        .compare(accumulator, element) >= 0 ? accumulator : element);
    }
}
