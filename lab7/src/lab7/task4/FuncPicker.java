package lab7.task4;

import lab7.task4.graph.Func;
import lab7.task4.graph.SingleGraph;

import javax.swing.*;

public class FuncPicker extends JComboBox<Func> {
    private Func func;
    private SingleGraph graph;
    public FuncPicker(Func func, SingleGraph graph) {
        this.func = func;
        this.graph = graph;
        for (Func f : Func.values()) {
            addItem(f);
        }
        addActionListener(event -> {
            int index = getSelectedIndex();
            Func f = getItemAt(index);
            if (f == this.func) return;
            this.func = f;
            graph.setCurve(f);
            graph.repaint();
        });
    }
}
