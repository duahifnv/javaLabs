package lab4.carTyped.types;

import lab4.car.Engine;
import lab4.carTyped.CarTyped;

public final class TruckCar extends CarTyped {
    private final static Type type = Type.TRUCK;
    private final static MarkType markType = MarkType.TYPE2;
    public TruckCar(String model, Engine engine, String color) {
        super(type, engine, markType, model, color, 4);
    }
    public TruckCar(String model, Engine engine, String color, String registerMark) {
        super(type, engine, markType, model, color, 4, registerMark);
    }
}
