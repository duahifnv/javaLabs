package lab5;

/**
 * <h2>Мешок с парами обьектов</h2>
 * <h3>Необобщенный класс</h3>
 * @see lab5.Bag
 */
public class PairBag extends Bag {
    public PairBag(int capacity) {
        super(capacity);
    }
    protected void put(Pair<Object, Object> pair) {
        super.put(pair);
    }
    protected Pair<Object, Object> pick() {
        return (Pair<Object, Object>) super.pick();
    }
    protected Pair<Object, Object> get() {
        return (Pair<Object, Object>) super.get();
    }
}
