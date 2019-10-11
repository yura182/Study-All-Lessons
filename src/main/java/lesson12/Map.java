package lesson12;

import java.util.Collection;
import java.util.Set;

public interface Map<K, V> {
    V put(K key, V value);

    V getByKey(K key);

    int size();

    boolean isEmpty();

    Collection<V> values();

    Set<K> keys();
}
