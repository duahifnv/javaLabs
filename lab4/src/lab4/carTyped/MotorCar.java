package lab4.carTyped;

public class MotorCar extends CarTyped {
    protected final static Type type = Type.MOTOR;
    protected final static MarkType markType = MarkType.TYPE1;
    public MotorCar(String model, String color) {
        super(type, markType, model, color, 4);
    }
    public MotorCar(String model, String color, String registerMark) {
        super(type, markType, model, color, 4, registerMark);
    }
}
