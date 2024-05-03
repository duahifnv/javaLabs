package lab6.task2;
import javax.swing.*;
import java.awt.*;

public class Curve extends JPanel {
    private double[] xData;
    private double[] yData;
    private double minX, maxX, minY, maxY;
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

    public void setCoordinates(double minX, double maxX, double minY, double maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (xData == null || yData == null) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        double scaleX = width / (maxX - minX);
        double scaleY = height / (maxY - minY);
        double offsetX = -minX * scaleX;
        double offsetY = -minY * scaleY;

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        for (int i = 0; i < xData.length - 1; i++) {
            int x1 = (int) (xData[i] * scaleX + offsetX);
            int y1 = (int) (height - (yData[i] * scaleY + offsetY));
            int x2 = (int) (xData[i + 1] * scaleX + offsetX);
            int y2 = (int) (height - (yData[i + 1] * scaleY + offsetY));
            g2d.drawLine(x1, y1, x2, y2);
        }
        g2d.dispose();
    }
}

