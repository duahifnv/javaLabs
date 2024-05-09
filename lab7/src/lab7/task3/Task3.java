package lab7.task3;

import lab7.elements.Button;
import lab7.elements.Container;
import lab7.elements.Label;
import lab7.elements.ThemeManager;
import lab7.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class Task3 extends JFrame {
    private boolean isAnimated = false;
    static TickerApp tickerApp;
    static BallAnimation animation;
    private final double IMG_RATIO = 0.5;
    public Task3() {
        ThemeManager.initTheme(Theme.DARK);
        JPanel container = new Container();
        animation = new BallAnimation();
        container.add(animation);

        container.add(new Label("BallAnimation"), BorderLayout.NORTH);

        JPanel navContainer = new JPanel();
        navContainer.setLayout(new FlowLayout());
        navContainer.setPreferredSize(new Dimension(200, 400));

        Button startStopBtn = new Button();
        startStopBtn.setIcon("D:\\DSTU\\ява\\lab7\\img\\assets\\start.png", IMG_RATIO);
        startStopBtn.addActionListener(e -> {
            if (isAnimated) {
                startStopBtn.setIcon("D:\\DSTU\\ява\\lab7\\img\\assets\\start.png", IMG_RATIO);
                animation.stopAnimation();
            }
            else {
                startStopBtn.setIcon("D:\\DSTU\\ява\\lab7\\img\\assets\\stop.png", IMG_RATIO);
                animation.startAnimation();
            }
            isAnimated = !isAnimated;
        });
        navContainer.add(startStopBtn);

        JTextField textField = new TextField();
        TextPrompt textPrompt = new TextPrompt("Макс. число шариков", textField, TextPrompt.Show.FOCUS_LOST);
        JLabel errorMsg = new JLabel("Неверный ввод");
        errorMsg.setVisible(false);
        navContainer.add(textField);
        navContainer.add(errorMsg);
        textField.addActionListener(event -> {
            try {
                int content = Integer.parseInt(textField.getText());
                if (content < 1) throw new NumberFormatException();
                errorMsg.setVisible(false);
                animation.setMaxBalls(content);
            }
            catch (NumberFormatException exception) {
                errorMsg.setVisible(true);
            }
        });
        String[] messages = new String[]{String.format("Шариков на экране: %d%5s", animation.getCurrentSize(), ""),
                String.format("Максимальное число шариков: %d%5s", animation.getMaxBalls(), "")};
        tickerApp = new TickerApp(messages);
        tickerApp.setPreferredSize(new Dimension(200, 50));
        tickerApp.setBackground(Color.WHITE);
        navContainer.add(tickerApp);
        container.add(navContainer, BorderLayout.EAST);

        add(container);
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task3::new);
    }
}
