package lab4.complex;

import java.lang.Math;
public class ComplexMath {
    public static Complex exp(Complex z) {
        double real = Math.exp(z.real()) * Math.cos(z.imag());
        double imag = Math.exp(z.real()) * Math.sin(z.imag());
        return new Complex(real, imag);
    }
    public static Complex sin(Complex z) {
        double real = Math.sin(z.real()) * Math.cosh(z.imag());
        double imag = Math.cos(z.real()) * Math.sinh(z.imag());
        return new Complex(real, imag);
    }
    public static Complex cos(Complex z) {
        double real = Math.cos(z.real()) * Math.cosh(z.imag());
        double imag = -Math.sin(z.real()) * Math.sinh(z.imag());
        return new Complex(real, imag);
    }
    public static Complex tan(Complex z) {
        return Complex.div(sin(z), cos(z));
    }
    public static Complex arctan(Complex z) {
        return Complex.div(cos(z), sin(z));
    }
    public static Complex sinh(Complex z) {
        double real = Math.sinh(z.real()) * Math.cos(z.imag());
        double imag = Math.cosh(z.real()) * Math.sin(z.imag());
        return new Complex(real, imag);
    }
    public static Complex cosh(Complex z) {
        double real = Math.cosh(z.real()) * Math.cos(z.imag());
        double imag = Math.sinh(z.real()) * Math.sin(z.imag());
        return new Complex(real, imag);
    }
    public static Complex tanh(Complex z) {
        return Complex.div(sinh(z), cosh(z));
    }
    public static Complex coth(Complex z) {
        return Complex.div(cosh(z), sinh(z));
    }
}
