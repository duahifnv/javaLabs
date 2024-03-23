package lab4.carTyped;

import lab4.carTyped.*;
import lab4.car.Engine;
import lab4.carTyped.types.*;
import utils.Input;

import java.util.HashMap;
import java.util.Map;

public class CarBase {
    private Map<String, CarTyped> carContainer;
    private final int maxSize;
    private final String label;
    public CarBase(int maxSize, String label) {
        this.maxSize = maxSize;
        this.carContainer = new HashMap<>();
        this.label = label;
    }
    public void NewCar(CarTyped.Type type, String model, Engine engine, String color, CarTyped.Location location) {
        if (carContainer.size() == maxSize) {
            System.out.printf(LogMessage.FULLBASE.getMessage() + "Добавить ТС нельзя%n", label);
            return;
        }
        CarTyped newCar;
        switch (type) {
            case MOTOR -> newCar = new MotorCar(model, engine, color, CarTyped.Location.BASE);
            case TRUCK -> newCar = new TruckCar(model, engine, color, CarTyped.Location.BASE);
            case BUS -> newCar = new BusCar(model, engine, color, CarTyped.Location.BASE);
            default -> {
                int wheelsCount = Input.Size("Введите число колес: ", 2, 10);
                newCar = new SpecialCar(model, engine, color, wheelsCount, CarTyped.Location.BASE);
            }
        }
        String newCarLabel = String.format("%s%d", type.GetType(), carContainer.size() + 1);
        carContainer.put(newCarLabel, newCar);
        System.out.printf("%s: %d/%d%n", label, carContainer.size(), maxSize);
        if (carContainer.size() == maxSize) System.out.printf(LogMessage.FULLBASE.getMessage() , label);
    }
    public void RemoveCar(String carLabel) {
        if (carContainer.size() == 0) {
            System.out.printf(LogMessage.EMPTYBASE.getMessage() + "Невозможно удалить ТС%n", label);
            return;
        }
        carContainer.remove(carLabel);
        System.out.printf(LogMessage.REMOVE.getMessage(), carLabel, label);
    }
    public void OnRoad(String carLabel) {
        CarTyped car;
        try {
            car = carContainer.get(carLabel);
        }
        catch (Exception NullPointerException) {
            System.out.printf(LogMessage.NOSUCHCAR.getMessage(), label, carLabel);
            return;
        }
        if (carContainer.size() == 0) {
            System.out.printf(LogMessage.EMPTYBASE.getMessage() + "Невозможно отправить %s в рейс%n", label, carLabel);
            return;
        }
        if (carContainer.get(carLabel).GetLocation() != CarTyped.Location.BASE) {
            System.out.printf(LogMessage.NOTONBASE.getMessage() + "Невозможно отправить ТС в рейс%n", carLabel);
            return;
        }
        car.SetLocation(CarTyped.Location.ONROAD);
        System.out.printf("%s отправлен в рейс с %s", carLabel, label);
    }
    public void OnRepair(String carLabel) {
        CarTyped car;
        try {
            car = carContainer.get(carLabel);
        }
        catch (Exception NullPointerException) {
            System.out.printf(LogMessage.NOSUCHCAR.getMessage(), label, carLabel);
            return;
        }
        if (carContainer.size() == 0) {
            System.out.printf(LogMessage.EMPTYBASE.getMessage() + "Невозможно отправить %s в ремонт%n", label, carLabel);
            return;
        }
        if (carContainer.get(carLabel).GetLocation() != CarTyped.Location.BASE) {
            System.out.printf(LogMessage.NOTONBASE.getMessage() + "Невозможно отправить ТС в ремонт%n", carLabel);
            return;
        }
        car.SetLocation(CarTyped.Location.REPAIR);
        System.out.printf("%s отправлен в ремонт В %s", carLabel, label);
    }
    public void OnBase(String carLabel) {
        CarTyped car;
        try {
            car = carContainer.get(carLabel);
        }
        catch (Exception NullPointerException) {
            System.out.printf(LogMessage.NOSUCHCAR.getMessage(), label, carLabel);
            return;
        }
        if (carContainer.size() == 0) {
            System.out.printf(LogMessage.EMPTYBASE.getMessage() + "Невозможно отправить %s в ремонт%n", label, carLabel);
            return;
        }
        if (carContainer.get(carLabel).GetLocation() == CarTyped.Location.BASE) {
            System.out.printf("%s уже на базе", carLabel);
            return;
        }
        car.SetLocation(CarTyped.Location.BASE);
        System.out.printf("%s отправлен в %s", carLabel, label);
    }
    // TODO: Вывод информации об автобазе
    /*public class Print {
        public void OnBase() {

        }
        public void OnRoad() {}
        public void OnRepair() {}
    }*/
}

enum LogMessage {
    EMPTYBASE("%s пуста%n"),
    FULLBASE("Место на автобазе %s закончилось%n"),
    STAT("%s: %d/%d%n"),
    NOSUCHCAR("В %s отсутствует ТС с именем %s"),
    ADD("%s добавлен в %s"),
    REMOVE("%s удален с %s"),
    NOTONBASE("%s не на базе или неисправен%n");
    private String message;
    LogMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
