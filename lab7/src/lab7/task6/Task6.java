package lab7.task6;

import lab7.elements.*;
import lab7.elements.Container;
import lab7.elements.Label;
import lab7.task5.LabelPicker;
import lab7.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class Task6 extends JFrame {
    public Task6() {
        ThemeManager.initTheme(Theme.DARK);
        Container container = new Container();
        container.setAlignmentX(CENTER_ALIGNMENT);
        container.add(new Label("Игральная кость"), BorderLayout.NORTH);

        JPanel diceWrapper = new JPanel();
        diceWrapper.setLayout(new BoxLayout(diceWrapper, BoxLayout.X_AXIS));
        diceWrapper.setPreferredSize(new Dimension(800, 400));
        Dice dice = new Dice(300);
        diceWrapper.add(dice);
        dice.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(diceWrapper, BorderLayout.CENTER);

        JPanel navContainer = new NavContainer(new Dimension(400, 300));

        GroundPicker groundPicker = new GroundPicker();
        navContainer.add(groundPicker);

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setLabel("Цвет");
        JColorChooser colorChooser = colorPicker.getColorChooser();
        colorChooser.getSelectionModel().addChangeListener(e -> {
            Color color = colorChooser.getColor();
            int index = groundPicker.getComboBox().getSelectedIndex();
            switch (index) {
                case 0 -> {
                    dice.setForeground(color);
                }
                case 1 -> {
                    dice.setBackground(color);
                }
            }
        });
        navContainer.add(colorPicker);

        container.add(navContainer, BorderLayout.SOUTH);
        add(container);
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task6::new);
    }
}
