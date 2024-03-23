package lab4.carTyped.types;

import lab4.car.Engine;
import lab4.carTyped.CarTyped;

public class MotorCar extends CarTyped {
    protected final static Type type = Type.MOTOR;
    protected final static MarkType markType = MarkType.TYPE1;
    public MotorCar(String model, Engine engine, String color, Location location) {
        super(type, location, engine, markType, model, color, 4);
    }
    public MotorCar(String model, Engine engine, String color, String registerMark, Location location) {
        super(type, location, engine, markType, model, color, 4, registerMark);
    }
}
