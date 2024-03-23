package lab4.carTyped.types;

import lab4.car.Engine;
import lab4.carTyped.CarTyped;

public final class BusCar extends CarTyped {
    protected final static Type type = Type.BUS;
    protected final static MarkType markType = MarkType.TYPE1;
    public BusCar(String model, Engine engine, String color, Location location) {
        super(type, location, engine, markType, model, color, 8);
    }
    public BusCar(String model, Engine engine, String color, String registerMark, Location location) {
        super(type, location, engine, markType, model, color, 8, registerMark);
    }
}
