package lab4.carTyped;

public final class TruckCar extends Car {
    private final Type type = Type.TRUCK;
    private final MarkType markType = MarkType.TYPE2;
    public TruckCar(String model, String color, int wheelsCount) {
        super(model, color, wheelsCount);
    }
    public TruckCar(String model, String color, int wheelsCount, String registerMark) {
        super(model, color, wheelsCount, registerMark);
    }
}
