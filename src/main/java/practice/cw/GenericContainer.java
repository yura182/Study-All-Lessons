package practice.cw;

public class GenericContainer<T> {
    private T object;

    public GenericContainer() {
    }

    public GenericContainer(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
