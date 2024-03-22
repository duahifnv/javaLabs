package lab4.carTyped;

import utils.Regex;

public class SpecialCar extends Car {
    protected final Type type = Type.SPECIAL;
    protected final MarkType markType = MarkType.TYPE3;
    public SpecialCar(String model, String color, int wheelsCount) {
        super(model, color, wheelsCount);
    }
    public SpecialCar(String model, String color, int wheelsCount, String registerMark) {
        super(model, color, wheelsCount, registerMark);
    }
}
