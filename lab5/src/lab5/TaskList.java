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
}
