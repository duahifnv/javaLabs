package lab4.carTyped.types;

import lab4.car.Engine;
import lab4.carTyped.CarTyped;

public class SpecialCar extends CarTyped {
    protected final static Type type = Type.SPECIAL;
    protected final static MarkType markType = MarkType.TYPE3;
    public SpecialCar(String model, Engine engine, String color, int wheelsCount, Location location) {
        super(type, location, engine, markType, model, color, wheelsCount);
    }
    public SpecialCar(String model, Engine engine, String color, String registerMark, int wheelsCount, Location location) {
        super(type, location, engine, markType, model, color, wheelsCount, registerMark);
    }
}
