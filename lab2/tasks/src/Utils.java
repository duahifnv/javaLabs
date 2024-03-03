import java.util.ArrayList;
import java.util.Random;

public class Utils{
    public static void PrintTable(int n_columns, String[] labels, String[][] params, int[] fieldSizes) {
        if(labels.length != n_columns || params[0].length != n_columns || fieldSizes.length != n_columns) {
            System.out.println("Количество столбцов не совпадает с количеством параметров!");
            return;
        }
        for (int i = 0; i < n_columns; i++) {
            String format = "%-" + fieldSizes[i % n_columns] + "s";
            System.out.printf(format, labels[i]);
            System.out.print(" | ");
        }
        System.out.println();
        for (int i = 0; i < params.length; i++) {
            for (int j = 0; j < n_columns; j++) {
                String format = "%-" + fieldSizes[j % n_columns] + "s";
                System.out.printf(format, params[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
    public static int[] CreateArray(int size, int min, int max) {
        int[] array = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            Integer iObj = rnd.nextInt((max - min) + 1) + min;
            array[i] = iObj;
        }
        return array;
    }
    public static void PrintUTF16(int hexCode, int n_rows, int n_columns) {
        if (n_rows < 1 || n_rows > 16 || n_columns < 1 || n_rows > 16) {
            System.out.println("Неверное числов строк или столбцов.");
            return;
        }

        String label = String.format("%-5sТаблица Unicode-16 ", "") +
        String.format("(0x%4s)", Integer.toHexString(hexCode)).replace(' ', '0');
        System.out.println(label);
        System.out.printf("%-5s", "");
        String output;

        for (int i = 0; i < n_columns; i++) {
            if (i < 10) output = Integer.toString(i) + " ";
            else output = Character.toString((char)(i + (int)'a') - 10) + " ";
            System.out.print(output);
        }
        System.out.println();
        int[] data = { 0 };
        int rowCode = hexCode;
        for (int i = 0; i < n_rows; i++) {
            System.out.format("%-4s ", Integer.toHexString(rowCode));
            for (int j = 0; j < n_columns; j++) {
                data[0] = hexCode;
                System.out.print(new String(data, 0, 1) + " ");
                hexCode++;
            }
            rowCode += 0x10;
            System.out.println();
        }
    }
    public static void CountSubstr(String str, String substr) {
        if(str.length() < substr.length()) {
            System.out.println("Длина искомой подстроки больше длины строки.");
            return;
        }
        ArrayList<Integer> substrIdx = new ArrayList<>();
        int start = 0;
        while(start <= str.length() - substr.length()) {
            int idx = str.indexOf(substr, start);
            if(idx == -1) break;
            substrIdx.add(idx);
            start = idx + 1;
        }
        if (substrIdx.size() == 0) {
            System.out.printf("Подстрока %s не найдена в строке %s.%n", substr, str);
        }
        else {
            System.out.printf("Индексы подстроки %s в строке %s: %s%n", substr, str, substrIdx.toString());
            System.out.printf("Количество вхождений: %d", substrIdx.size());
        }
    }
}
