package lab4.carTyped;

public class SpecialCar extends CarTyped {
    protected final static Type type = Type.SPECIAL;
    protected final static MarkType markType = MarkType.TYPE3;
    public SpecialCar(String model, String color, int wheelsCount) {
        super(type, markType, model, color, wheelsCount);
    }
    public SpecialCar(String model, String color, int wheelsCount, String registerMark) {
        super(type, markType, model, color, wheelsCount, registerMark);
    }
}
