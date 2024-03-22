package lab4.carTyped;

public final class BusCar extends CarTyped {
    protected final static Type type = Type.BUS;
    protected final static MarkType markType = MarkType.TYPE1;
    public BusCar(String model, String color) {
        super(type, markType, model, color, 8);
    }
    public BusCar(String model, String color, int wheelsCount, String registerMark) {
        super(type, markType, model, color, 8, registerMark);
    }
}
