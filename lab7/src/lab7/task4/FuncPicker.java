package lab7.task4;

import lab7.elements.ItemPicker;
import lab7.task4.graph.Func;
import lab7.task4.graph.SingleGraph;

import javax.swing.*;
import java.util.List;

public class FuncPicker extends ItemPicker<Func> {
    private Func func;
    private SingleGraph graph;
    public FuncPicker(Func func, SingleGraph graph) {
        super(List.of(Func.values()));
        this.func = func;
        this.graph = graph;
        setLabel("Функция");
        JComboBox<Func> comboBox = getComboBox();
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