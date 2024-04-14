package lab5.bag;

import lab5.Pair;

/**
 * <h2>Мешок с парами обьектов</h2>
 * <h3>Обобщенный класс</h3>
 * @see Bag
 */
public class GPairBag<T1, T2> extends Bag{
    public GPairBag(int capacity) {
        super(capacity);
    }
    public void put(Pair<T1, T2> pair) {
        super.putItem(pair);
    }
    public Pair<T1, T2> pick() {
        return (Pair<T1, T2>) super.pickItem();
    }
    public Pair<T1, T2> get() {
        return (Pair<T1, T2>) super.getItem();
    }
}