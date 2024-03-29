package lab4.car;

import utils.Regex;
import utils.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
    Класс автотранспорта
 */

public class Car {
    public enum Type {
        MOTOR("Легковой автомобиль"),
        TRUCK("Грузовой автомобиль"),
        BUS("Автобус");
        private String type;
        Type(String type) {
            this.type = type;
        }
        public String getTitle() {
            return type;
        }
    }
    private String regMark_mask = "[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2}RUS";
    private String registerMark = "Не присвоен";
    private String model;
    public String color;
    private Type type;
    private int wheels_count;
    private Engine engine;
    public Car(Type type, String model, String color, Engine engine, int wheels_count) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.wheels_count = wheels_count;
    }
    public Car(Type type, String model, String color, Engine engine, int wheels_count, String registerMark) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.wheels_count = wheels_count;
        this.registerMark = registerMark;
    }
    public void setEngine(int power, int volume, Fuel fuelType, int fuelConsumption, int numberOfCylinders, String serialCode) {
        this.engine = new Engine(power, volume, fuelType, fuelConsumption, numberOfCylinders, serialCode);
    }
    public void setRegisterMark(String registerMark) {
        Regex regex = new Regex("Маска рег. знака", regMark_mask);
        if (!regex.MatchLine(registerMark)) throw new Error("Некорректный формат рег. знака");
        this.registerMark = registerMark;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void printInfo() {
        int fieldSize = 30;
        List<List<String>> params = new ArrayList<>() {{
            add(new ArrayList<>(Arrays.asList("Рег. знака", registerMark)));
            add(new ArrayList<>(Arrays.asList("Марка", model)));
            add(new ArrayList<>(Arrays.asList("Вид", type.getTitle())));
            add(new ArrayList<>(Arrays.asList("Цвет", color)));
            add(new ArrayList<>(Arrays.asList("Расход топлива", String.valueOf(engine.getFuelConsumption()))));
            add(new ArrayList<>(Arrays.asList("Кол-во колес", String.valueOf(wheels_count))));

        }};
        Table.PrintTable(2, Arrays.asList("Свойство", "Значение"), params, "Информация о ТС", Collections.nCopies(2, fieldSize));
    }
    public void printEngineInfo() {
        engine.printInfo();
    }
}


