package lab4.taskList;

import lab4.car.*;
import lab4.carTyped.*;
import lab4.carTyped.types.*;
import lab4.complex.*;
import lab4.plot.*;

public class taskList {
    public static void task1() {
        Engine engine = new Engine(100, 5, Fuel.DIESEL, 8, 3, "V2403 - 3L1245");
        Car car = new Car(Car.Type.MOTOR, "Cherry Tiago 4 PRO", "Gray", engine, 4);
        car.printInfo();
        car.setColor("White");
        car.printInfo();
    }
    public static void task2(String real, String imag) {
        Complex z1 = new Complex(Integer.parseInt(real), Integer.parseInt(imag));
        System.out.println("Z1");
        System.out.println("Алгебраическая форма: " + z1.getAlgebraic());
        System.out.println("Тригонометрическая форма: " + z1.getTrigonometric());
        Complex z2 = new Complex(3.2, -1.2);
        System.out.println("Z2");
        System.out.println("Алгебраическая форма: " + z2.getAlgebraic());
        System.out.println("Тригонометрическая форма: " + z2.getTrigonometric());
        System.out.printf("z1 = %s%n/%nz2 = %s%n---%n%s", z1.getAlgebraic(), z2.getAlgebraic(), Complex.div(z1,z2).getAlgebraic());
    }
    public static void task3() {
        Complex z = new Complex(2, 3);
        Complex.PrintAlgebraic(ComplexMath.exp(z));
    }
    public static void task4() {
        Engine engine = new Engine(100, 5, Fuel.DIESEL, 8, 3, "V2403 - 3L1245");
        Car car = new Car(Car.Type.MOTOR, "Cherry Tiago 4 PRO", "Gray", engine, 4);
        car.printEngineInfo();
        car.setEngine(400, 10, Fuel.PETROL95, 15, 5, "G3405 - 4H1488");
        car.printEngineInfo();
    }
    public static void task5() {
        Engine engine = new Engine(400, 10, Fuel.PETROL95, 15, 5, "G3405 - 4H1488");
        MotorCar motorCar = new MotorCar("Honda Civic 2012", engine, "White", CarTyped.Location.BASE);
        motorCar.SetRegisterMark();
        System.out.println(motorCar.GetRegisterMark());
    }
    public static void task6() {
        // CarTyped car = new CarTyped();   ERROR: 'CarTyped' is abstract; cannot be instantiated
    }
    public static void task7() {
        CarBase carBase = new CarBase(3, "Ростсельмаш");
        Engine engine = new Engine(400, 10, Fuel.PETROL95, 15, 5, "G3405 - 4H1488");
        carBase.NewCar(CarTyped.Type.MOTOR, "Honda Civic 2012", engine, "White");
        carBase.NewCar(CarTyped.Type.TRUCK, "Какой-то трактор с Ростсельмаша", engine, "Yellow");
        carBase.NewCar(CarTyped.Type.BUS, "Шедевроавтобус", engine, "Green");
        carBase.PrintInOrder(); carBase.PrintBroken();
        carBase.OnRepair("Какой-то трактор с Ростсельмаша");
        carBase.PrintInOrder(); carBase.PrintBroken();
        carBase.RemoveCar("Шедевроавтобус");
        carBase.RemoveCar("Левое ТС");       // ERROR
    }
    public static void task8() {
        // TODO: Создать UML-диаграмм для taskList.task9()
    }
    public static void task9(String fig1, String fig2) {
        int figX = Integer.parseInt(fig1);
        int figY =  Integer.parseInt(fig2);
        Figure fig = new Figure(new int[]{figX, figY});
        fig.drawFigure();
        int accuracy = 20;  // Число точек
        double xMin = 1f;
        double xMax = 4f;
        double step = (xMax - xMin) / accuracy;
        double[] x = new double[accuracy];
        double[] y = new double[accuracy];
        int i = 0;
        for (double xi = xMin; i < accuracy && xi < xMax; xi += step, i++) {
            x[i] = xi;
            y[i] = Math.pow(xi, 2);
        }
        Axes ax = fig.setAxes(x[0], x[accuracy - 1], y[0], y[accuracy - 1], "Ось X", "Ось Y");
        ax.addPlot(x, y, "y=x^2");
        ax.setGrid(0.1, 0.1);
        ax.setLegend(Legend.Position.UPPERRIGHT, 1, 1);
    }
}
