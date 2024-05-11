package lab7.elements;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ItemPicker<T> extends LabelPanel {
    private JComboBox<T> comboBox;
    public ItemPicker(List<T> items) {
        add(this.label);
        comboBox = new JComboBox<>();
        comboBox.setBackground(super.getBackground());

        for (T item : items) {
            comboBox.addItem(item);
        }
        add(comboBox);
    }
    public JComboBox<T> getComboBox() {
        return this.comboBox;
    }
    public void setLabel(String text) {
        label.setText(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
