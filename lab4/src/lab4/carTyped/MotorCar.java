package lab4.carTyped;

import utils.Regex;

public class MotorCar extends Car {
    protected final Type type = Type.MOTOR;
    protected final MarkType markType = MarkType.TYPE1;
    public MotorCar(String model, String color, int wheelsCount) {
        super(model, color, wheelsCount);
    }
    public MotorCar(String model, String color, int wheelsCount, String registerMark) {
        super(model, color, wheelsCount, registerMark);
    }
}
