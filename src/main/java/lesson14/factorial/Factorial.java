package lesson14.factorial;

import java.util.OptionalLong;
import java.util.stream.LongStream;

public class Factorial {

    public OptionalLong factorial(int n) {
        if (n < 0 || n > 20) {
            return OptionalLong.empty();
        }

        return OptionalLong.of(LongStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y));
    }
}
