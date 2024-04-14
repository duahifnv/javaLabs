package lab5.bag;

import lab5.Pair;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h2>Мешок с парами обьектов</h2>
 * <h3>Обобщенный  ArrayList</h3>
 * @param <T1>
 * @param <T2>
 * @see Bag
 */
public class GenericPairBag<T1, T2> {
    private final ArrayList<Pair<T1, T2>> pairs;
    private final int capacity;
    public GenericPairBag(int capacity) {
        this.capacity = capacity;
        this.pairs = new ArrayList<>(capacity);
    }
    public void put(Pair<T1, T2> pair) {
        if (pairs.size() == capacity) {
            throw new Error("Мешок заполнен. Добавление новых элементов невозможно");
        }
        pairs.add(pair);
    }
    public Pair<T1, T2> pick() {
        if (pairs.isEmpty()) {
            throw new Error("Мешок пуст. Невозможно получить элементы");
        }
        return pairs.remove((int) Math.round(Math.random() * (pairs.size() - 1)));
    }
    public Pair<T1, T2> get() {
        if (pairs.isEmpty()) {
            throw new Error("Мешок пуст. Невозможно получить элементы");
        }
        return pairs.get((int) Math.round(Math.random() * (pairs.size() - 1)));
    }
    public int getCapacity() {
        return capacity;
    }
    public int getWeight() {
        return pairs.size();
    }
    @Override
    public String toString() {
        return String.format("Мешок: {Размер:%d}, {Вес:%d}, {Содержимое:%s}", capacity, pairs.size(), Arrays.toString(pairs.toArray()));
    }
}
