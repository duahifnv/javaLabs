package lab7.task6;

import lab7.elements.*;
import lab7.elements.Container;
import lab7.elements.Label;
import lab7.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dices extends JFrame {
    public Dices() {
        ThemeManager.initTheme(Theme.COFFEE);
        Container container = new Container();
        container.setAlignmentX(CENTER_ALIGNMENT);
        container.add(new Label("Игральная кость"), BorderLayout.NORTH);

        JPanel diceWrapper = new JPanel();
        diceWrapper.setLayout(new FlowLayout());
        diceWrapper.setMinimumSize(new Dimension(800, 400));
        Dice dice = new Dice(100);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    dice.switchActive();
                }
            }
        });
        diceWrapper.add(dice);
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
        setMinimumSize(new Dimension(1000, 1000));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dice");
        setFocusable(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dices::new);
    }
}
