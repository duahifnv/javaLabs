package lab4.carTyped;

import lab4.car.Engine;
import lab4.carTyped.types.*;
import utils.Input;

import java.util.*;

public class CarBase {
    protected Map<String, CarTyped> carContainer;
    protected final int maxSize;
    protected final String label;
    public CarBase(int maxSize, String label) {
        this.maxSize = maxSize;
        this.carContainer = new HashMap<>();
        this.label = label;
    }
    public void NewCar(CarTyped.Type type, String model, Engine engine, String color) {
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
        carContainer.put(model, newCar);
        System.out.printf("%s: %d/%d%n", label, carContainer.size(), maxSize);
        if (carContainer.size() == maxSize) System.out.printf(LogMessage.FULLBASE.getMessage() , label);
    }
    public void RemoveCar(String carLabel) {
        if (carContainer.size() == 0) {
            System.out.printf(LogMessage.EMPTYBASE.getMessage() + "Невозможно удалить ТС%n", label);
            return;
        }
        if (carContainer.get(carLabel) == null) {
            System.out.printf(LogMessage.NOSUCHCAR.getMessage(), label, carLabel);
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
        System.out.printf("%s отправлен в рейс с %s%n", carLabel, label);
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
        System.out.printf("%s отправлен в ремонт в %s%n", carLabel, label);
    }
    public void OnBase(String carLabel) {
        CarTyped car;
        try {
            car = carContainer.get(carLabel);
        } catch (Exception NullPointerException) {
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
        System.out.printf("%s отправлен на базу в %s%n", carLabel, label);
    }
    protected void PrintList(String title, CarTyped.Location location) {
        String lineBreak = "------------------";
        if (carContainer.size() == 0) {
            System.out.printf(LogMessage.EMPTYBASE.getMessage(), label);
            return;
        }
        System.out.println(title);
        int count = 0;
        for (Map.Entry<String, CarTyped> car : carContainer.entrySet()) {
            if (car.getValue().GetLocation() == location) {
                System.out.println(car.getKey());
                count++;
            }
        }
        if (count == 0) System.out.println(LogMessage.NOCARS.getMessage());
        System.out.println(lineBreak);
    }
    public void PrintInOrder() {
        PrintList("БАЗА: Исправные", CarTyped.Location.BASE);
    }
    public void PrintBroken() {
        PrintList("БАЗА: Неисправные", CarTyped.Location.REPAIR);
    }
    public void PrintOnRoad() {
        PrintList("В ПУТИ", CarTyped.Location.ONROAD);
    }
}
enum LogMessage {
    EMPTYBASE("%s пуста%n"),
    FULLBASE("Место на автобазе %s закончилось%n"),
    STAT("%s: %d/%d%n"),
    NOSUCHCAR("В %s отсутствует ТС с именем %s"),
    ADD("%s добавлен в %s%n"),
    REMOVE("%s удален с %s%n"),
    NOTONBASE("%s не на базе или неисправен%n"),
    NOCARS("ТС отсуствуют");
    private String message;
    LogMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return "!" + message;
    }
}
