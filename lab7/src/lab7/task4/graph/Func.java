package lab7.task4.graph;

public enum Func {
    SIN("sin(x)"),
    SINCOS("sin(x*x)+cos(x*x)"),
    SINCOS2("2*sin(x)+cos(2*x)");
    public final String label;
    Func(String label) {
        this.label = label;
    }
}
