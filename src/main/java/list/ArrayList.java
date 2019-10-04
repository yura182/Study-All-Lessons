package list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayList<E> implements List<E>, Iterable<E>{
    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private Object[] elements;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        if (capacity <= DEFAULT_CAPACITY) {
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            elements = new Object[capacity];
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public E getByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        return (E) elements[index];
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);

        if (index != -1) {
            int lengthToCopy = this.elements.length - index - 1;

            System.arraycopy(this.elements, index + 1, this.elements, index, lengthToCopy);
            this.elements[--size] = null;
            return true;
        }

        return false;
    }

    private void ensureCapacity() {
        if (this.size == elements.length) {
            int newSize = this.size * 2;
            Object[] tempElements = new Object[newSize];

            System.arraycopy(this.elements, 0, tempElements, 0, elements.length);
            this.elements = tempElements;
        }
    }

    private int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if ( element != null ? element.equals(elements[i]) : element == elements[i] ) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayList<?> arrayList = (ArrayList<?>) o;
        return size == arrayList.size &&
                Arrays.equals(elements, arrayList.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int current;

        @Override
        public boolean hasNext() {
            return current != ArrayList.this.size;
        }

        @Override
        public E next() {
            if (current >= ArrayList.this.size) {
                throw new NoSuchElementException();
            }
            return (E) ArrayList.this.elements[current++];
        }
    }
}
