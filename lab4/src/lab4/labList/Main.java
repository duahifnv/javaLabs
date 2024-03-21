package lab4.labList;

import lab4.car.Car;
import lab4.complex.Complex;
public class Main {
    public static void main(String[] args) {
        Car car = new Car(Car.Type.MOTOR, "Cherry Tiago 4 PRO", "Gray", 100, 4);
        car.printInfo();
        car.setColor("White");
        car.setEnginePower(200);
        car.printInfo();
    }
}