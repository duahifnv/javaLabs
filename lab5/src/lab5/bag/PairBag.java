package lab5.bag;

import lab5.Pair;

/**
 * <h2>Мешок с парами обьектов</h2>
 * <h3>Необобщенный класс</h3>
 * @see Bag
 */
public class PairBag extends Bag {
    public PairBag(int capacity) {
        super(capacity);
    }
    public void put(Pair<Object, Object> pair) {
        super.putItem(pair);
    }
    public Pair<Object, Object> pick() {
        return (Pair<Object, Object>) super.pickItem();
    }
    public Pair<Object, Object> get() {
        return (Pair<Object, Object>) super.getItem();
    }
}
