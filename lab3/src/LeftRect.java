public class LeftRect {
    public static double[][] CreateSteps(double start, double end, int steps_num) {
        double[] x = new double[steps_num];
        double[] y = new double[steps_num];
        int i = 0;
        for (double xi = start; (xi < end && i < steps_num); xi += (end - start) / steps_num, i++) {
            x[i] = xi;
            y[i] = GetY(xi);
        }
        PrintXY(6, steps_num, x, y);
        double[][] xy = {x, y};
        return xy;
    }

    private static void PrintXY(int size, int steps_num, double[] x, double[] y) {
        if(size >= steps_num) {
            System.out.println("Неверное число шагов для вывода");
            return;
        }
        System.out.printf("%-22s| %-22s%n", "X", "Y(X) = e^x - x^3");
        for(int i = 0; i < size / 2; i++) {
            System.out.printf("%-22s| %-22s%n", x[i], y[i]);
        }
        System.out.println("...");
        for (int i = 0; i < size / 2; i++) {
            System.out.printf("%-22s| %-22s%n", x[steps_num - size / 2 + i], y[steps_num - size / 2 + i]);
        }
    }

    private static double GetY(double x) {
        return Math.exp(x) - Math.pow(x, 3);
    }

    public static double Integrate(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length - 1; i++) {
            sum += y[i] * (x[i + 1] - x[i]);
        }
        return sum;
    }
}
