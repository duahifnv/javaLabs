import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskMng {
    public static void Task1() {
        System.out.println("Задание 1");

        String[] labels = {"Тип данных", "Минимальное значение",
                "Максимальное значение"};
        String[][] params = {
            { "Boolean", String.valueOf(
                        false), String.valueOf(true) },
            { "Byte", String.valueOf(Byte.MIN_VALUE), String.valueOf(Byte.MAX_VALUE) },
            { "Short", String.valueOf(Short.MIN_VALUE), String.valueOf(Short.MAX_VALUE) },
            { "Integer", String.valueOf(Integer.MIN_VALUE), String.valueOf(Integer.MAX_VALUE) },
            { "Long", String.valueOf(
                        Long.MIN_VALUE), String.valueOf(
                                Long.MAX_VALUE) },
            { "Float", String.valueOf(Float.MIN_VALUE), String.valueOf(
                        Float.MAX_VALUE) },
            { "Double", String.valueOf(Double.MIN_VALUE), String.valueOf(
                        Double.MAX_VALUE) }
        };
        int[] fieldSizes = {10, 20, 22};
        Utils.PrintTable(3, labels, params, fieldSizes);
    }
    public static void Task2() {
        System.out.println("Задание 2");

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        Integer size = scan.nextInt();
        System.out.print("Введите минимальное значение в массиве: ");
        Integer min_value = scan.nextInt();
        System.out.print("Введите максимальное значение в массиве: ");
        Integer max_value = scan.nextInt();

        int[] values = Utils.CreateArray(size, min_value, max_value);
        System.out.println(Arrays.toString(values));
        values = new int[]{-3,-3,10,20};
        Integer mult = 1;
        for (int value : values) {
            if(value < 0) mult *= value;
        }
        Double gMean = Math.sqrt(mult);
        gMean = (gMean > 0) ? gMean : -gMean;
        System.out.println("Среднее геометрическое отрицательных элементов равно: " + gMean);
        scan.close();
    }
    public static void Task3() {
        System.out.println("Задание 3");

        Random rnd = new Random();
        // Поле 100х100
        final double x = rnd.nextDouble(201) - 100;
        final double y = rnd.nextDouble(201) - 100;
        System.out.println("Координаты обьекта: X - " + x + "\nКоординаты обьекта: Y - " + y);
        final double R = rnd.nextDouble(200);
        System.out.println("Расстояние R: " + R);
        final double r = rnd.nextDouble(R);
        System.out.println("Расстояние r: " + r);
        final double XYhyp = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("Расстояние обьекта: " + XYhyp);
        if(XYhyp <= r) System.out.println("Тревога");
        else if(XYhyp > r && XYhyp <= R) System.out.println("Обнаружен");
        else System.out.println("Не обнаружен");
    }
    public static void Task4() {
        System.out.println("Задание 4");

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите координату Х: ");
        final double x = scan.nextDouble();
        System.out.print("Введите координату Y: ");
        final double y = scan.nextDouble();
        System.out.print("Введите расстояние R: ");
        final double R = scan.nextDouble();
        System.out.print("Введите расстояние r: ");
        final double r = scan.nextDouble();
        final double XYhyp = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("Расстояние обьекта: " + XYhyp);
        if (XYhyp <= r)
            System.out.println("Тревога");
        else if (XYhyp > r && XYhyp <= R)
            System.out.println("Обнаружен");
        else
            System.out.println("Не обнаружен");
        scan.close();
    }
    public static void Task5(int val) {
        System.out.println("Задание 5");

        System.out.println("Введенное число (10 СС): " + val);
        String[] labels = {"Система счисления", "Число"};
        String[][] params = {
            {"Десятичная", Integer.toString(val)},
            {"Двоичная", Integer.toBinaryString(val)},
            {"Восьмеричная", Integer.toOctalString(val)},
            {"Шестнадцатеричная", Integer.toHexString(val)}
        };
        int[] fieldSizes = {20, 10};
        Utils.PrintTable(2, labels, params, fieldSizes);
    }

    public static void Task6() {
        System.out.println("Задание 6");

        Utils.PrintUTF16(0x0400, 16, 16);
        System.out.println();
        Utils.PrintUTF16(0x20a0, 2, 16);
    }
    public static void Task7() {
        System.out.println("Задание 7");

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = scan.nextLine();
        CharFinder finder = new CharFinder(str);
        finder.FindStat();
        finder.PrintStat();
        scan.close();
    }
    public static void Task9() {
        System.out.println("Задание 9");

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = scan.nextLine();
        System.out.print("Введите подстроку: ");
        String substr = scan.nextLine();
        Utils.CountSubstr(str, substr);
        scan.close();
    }
    public static void Task10() {
        System.out.println("Задание 10");

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = scan.nextLine();
        CycleStr cycle = new CycleStr(str);
        cycle.PrintCycles();
        scan.close();
    }
}
