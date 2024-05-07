package lab7.task2;

import lab7.elements.Button;
import lab7.elements.Container;
import lab7.elements.Label;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Task2 extends JFrame {
    String imgPath = "D:\\DSTU\\ява\\lab7\\img\\5.jpg";
    public Task2() {
        JPanel container = new Container();
        container.add(new Label("Image101"), BorderLayout.NORTH);

        JPanel imageContainer = new JPanel();
        imageContainer.setPreferredSize(new Dimension(1000, 600));
        imageContainer.setBackground(Color.WHITE);
        FilterImage filterImage = new FilterImage(readImage(imgPath));
        filterImage.setPreferredSize(imageContainer.getPreferredSize());
        imageContainer.add(filterImage);
        container.add(imageContainer, BorderLayout.WEST);

        JPanel navContainer = new JPanel();
        navContainer.setLayout(new GridLayout(4, 1));

        Button rotateBtn = new Button();
        rotateBtn.setText("Повернуть на 180");
        rotateBtn.addActionListener(e -> filterImage.setFilter(Filter.ROTATE));

        Button grayScaleBtn = new Button();
        grayScaleBtn.setText("Черно-белый фильтр");
        grayScaleBtn.addActionListener(e -> filterImage.setFilter(Filter.GRAYSCALE));

        Button blurBtn = new Button();
        blurBtn.setText("Заблюрить");
        blurBtn.addActionListener(e -> filterImage.setFilter(Filter.BLUR));

        Button resetBtn = new Button();
        resetBtn.setText("Сбросить");
        resetBtn.addActionListener(e -> filterImage.resetFilter());

        navContainer.add(rotateBtn);
        navContainer.add(grayScaleBtn);
        navContainer.add(blurBtn);
        navContainer.add(resetBtn);
        container.add(navContainer, BorderLayout.EAST);
        add(container);

        setSize(1280, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private static BufferedImage readImage(String imgPath) {
        try {
           return ImageIO.read(new File(imgPath));
        }
        catch (IOException e) {
            throw new Error("Не удалось обработать изображение");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task2::new);
    }
}
