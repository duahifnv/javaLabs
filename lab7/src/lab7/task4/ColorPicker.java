package lab7.task4;

import lab7.elements.LabelPanel;

import javax.swing.*;

public class ColorPicker extends LabelPanel {
    private JColorChooser colorChooser;
    public ColorPicker() {
        label.setText("Выбор цвета");
        colorChooser = new JColorChooser();
        add(colorChooser);
    }
}