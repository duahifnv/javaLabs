package lab7.task4.graph;

import java.awt.*;

public class Axis {
    double xMinValue;
    double xMaxValue;
    double yMinValue;
    double yMaxValue;
    private String xLabel;
    private String yLabel;
    public Axis() {
        this.xMinValue = 0.0;
        this.yMinValue = 1.0;
        this.xMaxValue = 1.0;
        this.yMaxValue = 1.0;
        this.xLabel = "X";
        this.yLabel = "Y";
    }

    public void setRange(double minValue, double maxValue) {
        this.xMinValue = minValue;
        this.xMaxValue = maxValue;
        this.yMinValue = minValue;
        this.yMaxValue = maxValue;
    }

    public void setXLabel(String label) {
        this.xLabel = label;
    }
    public void setYLabel(String label) {
        this.yLabel = label;
    }

    public void draw(Graphics2D g2d, int width, int height) {
        g2d.drawLine(0, height / 2, width, height / 2);
        g2d.drawString(xLabel, width - 20, height / 2 - 5);
        this.xMaxValue = width;

        g2d.drawLine(width / 2, 0, width / 2, height);
        g2d.drawString(yLabel, width / 2 + 10, 20);
        this.yMaxValue = height;
    }
}
