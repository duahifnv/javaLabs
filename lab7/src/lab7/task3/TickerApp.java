package lab7.task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TickerApp extends JLabel {
    private String[] strings;
    private String iterableString;
    private int selectedString = 0;
    private Timer t;

    public TickerApp(String[] strings) {
        this.strings = strings;
        iterableString = strings[selectedString];

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cycleString();
            }
        });

        t = new Timer(25, e -> {
            move();
            repaint();
        });
        t.start();
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
        iterableString = strings[selectedString];
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        var g2 = (Graphics2D) g;
        g2.setFont(new Font("MONTSERRAT", Font.PLAIN, 26));
        g2.drawString(iterableString, 0, 50);
    }

    private void move() {
        var fchar = iterableString.charAt(0);
        iterableString = iterableString.substring(1);
        iterableString += fchar;
    }

    private void cycleString() {
        if (selectedString == strings.length - 1) {
            selectedString = 0;
        }
        else {
            selectedString++;
        }
        iterableString = strings[selectedString];
    }
}
