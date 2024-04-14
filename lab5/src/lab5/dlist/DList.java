package lab5.dlist;

import lab5.Pair;

import java.util.ArrayList;

/**
 * <h2>Обобщенная мапа</h2>
 * @param <K>
 * @param <V>
 */
public class DList<K, V> {
    private ArrayList<K> keys;
    private ArrayList<ArrayList<V>> values;
    private String label;
    public DList(String label) {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
        this.label = label;
    }
    public void add(K key, ArrayList<V> value) {
        keys.add(key);
        values.add(value);
    }
    public Pair<K, ArrayList<V>> pop(int index) {
        throwBadGet(index);
        return new Pair<>(keys.remove(index), values.remove(index));
    }
    public Pair<K, ArrayList<V>> get(int index) {
        throwBadGet(index);
        return new Pair<>(keys.get(index), values.get(index));
    }
    public Pair<K, ArrayList<V>> pop(K key) {
        throwBadGet(key);
        int removed = keys.indexOf(key);
        return new Pair<>(keys.remove(removed), values.remove(removed));
    }
    public Pair<K, ArrayList<V>> get(K key) {
        throwBadGet(key);
        int indexed = keys.indexOf(key);
        return new Pair<>(keys.get(indexed), values.get(indexed));
    }
    private void throwBadGet(int index) {
        if (keys.isEmpty()) {
            throw new Error("Список пуст");
        }
        if (index > keys.size() - 1) {
            throw new Error("Неверный индекс элемента");
        }
    }
    private void throwBadGet(K key) {
        if (keys.isEmpty()) {
            throw new Error("Список пуст");
        }
        if (!keys.contains(key)) {
            throw new Error("Элемент " + key.toString() + " не найден в списке");
        }
    }
    @Override
    public String toString() {
        return String.format("%s: {Ключи: {%s}, Значения: {%s}}", label, keys.toString(), values.toString());
    }
}
