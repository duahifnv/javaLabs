package lab4.taskList;

import lab4.car.Car;
import lab4.complex.Complex;

public class taskList {
    public static void task1() {
        Car car = new Car(Car.Type.MOTOR, "Cherry Tiago 4 PRO", "Gray", 100, 4);
        car.printInfo();
        car.setColor("White");
        car.setEnginePower(200);
        car.printInfo();
    }
    public static void task2() {
        Complex z1 = new Complex(2, 3);
        System.out.println("Алгебраическая форма: " + z1.getAlgebraic());
        System.out.println("Тригонометрическая форма: " + z1.getTrigonometric());
        Complex z2 = new Complex(3.2, -1.2);
        System.out.printf("z1 = %s%n+%nz2 = %s%n---%n%s", z1.getAlgebraic(), z2.getAlgebraic(), Complex.Divide(z1,z2));
    }
}
