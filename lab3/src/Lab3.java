import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab3 {
    public static void t1() {
        System.out.println("Таблица значений функций");
        System.out.printf("%-10s| %-15s| %-15s\n", "x", "sin(x)", "e^x / x * lg(x)");
        double val1, val2;
        String textArg;
        for (double arg = Math.PI/15; arg < Math.PI; arg += Math.PI/15) {
            val1 = Math.sin(arg);
            val2 = Math.exp(arg) / arg * Math.log(arg);
            System.out.printf("%-10.5f| %-15.7f| %-15.7f\n", arg, val1, val2);
        }
    }

    public static void t2(int max_rows, int max_cols, Boolean randVals) {
        Random rnd = new Random();
        int n_rows = rnd.nextInt(max_rows - 1) + 1; // Случайное число строк
        int n_cols;                         // Число столбцов изменчиво

        String[][] array = new String[n_rows][];
        System.out.printf("Число строк: %d%n", n_rows);

        Boolean putVal = true;
        for (int r = 0; r < n_rows; r++) {
            n_cols = rnd.nextInt(max_cols - 1) + 1;
            array[r] = new String[n_cols];
            for (int c = 0; c < n_cols; c++) {
                if (randVals) putVal = rnd.nextBoolean();
                array[r][c] = (putVal) ? String.valueOf(rnd.nextInt(20) - 10) : "x";
            }
        }
        System.out.println(Arrays.deepToString(array));

        int max_value = -99999;
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                if (array[r][c] == "x" || Integer.valueOf(array[r][c]) >= 0) continue;
                max_value = Math.max(max_value, Integer.valueOf(array[r][c]));
            }
        }
        System.out.println("Наибольшее отрицательное значение: " + max_value);
    }
}
