package lab4.car;

import utils.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Engine {
    int power;
    int volume;
    Fuel fuelType;
    int fuelConsumption;
    int numberOfCylinders;
    private final String serialCode;
    public Engine(int power, int volume, Fuel fuelType, int fuelConsumption, int numberOfCylinders, String serialCode) {
        this.power = power;
        this.volume = volume;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.numberOfCylinders = numberOfCylinders;
        this.serialCode = serialCode;
    }
    public void printInfo() {
        int fieldSize = 30;
        List<List<String>> params = new ArrayList<>() {{
            add(new ArrayList<>(Arrays.asList("Серийный номер", serialCode)));
            add(new ArrayList<>(Arrays.asList("Мощность двигателя", String.valueOf(power))));
            add(new ArrayList<>(Arrays.asList("Рабочий объем", String.valueOf(volume))));
            add(new ArrayList<>(Arrays.asList("Вид топлива", fuelType.getName())));
            add(new ArrayList<>(Arrays.asList("Расход топлива", String.valueOf(fuelConsumption))));
            add(new ArrayList<>(Arrays.asList("Число цилиндров", String.valueOf(numberOfCylinders))));

        }};
        Table.PrintTable(2, Arrays.asList("Свойство", "Значение"), params, "Информация о двигателе", Collections.nCopies(2, fieldSize));
    }
    public int getPower() {
        return power;
    }
    public int getVolume() {
        return volume;
    }
    public String getFuelType() {
        return fuelType.getName();
    }
    public int getFuelConsumption() {
        return fuelConsumption;
    }
    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }
    public String getSerialCode() {
        return serialCode;
    }
}
