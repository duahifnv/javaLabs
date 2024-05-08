package lab7.task4;

import lab7.elements.LabelPanel;
import lab7.task4.graph.Func;
import lab7.task4.graph.SingleGraph;

import javax.swing.*;
import java.awt.*;

public class FuncPicker extends LabelPanel {
    private JComboBox<Func> comboBox;
    private Func func;
    private SingleGraph graph;
    public FuncPicker(Func func, SingleGraph graph) {
        label = new JLabel("Функция");
        label.setFont(new Font("MONTSERRAT", Font.PLAIN, 20));
        add(this.label);

        comboBox = new JComboBox<>();
        this.func = func;
        this.graph = graph;
        for (Func f : Func.values()) {
            comboBox.addItem(f);
        }
        comboBox.addActionListener(event -> {
            int index = comboBox.getSelectedIndex();
            Func f = comboBox.getItemAt(index);
            if (f == this.func) return;
            this.func = f;
            graph.setCurve(f);
            graph.repaint();
        });
        add(comboBox);
    }
}