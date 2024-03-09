import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

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

    public static void t3() {
        Random rnd = new Random();
        int [][] array = new int[3][3];
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array.length; c++) {
                array[r][c] = rnd.nextInt(20);
            }
        }
        System.out.printf("Неупорядоченный массив%n%s%n", Arrays.deepToString(array));
        // Сортировка пузырьком
        int temp;
        for (int r = 0; r < array.length; r++) {
            int n = array[r].length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[r][j] > array[r][j+1]) {
                        temp = array[r][j];
                        array[r][j] = array[r][j+1];
                        array[r][j+1] = temp;
                    }
                }
            }
        }
        System.out.printf("Упорядоченный массив%n%s", Arrays.deepToString(array));
    }
    public static void t4() {
        Scanner scan = new Scanner(System.in);
        int val;
        int vals[] = new int[6];
        String[] lits = {"x", "y", "r"};
        int i = 0;
        while (i < 6) {
            System.out.printf("Введите %s: ", lits[i % 3] + String.valueOf((i / 3) + 1));
            try {
                val = scan.nextInt();
                if((lits[i % 3]) == "r" && val <= 0) {
                    System.out.println("Радиус должен быть положительным");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Введено неверное значение");
                scan.nextLine();
                continue;
            }
            vals[i] = val;
            i++;
        }
        CirclesState.SolveState(vals[0], vals[1], vals[2], vals[3], vals[4], vals[5]);
        System.out.println(CirclesState.GetCode());
        scan.close();
    }
    public static void t5() {
        // см. Lab3.t4()
    }
    public static void t6() {
        double MathCadSolve = 1.4682818284590449;
        double[][] steps = LeftRect.CreateSteps(0, 1, 101);
        double answer = LeftRect.Integrate(steps[0], steps[1]);
        System.out.println("Интеграл через метод левых прямоугольников: " + answer);
        System.out.println("Разница с Маткадом: +-" + Math.abs(answer - MathCadSolve));
    }
    public static void t7() {
        int num = (int) Input.Double(0, Double.POSITIVE_INFINITY, "Введите число в 10СС");
        int base = (int) Input.Double(2, 8, "Введите СС (2-8)");
        System.out.printf("Мой метод - Число %d в %d-ичной СС: %d%n", num, base, DecToBase.ConvertTo(num, base));
        System.out.printf("Метод toString - Число %d в %d-ичной СС: %s%n ", num, base, Integer.toString(num, base));
    }
    public static void t8() {
        int size = (int) Input.Double(1, 20, "Введите число коэфициентов");
        int alloc_size = (size > 1) ? size : size + 1;
        int[] coefs = new int[alloc_size];
        if (size == 1) coefs[1] = 0;
        for (int i = 0; i < size; i++) {
            coefs[i] = (int) Input.Double(-50,
             50, "Введите a"  + (size - i - 1));
        }
        // P = (a2 * x + a1) * x + a0
        int x = (int) Input.Double(-50, 50, "Введите X");
        int poly = coefs[0] * x + coefs[1];
        String stdPoly = "P = " + "(".repeat(alloc_size - 1) + coefs[0] + "x + " + coefs[1] + ")";
        String valPoly = "P = " + "(".repeat(alloc_size - 1) + coefs[0] + " * " + x + " + " + coefs[1] + ")";
        for (int i = 2; i < size; i++) {
            poly = poly * x + coefs[i];
            stdPoly += "x + " + coefs[i] + ")";
            valPoly += " * " + x + " + " + coefs[i] + ")";
        }
        stdPoly += " = " + poly;
        valPoly += " = " + poly;
        System.out.println(stdPoly + "\n" + valPoly);
    }
    public static void t9(Boolean fullMatch) {
        Regex ru = new Regex("Россия",
                "((\\+7)|8)(([- ]?[0-9]{3}[- ]?)|([(][0-9]{3}[)]))([0-9]{3}[- ]?)([0-9]{2}[- ]?)([0-9]{2})");
        Regex ro = new Regex("Ростов-на-Дону", "([2-3][- ]?)([0-9]{2}[- ]?)([0-9]{2}[- ]?)([0-9]{2})");
        Regex[] regs = {ru, ro};

        System.out.print("Введите строку: ");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        if (fullMatch) {
            for (Regex re : regs) {
                if (re.MatchLine(line)) System.out.println(re.GetLabel() + ": Корректный номер");
                else System.out.println(re.GetLabel() + ": Некорректный номер");
            }
        }
        else {
            for (Regex re : regs) {
                if (re.InLine(line)) System.out.println(re.GetLabel() + ": Содержится в строке");
                else System.out.println(re.GetLabel() + ": Не содержится в строке");
            }
        }
        scan.close();
    }
    public static void t10() {
        Regex ru = new Regex("Россия",
                "((\\+7)|8)(([- ]?[0-9]{3}[- ]?)|([(][0-9]{3}[)]))([0-9]{3}[- ]?)([0-9]{2}[- ]?)([0-9]{2})");
        Regex ro = new Regex("Ростов-на-Дону", "([2-3][- ]?)([0-9]{2}[- ]?)([0-9]{2}[- ]?)([0-9]{2})");

        System.out.print("Введите строку: ");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        ArrayList<String> nums = new ArrayList<>();
        nums.addAll(ru.ExtractNums(line));
        nums.addAll(ro.ExtractNums(line));

        if(nums.size() == 0) System.out.println("В строке не найдено номеров");
        else System.out.println("Найденные номера: " + nums.toString());
        scan.close();
    }
}
