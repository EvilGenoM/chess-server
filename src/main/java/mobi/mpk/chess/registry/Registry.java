package mobi.mpk.chess.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public abstract class Registry<K, V> {

    protected ConcurrentMap<K, V> value;

    public void addElement(K key, V value) {

        if (key != null) {
            this.value.putIfAbsent(key, value);
        }

    }

    public void deleteElement(K key) {

        value.remove(key);

    }

    public V getElement(K key) {

        return value.get(key);

    }

    public boolean checkElement(V value) {

        return this.value.containsValue(value);

    }

    public boolean checkKey(K key) {

        return this.value.containsKey(key);

    }

    public void clear() {
        value.clear();
    }

    public List<V> getListElement() {

        List<V> list = new ArrayList<V>();

        for (V value : value.values()) {
            list.add(value);
        }

        return list;

    }

}
