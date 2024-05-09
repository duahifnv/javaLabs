package lab7.task4.graph;

import javax.swing.*;
import java.awt.*;

public class SingleGraph extends JPanel {
    private Curve curve;
    protected final Axis axises;
    protected double scale = 1;
    public SingleGraph() {
        setBackground(super.getBackground());
        this.axises = new Axis();
    }
    public void setCurve(Curve curve) {
        this.curve = curve;
    }
    public void setScale(double scale) {
        this.scale = scale;
    }
    public void setCurveColor(Color color) {
        curve.setColor(color);
        repaint();
    }
    public Curve getCurve() {
        return this.curve;
    }
    @Override
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

        curve.draw(g2d, width, height);
    }
}
