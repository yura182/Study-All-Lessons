package lesson14.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Filter {

    public <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> initial = new ArrayList<>();

        if (Objects.isNull(list) || Objects.isNull(predicate)) {
            return initial;
        }

        return list.stream().reduce(initial, (accumulator, element) -> {
            if (predicate.test(element)) {
                initial.add(element);
            }
            return accumulator;
        }, (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        });
    }
}
