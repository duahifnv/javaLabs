package lab7.task3;

import lab7.elements.Button;
import lab7.elements.Container;
import lab7.elements.RoundedBorder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Task3 extends JFrame {
    private BufferedImage startIcon;
    private BufferedImage stopIcon;
    public Task3() {
        JPanel container = new Container();
        BallAnimation animation = new BallAnimation();
        container.add(animation);
        JLabel mylabel = new JLabel("<html>" + "BallAnimation" + "</html>");
        mylabel.setHorizontalAlignment(SwingConstants.CENTER);
        mylabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        container.add(mylabel, BorderLayout.NORTH);

        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new GridLayout(4, 1));
        //btnContainer.setLayout(new BoxLayout(btnContainer, BoxLayout.Y_AXIS));

        Button startStopBtn = new Button();
        startStopBtn.setIcon("D:\\DSTU\\ява\\lab7\\img\\assets\\start.png");

        btnContainer.add(startStopBtn);
        btnContainer.setBorder(new RoundedBorder(10));

        container.add(btnContainer, BorderLayout.EAST);
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
