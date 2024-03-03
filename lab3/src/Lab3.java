public class Lab3 {
    public static void t1() {
        System.out.println("Таблица значений функций");
        System.out.printf("%10s|%15s|%15s\n", "x", "sin(x)", "e^x / x * lg(x)");
        double val1, val2;
        for (double arg = Math.PI/15; arg < Math.PI; arg += Math.PI/15) {
            val1 = Math.sin(arg);
            val2 = Math.exp(arg) / arg * Math.log(arg);
            System.out.printf("%10.5f|%15.7f|%15.7f\n", arg, val1, val2);
        }
    }
}
