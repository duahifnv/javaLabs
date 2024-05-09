package lab7.task4.graph;

import java.awt.*;

public class Curve extends SingleGraph {
    private final double DEFAULT_MINX = 0;
    private final double DEFAULT_MAXX = 2 * Math.PI;
    private double[] xData;
    private double[] yData;
    private double minX, maxX, minY, maxY;
    private String label;
    private Color color = Color.BLACK;
    private Func func;
    public Curve(Func func) {
        this.func = func;
        xData = new double[(int)(scale * 100)];
        setForeground(super.getForeground());
        setInterval(DEFAULT_MINX, DEFAULT_MAXX);
    }
    public void setInterval(double xMin, double xMax) {
        if (xMin >= xMax) {
            throw new IllegalArgumentException();
        }
        for (double x = xMin, i = 0; x < xMax && i < scale; x += (xMax-xMin) / super.scale * 100, i++) {
            xData[(int)i] = x;
        }
        yData = func.getYdata(xData);
        findBounds();
        repaint();
    }
    public void setFunc(Func func) {
        this.func = func;
        setInterval(DEFAULT_MINX, DEFAULT_MAXX);
        repaint();
    }
    private void findBounds() {
        minX = Double.MAX_VALUE;
        maxX = Double.MIN_VALUE;
        minY = Double.MAX_VALUE;
        maxY = Double.MIN_VALUE;
        for (double x : xData) {
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
        }
        for (double y : yData) {
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void draw(Graphics2D g2d, int width, int height) {
        if (xData == null || yData == null) {
            return;
        }
        double scaleX = width / (maxX - minX);
        double scaleY = height / (maxY - minY);
        double offsetX = -minX * scaleX;
        double offsetY = -minY * scaleY;

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < xData.length - 1; i++) {
            int x1 = (int) (xData[i] * scaleX + offsetX);
            int y1 = (int) (height - (yData[i] * scaleY + offsetY));
            int x2 = (int) (xData[i + 1] * scaleX + offsetX);
            int y2 = (int) (height - (yData[i + 1] * scaleY + offsetY));
            g2d.drawLine(x1, y1, x2, y2);
        }
        g2d.drawString(label, 20, 20);
        g2d.dispose();
    }
}

