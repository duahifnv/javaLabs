package lab5;

import lab5.bag.*;
import lab5.cup.Cup;

public class TaskList {
    public static void task1(String val1, String val2) {
        int first, second;
        try {
            first = Integer.parseInt(val1);
            second = Integer.parseInt(val2);
        }
        catch (NumberFormatException e) {
            throw new Error("Задача #1 принимает целочисленные аргументы");
        }
        Pair<Integer, Integer> pair = new Pair<>(first, second);
        pair.setLabel("Моя пара");
        System.out.println(pair);
        Pair<Object, Object> pair2 = Pair.make_pair(new Object(), new Object());
        pair2.setLabel("Моя пара 2");
        System.out.println(pair2);
    }
    public static void task2(String val) {
        int capacity;
        try {
            capacity = Integer.parseInt(val);
        }
        catch (NumberFormatException e) {
            throw new Error("Задача #2 принимает целочисленный аргумент");
        }
        Bag bag = new Bag(capacity);
        for (int i = 0; i < bag.getCapacity() / 2; i++) {
            bag.putItem(i);
        }
        System.out.println(bag + "\nИзвлекли: " + bag.pickItem() + "\n" + bag);
    }
    public static void task3(String val) {
        int capacity;
        try {
            capacity = Integer.parseInt(val);
        }
        catch (NumberFormatException e) {
            throw new Error("Задача #3 принимает целочисленный аргумент");
        }
        PairBag pairbag = new PairBag(capacity);
        for (int i = 0; i < pairbag.getCapacity() / 2; i++) {
            pairbag.put(new Pair<>(i, i + 1));
        }
        System.out.println(pairbag + "\nИзвлекли: " + pairbag.pick() + "\n" + pairbag);
    }
    public static void task4(String val) {
        int capacity;
        try {
            capacity = Integer.parseInt(val);
        }
        catch (NumberFormatException e) {
            throw new Error("Задача #4 принимает целочисленный аргумент");
        }
        GPairBag<Integer, Integer> gPairBag = new GPairBag<>(capacity);
        for (int i = 0; i < gPairBag.getCapacity() / 2; i++) {
            gPairBag.put(new Pair<>(i, i + 1));
        }
        // gPairBag.putGPair(new Pair<>(0.2, 0.3));     Error
        System.out.println(gPairBag + "\nИзвлекли: " + gPairBag.pick() + "\n" + gPairBag);
    }
    public static void task5(String val) {
        int capacity;
        try {
            capacity = Integer.parseInt(val);
        }
        catch (NumberFormatException e) {
            throw new Error("Задача #5 принимает целочисленный аргумент");
        }
        GenericPairBag<Integer, Integer> genericPairBag = new GenericPairBag<>(capacity);
        for (int i = 0; i < genericPairBag.getCapacity() / 2; i++) {
            genericPairBag.put(new Pair<>(i, i + 1));
        }
        System.out.println(genericPairBag + "\nИзвлекли: " + genericPairBag.pick() + "\n" + genericPairBag);
    }
    public static void task6(String val) {
        final int DEFAULT_SIZE = 10;
        int cupMembersCount;
        try {
            cupMembersCount = Integer.parseInt(val);
        }
        catch (NumberFormatException e) {
            throw new Error("Задача #6 принимает целочисленный аргумент");
        }
        Cup cup = new Cup(cupMembersCount);
        cup.run();
    }
}
