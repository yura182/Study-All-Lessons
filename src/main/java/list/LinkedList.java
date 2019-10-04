package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> extends AbstractList<E> implements List<E>, Iterable<E> {
    private Node<E> head;
    private Node<E> last;

    public LinkedList() {

    }

    @Override
    public void add(E element) {
        if (this.head == null) {
            this.head = new Node<>(element);
            this.size += 1;
        } else if (this.last == null) {
            this.last = new Node<>(element);
            this.head.next = this.last;
            this.size += 1;
        } else {
            Node<E> newNode = new Node<>(element);
            this.last.next = newNode;
            this.last = newNode;
            this.size += 1;
        }
    }

    @Override
    public E getByIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        Node<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    @Override
    public boolean remove(E element) {
        if (isEmpty()) {
            return false;
        }
        Node<E> current = this.head;
        Node<E> prev = null;

        for ( ; ; ) {
            if (element != null ? element.equals(current.data) : element == current.data) {
                if (prev == null) {
                    this.head = current.next;
                    current.data = null;
                    current = null;
                    this.size -= 1;
                    return true;
                } else {
                    prev.next = current.next;
                    current.data = null;
                    current = null;
                    this.size -= 1;
                    return true;
                }
            }
            if (current.next == null) {
                return false;
            }
            prev = current;
            current = current.next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class Node<E> {
        private Node<E> next;
        private E data;

        private Node(E element) {
            this.data = element;
        }
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = LinkedList.this.head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            return result;
        }
    }
}
