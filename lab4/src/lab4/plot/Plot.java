package lab4.plot;

import java.util.ArrayList;

/**
 * Кривая на графике
 */
class Plot {
    private ArrayList<Point> points;
    private String label;
    private int size;
    private String color = "blue";
    public Plot(double[] x, double[] y, String label) {
        this.label = label;
        this.size = x.length;
        points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            points.add(createPoint(x[i], y[i]));
        }
        draw();
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    private Point createPoint(double x, double y) {
        return new Point(x, y);
    }
    private void draw() {
        System.out.printf("Отрисовка кривой %s. Цвет: %s%n", label, color);
    }
}
