package mobi.mpk.chessServerSpring.registry;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Registry<K, V> {

    protected Map<K, V> values;

    public void addElement(K key, V value) {

        if (key != null) {
            this.values.putIfAbsent(key, value);
        }

    }

    public void removeElement(K key) {

        this.values.remove(key);

    }

    public void removeElementKey(K key) {

        this.values.remove(key);

    }

    public V getElement(K key) {

        return values.get(key);

    }

    public boolean checkElement(V value) {

        return this.values.containsValue(value);

    }

    public boolean checkKey(K key) {

        return this.values.containsKey(key);

    }

    public void clear() {
        values.clear();
    }

    public List<V> getListElement() {

        List<V> list = new ArrayList<V>();

        for (V value : values.values()) {
            list.add(value);
        }

        return list;

    }

}
