package lab5.hash.hashfunction;

/**
 * <h2>Абстрактный класс хэш-функции</h2>
 * @param <K>
 */
public abstract class HashFunction<K> {
    protected final int tableSize;
    public HashFunction(int tableSize) {
        this.tableSize = tableSize;
    }
    public abstract int hash(K s);
}
