package Arr;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Arr implements Iterable<Integer> {
    private int[] data;
    public Arr(int size) {
        data = new int[size];
    }
    public void set(int pos, int val) {
        data[pos] = val;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new ArrIter(data);
    }
}

class ArrIter implements Iterable<Integer> {
    private int[] d;
    private int index;

    public ArrIter(int[] data) {
        d = data;
    }

    @Override
    public Boolean hasNext() {
        return index < d.length;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (hasNext())
            return d[index++];
        throw new NoSuchElementException();
    }
}
