package lab7.task3;

import lab7.elements.Button;
import lab7.elements.Container;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Task3 extends JFrame {
    private boolean isAnimated = false;
    private final double IMG_RATIO = 0.5;
    public Task3() {
        JPanel container = new Container();
        BallAnimation animation = new BallAnimation();
        container.add(animation);
        JLabel mylabel = new JLabel("<html>" + "BallAnimation" + "</html>");
        mylabel.setHorizontalAlignment(SwingConstants.CENTER);
        mylabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        container.add(mylabel, BorderLayout.NORTH);

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

        JTextField textField = new JTextField();
        textField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        TextPrompt textPrompt = new TextPrompt("Макс. число шариков", textField, TextPrompt.Show.FOCUS_LOST);
        textField.setPreferredSize(new Dimension(200, 80));
        textField.setBorder(new EmptyBorder(10, 10, 10, 10));
        navContainer.add(textField);
        container.add(navContainer, BorderLayout.EAST);
        add(container);
        setSize(1280, 720);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task3::new);
    }
}
