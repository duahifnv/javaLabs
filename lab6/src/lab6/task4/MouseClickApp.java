package lab6.task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickApp extends JPanel {
    private JLabel coordinatesLabel;
    public MouseClickApp() {
        // TODO: Убрать центрирование
        coordinatesLabel = new JLabel("Нажмите, чтобы увидеть координаты", SwingConstants.CENTER);
        coordinatesLabel.setFont(new Font("Sans Serif", Font.BOLD, 25));
        add(coordinatesLabel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                coordinatesLabel.setText("(" + x + ", " + y + ")");
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Color textColor = switch (e.getKeyChar()) {
                    case 'b' -> Color.BLACK;
                    case 'w' -> Color.WHITE;
                    case 'r' -> Color.RED;
                    case 'g' -> Color.GREEN;
                    case 'o' -> Color.ORANGE;
                    default -> null;
                };
                if (textColor != null) {
                    coordinatesLabel.setForeground(textColor);
                }
            }
        });

        setFocusable(true);
        requestFocus();

        setVisible(true);
    }
}
