package lesson14.factorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FactorialTest {
    private int number;
    private long expected;


    public FactorialTest (int number, long expected) {
        this.number = number;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection factorials() {
        return Arrays.asList(new Object[][] {
                { 1, 1 },
                { 0, 1 },
                { 2, 2 },
                { 5, 120 },
                { 10, 3_628_800 }
        });
    }

    @Test
    public void shouldReturnFactorialOfNumber() {
        Factorial f = new Factorial();
        assertEquals(expected, f.factorial(number).orElse(0));
    }
}