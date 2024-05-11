package lab7.task6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Dice extends JPanel {
    private static int width;
    private static int height;
    private Color foreground;
    private Color background;
    private int value = getRandomValue();
    private static int CIRCLE_SIZE;
    private static int BORDER_SIZE;
    private final int borderRadius = 40;
    public Dice(int size) {
        super();
        width = size;
        height = size;
        CIRCLE_SIZE = size / 5;
        BORDER_SIZE = size / 10;
        Color temp = foreground;
        foreground = background;
        background = temp;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                value = getRandomValue();
                repaint();
            }
        });
    }
    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    public void setForeground(Color color) {
        this.foreground = color;
        repaint();
    }
    public void setBackground(Color color) {
        this.background = color;
        repaint();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(background);
        g.fillRoundRect(0, 0, width, height, borderRadius, borderRadius);
        g.setColor(foreground);
        if (value % 2 != 0) {
            g.fillOval(Position.CENTER.x,  Position.CENTER.y, CIRCLE_SIZE, CIRCLE_SIZE);
        }
        if (value > 1) {
            // Левый нижний круг
            g.fillOval(Position.BOTTOMLEFT.x,
                    Position.BOTTOMLEFT.y,
                    CIRCLE_SIZE, CIRCLE_SIZE);
            // Правый верхний круг
            g.fillOval(Position.TOPRIGHT.x,
                    Position.TOPRIGHT.y,
                    CIRCLE_SIZE, CIRCLE_SIZE);
        }
        if (value > 3) {
            // Левый верхний круг
            g.fillOval(Position.TOPLEFT.x,
                    Position.TOPLEFT.y,
                    CIRCLE_SIZE, CIRCLE_SIZE);
            // Правый нижний круг
            g.fillOval( Position.BOTTOMRIGHT.x, Position.BOTTOMRIGHT.y,
                    CIRCLE_SIZE, CIRCLE_SIZE);
        }
        if (value == 6) {
            // Левый центральный круг
            g.fillOval(Position.CENTERLEFT.x,
                    Position.CENTERLEFT.y,
                    CIRCLE_SIZE, CIRCLE_SIZE);
            // Правый центральный круг
            g.fillOval(Position.CENTERRIGHT.x,
                    Position.CENTERRIGHT.y,
                    CIRCLE_SIZE, CIRCLE_SIZE);
        }
    }
    enum Position {
        TOPLEFT(BORDER_SIZE,
                BORDER_SIZE),
        TOPRIGHT(Dice.width - BORDER_SIZE - CIRCLE_SIZE,
                BORDER_SIZE),
        BOTTOMRIGHT(Dice.width - BORDER_SIZE - CIRCLE_SIZE,
                Dice.height - BORDER_SIZE - CIRCLE_SIZE),
        BOTTOMLEFT(BORDER_SIZE,
                Dice.height - BORDER_SIZE - CIRCLE_SIZE),
        CENTER(Dice.width / 2 - CIRCLE_SIZE / 2,
                Dice.height / 2  - CIRCLE_SIZE / 2),
        CENTERLEFT(BORDER_SIZE,
                Dice.height / 2  - CIRCLE_SIZE / 2),
        CENTERRIGHT(Dice.width - BORDER_SIZE - CIRCLE_SIZE,
                Dice.height / 2  - CIRCLE_SIZE / 2);
        public int x;
        public int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
