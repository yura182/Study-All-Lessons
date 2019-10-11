package lesson12;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.*;


public class HashMapTest {
    private HashMap<Integer, String> numberToString;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private void initEmptyMap() {
        this.numberToString = new HashMap<>();
    }

    private void initMap() {
        this.numberToString = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            numberToString.put(i, "Hello" + " " + i);
        }
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForPut() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key must be not null");
        initEmptyMap();
        numberToString.put(null, "Hello");
    }

    @Test
    public void shouldReturnNullAfterPuttingInEmptyMap() {
        initEmptyMap();
        String actual = numberToString.put(10, "Hello");
        assertNull(actual);
    }

    @Test
    public void shouldReturnPreviousValue() {
        initMap();
        String actual = numberToString.put(0, "Hello Hello");
        String expected = "Hello 0";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullAfterPuttingInNonEmpyBucket() {
        initMap();
        String actual = numberToString.put(16, "Hello 16");
        assertNull(actual);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForGet() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key must be not null");
        initEmptyMap();
        numberToString.getByKey(null);
    }

    @Test
    public void shouldReturnValue() {
        initMap();
        String actual = numberToString.getByKey(5);
        String expected = "Hello 5";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNull() {
        initMap();
        String actual = numberToString.getByKey(15);
        assertNull(actual);
    }

    @Test
    public void shouldReturnSizeOfNonEmptyMap() {
        initMap();
        int actual = numberToString.size();
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSizeOfEmptyMap() {
        initEmptyMap();
        int actual = numberToString.size();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrueForEmptyMap() {
        initEmptyMap();
        boolean actual = numberToString.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseForNonEmptyMap() {
        initMap();
        boolean actual = numberToString.isEmpty();
        assertFalse(actual);
    }

    @Test
    public void shouldReturnEmptySet() {
        initEmptyMap();
        Set<Integer> keys = numberToString.keys();
        boolean actual = keys.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void shouldReturnSetOfKeys() {
        initMap();
        Set<Integer> keys = numberToString.keys();
        int actual = keys.size();
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyCollection() {
        initEmptyMap();
        Collection<String> values = numberToString.values();
        boolean actual = values.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void shouldReturnCollectionOfValues() {
        initMap();
        Collection<String> values = numberToString.values();
        int actual = values.size();
        int expected = 10;
        assertEquals(expected, actual);
    }
}