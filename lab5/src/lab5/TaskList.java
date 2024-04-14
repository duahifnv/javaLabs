package lab5;

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
            bag.put(i);
        }
        System.out.println(bag);
        System.out.println("Извлекли: " + bag.pick());
        System.out.println(bag);
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
        System.out.println(pairbag);
        System.out.println("Извлекли: " + pairbag.pick());
        System.out.println(pairbag);
    }
}
