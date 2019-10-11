package lesson12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> implements Map<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.8f;
    private static final int DEPTH_THRESHOLD = 6;

    private Node<K, V>[] table;
    private int size;
    private int threshold;
    private Set<K> keys;
    private Collection<V> values;

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity");
        }
        this.table = new Node[capacity];
        this.threshold = (int) (capacity * LOAD_FACTOR);
    }

    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key must be not null");
        }
        int index = indexFor(key.hashCode(), this.table.length);
        Node<K, V> newNode = new Node<>(key, value, key.hashCode());
        Node<K, V> existingNode = table[index];

        if (existingNode == null) {
            table[index] = newNode;
            this.size += 1;
            addKey(key);
            addValue(value);
        } else {
            int depth = 1;
            while (true) {
                if (existingNode.key.equals(key)) {
                    V oldValue = existingNode.value;
                    existingNode.value = value;
                    this.values.remove(oldValue);
                    addValue(value);
                    return oldValue;
                } else if (existingNode.next == null) {
                    existingNode.next = newNode;
                    size += 1;
                    addKey(key);
                    addValue(value);
                    break;
                } else {
                    existingNode = existingNode.next;
                    depth +=1;
                }
            }
            if (depth >= DEPTH_THRESHOLD) {
                resize();
            }
        }

        if (this.size > this.threshold) {
            resize();
        }

        return null;
    }

    @Override
    public V getByKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must be not null");
        }

        Node<K, V> node = table[indexFor(key.hashCode(), this.table.length)];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
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
    public Collection<V> values() {
        return this.values == null ? new ArrayList<>() : new ArrayList<>(this.values);
    }

    @Override
    public Set<K> keys() {

        return this.keys == null ? new HashSet<>() : new HashSet<>(this.keys);
    }

    private void addValue(V value) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(value);
    }

    private void addKey(K key) {
        if (this.keys == null) {
            this.keys = new HashSet<>();
        }
        this.keys.add(key);
    }

    private int indexFor(int hash, int size) {
        return hash % size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int oldLength = this.table.length;
        Node<K, V>[] newTable = new Node[oldLength * 2];
        int newLength = newTable.length;

        for (int i = 0; i < oldLength; i++) {
            Node<K, V> currentNode = table[i];
            while (currentNode != null) {
                int index = indexFor(currentNode.hash, newLength);
                Node<K, V> newTableNode = newTable[index];

                if (newTableNode == null) {
                    newTable[index] = currentNode;
                    currentNode = currentNode.next;
                    newTable[index].next = null;
                } else {
                    while (newTableNode.next != null) {
                        newTableNode = newTableNode.next;
                    }
                    newTableNode.next = currentNode;
                    currentNode = currentNode.next;
                    newTableNode.next.next = null;
                }
            }
        }

        this.threshold = (int) (newLength * LOAD_FACTOR);
        this.table = newTable;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private int hash;
        private Node<K, V> next;

        private Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }
}
