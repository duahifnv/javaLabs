package lab7.task3;

import lab7.elements.Button;
import lab7.elements.Container;
import lab7.elements.RoundedBorder;
import lab7.task2.Filter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Task3 extends JFrame {
    public Task3() {
        JPanel container = new Container();
        BallAnimation animation = new BallAnimation();
        container.add(animation);
        //animation.setPreferredSize(new Dimension(300, 300));

        JPanel btnContainer = new JPanel();
        btnContainer.setLayout(new GridLayout(4, 1));
        //btnContainer.setLayout(new BoxLayout(btnContainer, BoxLayout.Y_AXIS));

        lab7.elements.Button rotateBtn = new lab7.elements.Button("Повернуть на 180");
        //.addActionListener(e -> filterImage.setFilter(Filter.ROTATE));

        lab7.elements.Button grayScaleBtn = new lab7.elements.Button("Черно-белый фильтр");
        //grayScaleBtn.addActionListener(e -> filterImage.setFilter(Filter.GRAYSCALE));

        lab7.elements.Button blurBtn = new lab7.elements.Button("Заблюрить");
        //blurBtn.addActionListener(e -> filterImage.setFilter(Filter.BLUR));

        lab7.elements.Button resetBtn = new Button("Сбросить");
        //resetBtn.addActionListener(e -> filterImage.resetFilter());


        btnContainer.add(rotateBtn);
        btnContainer.add(grayScaleBtn);
        btnContainer.add(blurBtn);
        btnContainer.add(resetBtn);
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
