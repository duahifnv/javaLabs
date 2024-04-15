package lab5.hash.hashtable;

import lab5.hash.hashfunction.HashFunction;
import lab5.hash.person.Person;

import java.util.ArrayList;

public class PersonHashTable extends HashTable<Person, String>{
    public PersonHashTable(int tableSize, HashFunction<String> hashFunction) {
        super(tableSize, hashFunction);
    }
    public void add(Person element) {
        String key = element.getKey();
        int index = hashFunction.hash(key);
        hashtable[index].add(element);
    }
    public ArrayList<Person> get(String key) {
        int index = hashFunction.hash(key);
        return hashtable[index];
    }
    public ArrayList<Person> pop(String key) {
        int index = hashFunction.hash(key);
        ArrayList<Person> removed = hashtable[index];
        hashtable[index] = null;
        return removed;
    }
}
