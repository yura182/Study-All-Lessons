package list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ArrayListTest {
    private ArrayList<Integer> numbersNonEmpty;
    private ArrayList<Integer> numbersEmpty;


    @Before
    public void init() {
        numbersEmpty = new ArrayList<>();
        numbersNonEmpty = new ArrayList<>();
        numbersNonEmpty.add(1);
        numbersNonEmpty.add(2);
        numbersNonEmpty.add(3);
    }

    @Test
    public void shouldReturnSizeOfList() {
        int expected = 3;
        int actual = numbersNonEmpty.size();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSizeOfEmptyList() {
        int expected = 0;
        int actual = numbersEmpty.size();
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
    public void shouldAddElement() {
        numbersEmpty.add(1);
        int actualSize = numbersEmpty.size();
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldReturnElementByIndex() {
        int actual = numbersNonEmpty.getByIndex(2);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOfBoundsException() {
        int actual = numbersNonEmpty.getByIndex(4);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueAfterRemovingElement() {
        boolean actual = numbersNonEmpty.remove(1);
        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseAfterRemovingElement() {
        boolean actual = numbersNonEmpty.remove(15);
        assertFalse(actual);
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

    @Test
    public void shouldRemoveElementInTheMiddleOfArray() {
        numbersNonEmpty.remove(2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        assertEquals(expected, numbersNonEmpty);
    }

    @Test
    public void shouldIterateThoughList() {
        ArrayList<Integer> expectedNumbers = new ArrayList<>();
        for (Integer number : numbersNonEmpty) {
            expectedNumbers.add(number);
        }

        assertEquals(expectedNumbers, numbersNonEmpty);
    }

    @Test (expected = NoSuchElementException.class)
    public void shouldThroeNoSuchElementException() {
        Iterator<Integer> iterator = numbersEmpty.iterator();
        iterator.next();
    }
}