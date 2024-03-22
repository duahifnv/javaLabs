package lab4.carTyped;

import lab4.car.Engine;
import utils.Table;
import utils.Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Car {
    protected enum MarkType {
        TYPE1("Трехномерной",
                "[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2}RUS"),
        TYPE2("Четырехномерной",
                "\\d{4}[АВЕКМНОРСТУХ]{2}\\d{2}RUS"),
        TYPE3("Специальный",
                "\\d{2}[АВЕКМНОРСТУХ]{3}[%&$]{1}\\d{2}RUS");
        private final String type;
        private final String regMask;
        MarkType(String type, String regMask) {
            this.type = type;
            this.regMask = regMask;
        }
        protected String GetRegMask() {
            return regMask;
        }
    }
    protected enum Type {
        MOTOR("Легковой автомобиль"),
        TRUCK("Грузовой автомобиль"),
        BUS("Автобус"),
        SPECIAL("Специальный транспорт");
        private String type;
        Type(String type) {
            this.type = type;
        }
        public String GetTitle() {
            return type;
        }
    }
    protected Type type;
    protected String registerMark = "Не присвоен";
    protected MarkType markType;
    private final String model;
    protected String color;
    private final int wheelsCount;
    protected Engine engine;

    public void SetEngine(Engine engine) {
        this.engine = engine;
    }
    public void PrintEngineInfo() {
        engine.printInfo();
    }
    public void SetRegisterMark(String registerMark) {
        Regex regex = new Regex("Маска рег. знака", markType.GetRegMask());
        if (!regex.MatchLine(registerMark)) throw new IllegalArgumentException("Некорректный формат рег. знака");
        this.registerMark = registerMark;
    }
    public String GetRegisterMark() {
        return registerMark;
    }
    public void SetColor(String color) {
        this.color = color;
    }
    public String GetColor() {
        return color;
    }
    public String GetModel() {
        return model;
    }
    public int GetWheelCount() {
        return wheelsCount;
    }
    public Car(String model, String color, int wheelsCount) {
        this.model = model;
        this.color = color;
        this.wheelsCount = wheelsCount;
    }
    public Car(String model, String color, int wheelsCount, String registerMark) {
        this.model = model;
        this.color = color;
        this.wheelsCount = wheelsCount;
        this.registerMark = registerMark;
    }

    public void PrintInfo() {
        int fieldSize = 30;
        List<List<String>> params = new ArrayList<>() {{
            add(new ArrayList<>(Arrays.asList("Рег. знака", registerMark)));
            add(new ArrayList<>(Arrays.asList("Марка", model)));
            add(new ArrayList<>(Arrays.asList("Вид", type.GetTitle())));
            add(new ArrayList<>(Arrays.asList("Цвет", color)));
            add(new ArrayList<>(Arrays.asList("Расход топлива", String.valueOf(engine.getFuelConsumption()))));
            add(new ArrayList<>(Arrays.asList("Кол-во колес", String.valueOf(wheelsCount))));

        }};
        Table.PrintTable(2, Arrays.asList("Свойство", "Значение"), params, "Информация о ТС", Collections.nCopies(2, fieldSize));
    }
}
