package lesson14.filter;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FilterTest {
    private Filter filter = new Filter();

    @Test
    public void shouldReturnFilteredListOfIntegers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(4, 5);
        List<Integer> actual = filter.filter(list, x -> x > 3);
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnFilteredListOfStrings() {
        List<String> list = Arrays.asList("one", "two", "three", "four", "five");
        List<String> expected = Arrays.asList("three", "four", "five");
        List<String> actual = filter.filter(list, x -> x.length() > 3);
        assertThat(actual, is(expected));
    }

    @Test
    public void shouldReturnEmptyList() {
        List<String> expected = Collections.emptyList();
        List<String> actual = filter.filter(null, x -> x.length() > 3);
        assertThat(actual, is(expected));
    }

}