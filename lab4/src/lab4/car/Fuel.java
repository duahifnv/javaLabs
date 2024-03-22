package lab4.car;

public enum Fuel
{
    PETROL95("Бензин-АИ95"),
    PETROL92("Бензин-АИ92"),
    DIESEL("Дизель"),
    PROPANE("Пропан"),
    ELECTRO("Электричество");
    private String name;
    Fuel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
