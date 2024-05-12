package lab7.task4.graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

public class SingleGraph extends JPanel {
    private Curve curve;
    private Func func;
    protected final Axis axises;
    private double xMin = -Math.PI;
    private double xMax = Math.PI;
    private int scale = 1;
    public SingleGraph(Func func) {
        setBackground(super.getBackground());
        this.curve = new Curve();
        curve.setColor(super.getForeground());
        setCurve(func);
        this.func = func;
        this.axises = new Axis();
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                if (e.getWheelRotation() < 0) {
                    setInterval(++xMin, --xMax);
                }
                else {
                    setInterval(--xMin, ++xMax);
                }
            }
        });
    }
    public void setCurve(Func func) {
        this.func = func;
        int dataSize = scale * 100;
        double[] xData = new double[dataSize];
        double[] yData = new double[dataSize];
        for (double x = xMin, i = 0; x < xMax && i < dataSize; x += (xMax-xMin) / dataSize, i++) {
            xData[(int)i] = x;
        }
        switch (func) {
            case SIN -> {
                for (int i = 0; i < dataSize; i++) {
                    yData[i] = Math.sin(xData[i]);
                }
            }
            case SINCOS -> {
                for (int i = 0; i < dataSize; i++) {
                    yData[i] = Math.sin(xData[i]*xData[i]) + Math.cos(xData[i]*xData[i]);
                }
            }
            case SINCOS2 -> {
                for (int i = 0; i < dataSize; i++) {
                    yData[i] = 2 * Math.sin(xData[i]) + Math.cos(2 * xData[i]);
                }
            }
        }
        curve.setLabel(func.label);
        curve.setData(xData, yData);
    }
    public void setCurveColor(Color color) {
        curve.setColor(color);
        repaint();
    }
    public void setInterval(double xMin, double xMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        setCurve(func);
        repaint();
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
