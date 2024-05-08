package lab7.task4.graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Graph extends JPanel {
    protected ArrayList<Curve> curves;
    protected final Axis axises;
    public Graph() {
        this.curves = new ArrayList<>();
        this.axises = new Axis();
    }
    public void addCurve(Curve curve) {
        curves.add(curve);
    }
    public Curve getCurve(int index) {
        try {
            return curves.get(index);
        }
        catch (IndexOutOfBoundsException ignored) {
            throw new Error("Нет кривой под индексом " + index);
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        axises.draw(g2d, width, height);

        double scaleX = width / (axises.xMaxValue - axises.xMinValue);
        double scaleY = height / (axises.yMaxValue - axises.yMinValue);
        double offsetX = -axises.xMinValue * scaleX;
        double offsetY = -axises.yMinValue * scaleY;

        for (Curve curve : curves) {
            curve.draw(g2d, width, height);
        }
    }
}

