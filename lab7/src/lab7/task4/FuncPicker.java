package lab7.task4;

import lab7.elements.LabelPanel;
import lab7.task4.graph.Func;
import lab7.task4.graph.SingleGraph;

import javax.swing.*;

public class FuncPicker extends LabelPanel {
    private JComboBox<Func> comboBox;
    private Func func;
    private SingleGraph graph;
    public FuncPicker(Func func, SingleGraph graph) {
        this.func = func;
        this.graph = graph;
        label.setText("Функция");
        add(this.label);

        comboBox = new JComboBox<>();
        comboBox.setBackground(super.getBackground());

        for (Func f : Func.values()) {
            comboBox.addItem(f);
        }
        comboBox.addActionListener(event -> {
            int index = comboBox.getSelectedIndex();
            Func f = comboBox.getItemAt(index);
            if (f == this.func) return;
            this.func = f;
            graph.getCurve().setFunc(f);
            graph.repaint();
        });

        add(comboBox);
    }
}