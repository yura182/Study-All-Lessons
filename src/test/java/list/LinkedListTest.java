package list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList<Integer> numbersNonEmpty;
    private LinkedList<Integer> numbersEmpty;

    @Before
    public void init() {
        numbersEmpty = new LinkedList<>();
        numbersNonEmpty = new LinkedList<>();
        numbersNonEmpty.add(1);
        numbersNonEmpty.add(2);
        numbersNonEmpty.add(3);
    }

    @Test
    public void shouldReturnSizeOfEmptyList() {
        int actual = numbersEmpty.size();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSizeOfNonEmptyList() {
        int actual = numbersNonEmpty.size();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForEmptyList() {
        boolean actual = numbersEmpty.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseForNonEmptyList() {
        boolean actual = numbersNonEmpty.isEmpty();
        assertFalse(actual);
    }

    @Test
    public void shouldAddElementToEmptyList() {
        numbersEmpty.add(1);
        int actualSize = numbersEmpty.size();
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldAddElementToNonEmptyList() {
        numbersNonEmpty.add(15);
        int actualSize = numbersNonEmpty.size();
        int expectedSize = 4;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldAddElement() {
        numbersNonEmpty.add(15);
        int actual = numbersNonEmpty.getByIndex(3);
        int expected = 15;
        assertEquals(expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOutOfBoundsException() {
        numbersNonEmpty.getByIndex(4);
    }

    @Test
    public void shouldReturnElementsByIndex() {
        int actual = numbersNonEmpty.getByIndex(2);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseAfterRemovingElement() {
        boolean actual = numbersNonEmpty.remove(20);
        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueAfterRemovingElement() {
        boolean actual = numbersNonEmpty.remove(2);
        assertTrue(actual);
    }

    @Test
    public void shouldIterateThroughList() {
        int expectedLast = 3;
        int actualLast = 0;

        for (Integer number : numbersNonEmpty) {
            actualLast = number;
        }

        assertEquals(expectedLast, actualLast);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementException() {
        Iterator<Integer> iterator = numbersEmpty.iterator();
        iterator.next();
    }

    @Test
    public void shouldRemoveLastElement() {
        int[] actual = new int[2];
        int[] expected = { 1, 2 };
        numbersNonEmpty.remove(3);
        int i = 0;

        for(Integer number : numbersNonEmpty) {
            actual[i] = number;
            i++;
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveElementInTheMiddle() {
        int[] actual = new int[2];
        int[] expected = { 1, 3 };
        numbersNonEmpty.remove(2);
        int i = 0;

        for(Integer number : numbersNonEmpty) {
            actual[i] = number;
            i++;
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveFirstElement() {
        int[] actual = new int[2];
        int[] expected = { 2, 3 };
        numbersNonEmpty.remove(1);
        int i = 0;

        for(Integer number : numbersNonEmpty) {
            actual[i] = number;
            i++;
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseAfterRemovingNull() {
        boolean actual = numbersNonEmpty.remove(null);
        assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueAfterRemovingNull() {
        numbersNonEmpty.add(null);
        boolean actual = numbersNonEmpty.remove(null);
        assertTrue(actual);
    }
}