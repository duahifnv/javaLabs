package lab6.task3;
import lab6.task3.Graph;

import javax.swing.*;
import java.awt.*;

public class Curve {
    private double[] xData;
    private double[] yData;
    private double minX, maxX, minY, maxY;
    private String label;
    public void setData(double[] xData, double[] yData) {
        if (xData.length != yData.length) {
            throw new IllegalArgumentException();
        }
        this.xData = xData;
        this.yData = yData;
        findBounds();
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
    public void setCoordinates(double minX, double maxX, double minY, double maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public void draw(Graphics2D g2d, int width, int height) {
        if (xData == null || yData == null) {
            return;
        }

        double scaleX = width / (maxX - minX);
        double scaleY = height / (maxY - minY);
        double offsetX = -minX * scaleX;
        double offsetY = -minY * scaleY;

        g2d.setColor(Color.BLACK);
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

