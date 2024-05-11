package lab7.task5;

import lab7.elements.Container;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LabelBox extends Container {
    private ArrayList<JLabel> labels;
    private int size = 0;
    public LabelBox() {
        super();
        labels = new ArrayList<>();
    }
    @Override
    public void add(Component label, Object position) {
        labels.add((JLabel) label);
        super.add(label, position);
        size++;
    }
    public void setColor(Color color, int index) {
        labels.get(index).setForeground(color);
    }
    public ArrayList<String> getLabelNames() {
        ArrayList<String> labelNames = new ArrayList<>();
        for (JLabel label : labels) {
            labelNames.add(label.getText());
        }
        return labelNames;
    }
    public int getLength() {
        return size;
    }
}
