package lab4.complex;

import java.lang.Math;
public class Complex {
    protected final double real;
    protected final double imag;
    protected final String algebraic;
    protected final String trigonometric;
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
        this.algebraic = String.format("%.02f + %.02f * i", real, imag);  // z = real + i*imag;
        double AbsR = Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
        double Phi = Math.atan(imag / real);
        this.trigonometric = String.format("%.02f * (cos(%.02f) + i * sin(%.02f))", AbsR, Phi, Phi);
    }
    public double real() {
        return real;
    }
    public double imag() {
        return imag;
    }
    public String getAlgebraic() {
        return algebraic;
    }
    public String getTrigonometric() {
        return trigonometric;
    }
    public Complex Pair(Complex z) {
        return new Complex(z.real, -z.imag());
    }
    public Boolean IsEqual(Complex z1, Complex z2) {
        return (z1.real() == z2.real() && z1.imag() == z2.imag());
    }

    public static Complex sum(Complex z1, Complex z2) {
        double real = z1.real() + z2.real();
        double imag = z1.imag() + z2.imag();
        return new Complex(real, imag);
    }
    public static Complex sub(Complex z1, Complex z2) {
        double real = z1.real() - z2.real();
        double imag = z1.imag() - z2.imag();
        return new Complex(real, imag);
    }
    public static Complex mul(Complex z1, Complex z2) {
        double real = z1.real() * z2.real() - z1.imag() * z2.imag();
        double imag = z1.real() * z2.imag() + z2.real() * z1.imag();
        return new Complex(real, imag);
    }
    public static Complex div(Complex z1, Complex z2) {
        double realdiv = z1.real() * z2.real() + z1.imag() * z2.imag();
        double ydiv = z2.real() * z1.imag() - z1.real() * z2.imag();
        double mod = Math.pow(z2.real(), 2) + Math.pow(z2.imag(), 2);
        return new Complex(realdiv / mod, ydiv / mod);
    }
    public static void PrintAlgebraic(Complex z) {
        System.out.printf("%.02f + %.02f * i", z.real, z.imag);
    }
    public static String PrintSum(Complex z1, Complex z2) {
        double real = z1.real() + z2.real();
        double imag = z1.imag() + z2.imag();
        return String.format("%.02f + %.02f * i", real, imag);
    }
    public static String PrintSubtract(Complex z1, Complex z2) {
        double real = z1.real() - z2.real();
        double imag = z1.imag() - z2.imag();
        return String.format("%.02f + %.02f * i", real, imag);
    }
    public static String PrintMultiply(Complex z1, Complex z2) {
        double real = z1.real() * z2.real() - z1.imag() * z2.imag();
        double imag = z1.real() * z2.imag() + z2.real() * z1.imag();
        return String.format("%.02f + %.02f * i", real, imag);
    }
    public static String PrintDivide(Complex z1, Complex z2) {
        double realdiv = z1.real() * z2.real() + z1.imag() * z2.imag();
        double ydiv = z2.real() * z1.imag() - z1.real() * z2.imag();
        double mod = Math.pow(z2.real(), 2) + Math.pow(z2.imag(), 2);
        return String.format("%.02f + %.02f * i", realdiv / mod, ydiv / mod);
    }
}
