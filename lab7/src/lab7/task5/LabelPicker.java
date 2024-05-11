package lab7.task5;

import lab7.elements.ItemPicker;

import javax.swing.*;
import java.util.ArrayList;

public class LabelPicker extends ItemPicker<String> {
    private JComboBox<String> comboBox;
    public LabelPicker(LabelBox labelBox) {
        super(initLabelNames(labelBox));
        setLabel("Метка");
        comboBox = super.getComboBox();
        add(comboBox);
    }
    public JComboBox<String> getComboBox() {
        return this.comboBox;
    }
    private static ArrayList<String> initLabelNames(LabelBox labelBox) {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Задний фон");
        labels.add("Все");
        labels.addAll(labelBox.getLabelNames());
        return labels;
    }
}