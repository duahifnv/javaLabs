package lab5.bag;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h2>Мешок с обьектами</h2>
 * <h3>Необобщенный класс</h3>
 */
public class Bag {
    protected final Object[] items;
    private final int capacity;
    private int weight;
    public Bag(int capacity) {
        this.capacity = capacity;
        this.weight = 0;
        this.items = new Object[capacity];
    }
    // Получить индексы пустых ячеек
    private Integer[] getEmpty() {
        ArrayList<Integer> indexes = new ArrayList<>(capacity - weight);
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                indexes.add(i);
            }
        }
        return indexes.toArray(new Integer[0]);
    }
    // Получить индексы заполненных ячеек
    private Integer[] getPlaced() {
        ArrayList<Integer> indexes = new ArrayList<>(weight);
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                indexes.add(i);
            }
        }
        return indexes.toArray(new Integer[0]);
    }
    // Положить обьект в мешок
    public void putItem(Object obj) {
        if (weight == capacity) {
            throw new Error("Мешок заполнен. Добавление новых элементов невозможно");
        }
        Integer[] emptyIndexes = getEmpty();
        int emptyIndex = emptyIndexes[(int) Math.round(Math.random() * (emptyIndexes.length - 1))];
        items[emptyIndex] = obj;
        weight++;
    }
    // Взять обьект из мешка
    public Object pickItem() {
        if (weight == 0) {
            throw new Error("Мешок пуст. Невозможно получить элементы");
        }
        Integer[] placedIndexes = getPlaced();
        int placedIndex = placedIndexes[(int) Math.round(Math.random() * (placedIndexes.length - 1))];
        Object pickedObj = items[placedIndex];
        items[placedIndex] = null;
        weight--;
        return pickedObj;
    }
    // Просмотреть обьект из мешка
    public Object getItem() {
        Integer[] placedIndexes = getPlaced();
        int placedIndex = placedIndexes[(int) Math.round(Math.random() * (placedIndexes.length - 1))];
        return items[placedIndex];
    }
    // Получить вес мешка
    public final int getWeight() {
        return weight;
    }
    // Получить размер мешка
    public final int getCapacity() {
        return capacity;
    }
    @Override
    public String toString() {
        return String.format("Мешок: {Размер:%d}, {Вес:%d}, {Содержимое:%s}", capacity, weight, Arrays.toString(items));
    }
}
