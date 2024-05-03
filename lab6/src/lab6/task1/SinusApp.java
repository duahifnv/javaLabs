package lab6.task1;

import javax.swing.*;
import java.awt.*;

public class SinusApp {
    public static void draw(int width, int height) {
        JFrame frame = new JFrame("sin(x)");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                int w = getWidth();
                int h = getHeight();
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, w - 1, h - 1);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g.setColor(Color.BLACK);
                g.drawLine(0, h / 2, w, h / 2);
                g.drawLine(w / 2, 0, w / 2, h);
                g.setColor(Color.BLUE);
                double k = (2 * Math.PI) / w;
                for (int i = 0; i < w; i++) {
                    g.drawLine(i, (int) Math.round((h / 2) + Math.sin(i * k) * 100), i + 1, (int) Math.round((h / 2) + Math.sin((i + 1) * k) * 100));
                }

            }
        };
        frame.add(panel);
        frame.setVisible(true);
    }
}
