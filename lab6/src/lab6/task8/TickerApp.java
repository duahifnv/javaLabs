package lab6.task8;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class TickerApp extends JPanel {
    private int startX = 0;
    private final int startY = 35;
    private int currentIndex = 0;
    private final String[] messages;
    private final Font font = new Font("Arial", Font.BOLD, 28);
    public TickerApp(String[] messages) {
        this.messages = messages;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeMessage();
            }
        });
    }
    private void changeMessage() {
        Random random = new Random();
        int randomIndex;
        do {
            randomIndex = random.nextInt(messages.length);
        }
        while (randomIndex == currentIndex);
        currentIndex = randomIndex;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(font);
        g2d.drawString(messages[currentIndex], startX, startY);
        g2d.dispose();
    }
    public void run() {
        while (true) {
            startX++;
            try {
                Thread.sleep(2);
            }
            catch(Exception ignored) {}
            if (startX >= getWidth()) {
                startX = 0;
            }
            repaint();
        }
    }

}