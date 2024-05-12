package lab7.task5;

import lab7.elements.*;
import lab7.elements.Container;
import lab7.elements.Label;
import lab7.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class Labels extends JFrame {
    public Labels() {
        ThemeManager.initTheme(Theme.DARK);
        JPanel container = new Container();
        container.add(new Label("Метки"), BorderLayout.NORTH);
        JLabel upperLabel = new JLabel("UpperLabel");
        JLabel downLabel = new JLabel("DownLabel");
        JLabel centerLabel = new JLabel("CenterLabel");

        LabelBox labelBox = new LabelBox();
        labelBox.setMinimumSize(new Dimension(800, 300));
        upperLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        upperLabel.setHorizontalAlignment(SwingConstants.LEFT);
        labelBox.add(upperLabel, BorderLayout.NORTH);

        downLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 10));
        downLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        labelBox.add(downLabel, BorderLayout.SOUTH);

        centerLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        labelBox.add(centerLabel, BorderLayout.CENTER);

        container.add(labelBox, BorderLayout.CENTER);

        JPanel navContainer = new NavContainer(new Dimension(400, 300));

        LabelPicker labelPicker = new LabelPicker(labelBox);
        navContainer.add(labelPicker);

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setLabel("Цвет");
        JColorChooser colorChooser = colorPicker.getColorChooser();
        colorChooser.getSelectionModel().addChangeListener(e -> {
            Color color = colorChooser.getColor();
            int index = labelPicker.getComboBox().getSelectedIndex();
            switch (index) {
                case 0 -> {
                    labelBox.setBackground(color);
                }
                case 1 -> {
                    for (int i = 0; i < labelBox.getLength(); i++) {
                        labelBox.setColor(color, i);
                    }
                }
                default -> {
                    labelBox.setColor(color, index - 2);
                }
            }
        });
        navContainer.add(colorPicker);
        container.add(navContainer, BorderLayout.SOUTH);

        add(container);
        setSize(600, 400);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Labels::new);
    }
}