package lab5.hash.hashtable;

import lab5.hash.Gettable;
import lab5.hash.hashfunction.HashFunction;

import java.util.ArrayList;

/**
 * <h2>Абстрактная хэш-таблица</h2>
 * @param <T>
 * @param <K>
 */
public abstract class HashTable<T extends Gettable<K>, K> {
    protected final ArrayList<T>[] hashtable;
    protected final HashFunction<K> hashFunction;
    protected final int tableSize;
    public HashTable(int tableSize, HashFunction<K> hashFunction) {
        this.tableSize = tableSize;
        this.hashFunction = hashFunction;
        hashtable = new ArrayList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashtable[i] = new ArrayList<>();
        }
    }
    public abstract void add(T element);
    public abstract ArrayList<T> get(K key);
    public abstract ArrayList<T> pop(K key);
}
