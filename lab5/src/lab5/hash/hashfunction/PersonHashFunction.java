package lab5.hash.hashfunction;

public class PersonHashFunction extends HashFunction<String> {
    public PersonHashFunction(int tableSize) {
        super(tableSize);
    }
    public int hash(String s) {
        if (s == null) {
            return 0;
        }
        return Math.abs(s.hashCode() % tableSize);
    }
}
