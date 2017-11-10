package mobi.mpk.chessServerSpring.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Registry<K, V> {

    protected Map<K, V> registry;

    public void addElement(K key, V value) {

        if (key != null) {
            this.registry.putIfAbsent(key, value);
        }

    }

    public void removeElement(V value) {

        for (Map.Entry<K, V> entry : registry.entrySet()) {

            if(entry.getValue().equals(value)) {

                registry.remove(entry.getKey());

            }

        }

    }

    public void removeElementKey(K key) {

        this.registry.remove(key);

    }

    public V getElement(K key) {

        return registry.get(key);

    }

    public boolean checkElement(V value) {

        return this.registry.containsValue(value);

    }

    public boolean checkKey(K key) {

        return this.registry.containsKey(key);

    }

    public void clear() {
        registry.clear();
    }

    public List<V> getListElement() {

        List<V> list = new ArrayList<V>();

        for (V value : registry.values()) {
            list.add(value);
        }

        return list;

    }

}
