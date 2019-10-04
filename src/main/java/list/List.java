package list;

interface List<E> {
    int size();

    boolean isEmpty();

    void add(E element);

    E getByIndex(int index);

    boolean remove(E element);
}
