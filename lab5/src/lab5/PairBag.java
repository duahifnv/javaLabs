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
    protected void putPair(Pair<Object, Object> pair) {
        super.putItem(pair);
    }
    protected Pair<Object, Object> pickPair() {
        return (Pair<Object, Object>) super.pickItem();
    }
    protected Pair<Object, Object> getPair() {
        return (Pair<Object, Object>) super.getItem();
    }
}
