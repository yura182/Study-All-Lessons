package lesson14.map;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private final Map<Integer, Long> numberToFibonacci;

    public Fibonacci() {
        this.numberToFibonacci = new HashMap<>();
        this.numberToFibonacci.put(0, 0L);
        this.numberToFibonacci.put(1, 1L);
        this.numberToFibonacci.put(-1, 1L);
    }

    public Long find(int n) {
        if (n < 0) {
            return numberToFibonacci.computeIfAbsent(n, (x) -> find(x + 2) - find(x + 1));
        }

        return numberToFibonacci.computeIfAbsent(n, (x) -> find(x - 1) + find(x - 2));
    }
}
