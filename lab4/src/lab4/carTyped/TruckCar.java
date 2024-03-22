package lab4.carTyped;

public final class TruckCar extends CarTyped {
    private final static Type type = Type.TRUCK;
    private final static MarkType markType = MarkType.TYPE2;
    public TruckCar(String model, String color, int wheelsCount) {
        super(type, markType, model, color, 4);
    }
    public TruckCar(String model, String color, int wheelsCount, String registerMark) {
        super(type, markType, model, color, 4, registerMark);
    }
}
