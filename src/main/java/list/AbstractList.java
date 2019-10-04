package list;

public abstract class AbstractList<E> {
    int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    abstract void add(E element);

    abstract E getByIndex(int index);

    abstract boolean remove(E element);
}
