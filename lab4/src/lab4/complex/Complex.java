package lab4.complex;

public class Complex {
    private double x;
    private double y;
    private String algebraic;
    private String trigonometric;

    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
        this.algebraic = String.format("%.02f + %.02f * i", x, y);  // z = x + i*y;
        double AbsR = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double Phi = Math.atan(y / x);
        this.trigonometric = String.format("%.02f * (cos(%.02f) + i * sin(%.02f))", AbsR, Phi, Phi);
    }
    public double getReal() {
        return x;
    }
    public double getMnemo() {
        return y;
    }
    public String getAlgebraic() {
        return algebraic;
    }
    public String getTrigonometric() {
        return trigonometric;
    }
    public Boolean isEqual(Complex z1, Complex z2) {
        return (z1.getReal() == z2.getReal() && z1.getMnemo() == z2.getMnemo());
    }
    public static String Sum(Complex z1, Complex z2) {
        double x = z1.getReal() + z2.getReal();
        double y = z1.getMnemo() + z2.getMnemo();
        return String.format("%.02f + %.02f * i", x, y);
    }
    public static String Subtract(Complex z1, Complex z2) {
        double x = z1.getReal() - z2.getReal();
        double y = z1.getMnemo() - z2.getMnemo();
        return String.format("%.02f + %.02f * i", x, y);
    }
    public static String Multiply(Complex z1, Complex z2) {
        double x = z1.getReal() * z2.getReal() - z1.getMnemo() * z2.getMnemo();
        double y = z1.getReal() * z2.getMnemo() + z2.getReal() * z1.getMnemo();
        return String.format("%.02f + %.02f * i", x, y);
    }
    public static String Divide(Complex z1, Complex z2) {
        double xdiv = z1.getReal() * z2.getReal() + z1.getMnemo() * z2.getMnemo();
        double ydiv = z2.getReal() * z1.getMnemo() - z1.getReal() * z2.getMnemo();
        double mod = Math.pow(z2.getReal(), 2) + Math.pow(z2.getMnemo(), 2);
        return String.format("%.02f + %.02f * i", xdiv / mod, ydiv / mod);
    }
}
