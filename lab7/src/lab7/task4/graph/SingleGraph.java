package lab7.task4.graph;

import javax.swing.*;
import java.awt.*;

public class SingleGraph extends JPanel {
    private Curve curve;
    private Func func;
    protected final Axis axises;
    public SingleGraph(Func func) {
        setBackground(super.getBackground());
        this.curve = new Curve();
        curve.setColor(super.getForeground());
        setCurve(func);
        this.func = func;
        this.axises = new Axis();
    }
    public void setCurve(Func func) {
        double[] xData = new double[100];
        double[] yData = new double[100];
        switch (func) {
            case SIN -> {
                for (int i = 0; i < 100; i++) {
                    xData[i] = i * 2 * Math.PI / 100;
                    yData[i] = Math.sin(xData[i]);
                }
            }
            case SINCOS -> {
                for (int i = 0; i < 100; i++) {
                    xData[i] = i * 2 * Math.PI / 100;
                    yData[i] = Math.sin(xData[i]*xData[i]) + Math.cos(xData[i]*xData[i]);
                }
            }
            case SINCOS2 -> {
                for (int i = 0; i < 100; i++) {
                    xData[i] = i * 2 * Math.PI / 100;
                    yData[i] = 2 * Math.sin(xData[i]) + Math.cos(2 * xData[i]);
                }
            }
        }
        curve.setLabel(func.label);
        curve.setData(xData, yData);
    }
    public void setCurveColor(Color color) {
        curve.setColor(color);
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
