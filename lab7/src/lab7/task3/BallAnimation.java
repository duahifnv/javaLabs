package lab7.task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class BallAnimation extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private boolean active = false;
    public BallAnimation() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!active) return;
                super.mouseClicked(e);
                int x = e.getX();
                int y = e.getY();
                Color color = getRandomColor();
                int speed = getRandomSpeed();
                int diameter = getRandomDiameter();
                balls.add(new Ball(x, y, color, speed, diameter));
            }
        });
        setVisible(true);
    }

    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private int getRandomSpeed() {
        Random random = new Random();
        return random.nextInt(1) + 1;
    }

    private int getRandomDiameter() {
        Random random = new Random();
        return random.nextInt(20) + 20;
    }
    public void startAnimation() {
        active = true;
        new Thread(() -> {
            while (active) {
                for (Ball ball : balls) {
                    ball.move();
                    repaint();
                }
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void stopAnimation() {
        active = false;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    class Ball {
        private int x;
        private int y;
        private final int diameter;
        private final Color color;
        private final int speed;
        private int dx = 1;
        private int dy = 1;

        public Ball(int x, int y, Color color, int speed, int diameter) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.speed = speed;
            this.diameter = diameter;
        }
        public void move() {
            if (x <= 0 || x >= getWidth() - diameter) {
                dx = -dx;
            }
            if (y <= 0 || y >= getHeight() - diameter) {
                dy = -dy;
            }

            x += dx * speed;
            y += dy * speed;
        }
        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, diameter, diameter);
        }
    }
}
