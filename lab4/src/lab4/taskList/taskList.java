package lab4.taskList;

import lab4.car.*;
import lab4.carTyped.*;
import lab4.complex.Complex;
import utils.Input;
import utils.Regex;

import java.util.Scanner;

public class taskList {
    public static void task1() {
        Engine engine = new Engine(100, 5, Fuel.DIESEL, 8, 3, "V2403 - 3L1245");
        Car car = new Car(Car.Type.MOTOR, "Cherry Tiago 4 PRO", "Gray", engine, 4);
        car.printInfo();
        car.setColor("White");
        car.printInfo();
    }
    public static void task2() {
        Complex z1 = new Complex(2, 3);
        System.out.println("Z1");
        System.out.println("Алгебраическая форма: " + z1.getAlgebraic());
        System.out.println("Тригонометрическая форма: " + z1.getTrigonometric());
        Complex z2 = new Complex(3.2, -1.2);
        System.out.println("Z2");
        System.out.println("Алгебраическая форма: " + z2.getAlgebraic());
        System.out.println("Тригонометрическая форма: " + z2.getTrigonometric());
        System.out.printf("z1 = %s%n/%nz2 = %s%n---%n%s", z1.getAlgebraic(), z2.getAlgebraic(), Complex.Divide(z1,z2));
    }
    public static void task3() {
        // ...
    }
    public static void task4() {
        Engine engine = new Engine(100, 5, Fuel.DIESEL, 8, 3, "V2403 - 3L1245");
        Car car = new Car(Car.Type.MOTOR, "Cherry Tiago 4 PRO", "Gray", engine, 4);
        car.printEngineInfo();
        car.setEngine(400, 10, Fuel.PETROL95, 15, 5, "G3405 - 4H1488");
        car.printEngineInfo();
    }
    public static void task5() {
        MotorCar motorCar = new MotorCar("Honda Civic 2012", "White");
        motorCar.SetRegisterMark();
    }
    public static void task6() {

    }
    public static void task7() {
        // TODO: Создать автобазу
    }
    public static void task8() {
        // TODO: Создать систему классов для построения графиков
    }
    public static void task9() {
        // TODO: Создать систему классов UML-диаграмм
    }
}
