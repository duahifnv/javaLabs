package lab7.task4;

import lab7.elements.*;
import lab7.elements.Container;
import lab7.elements.Label;
import lab7.task4.graph.*;
import lab7.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class Task4 extends JFrame {
    public Task4() {
        ThemeManager.initTheme(Theme.DARK);
        JPanel container = new Container();
        container.add(new Label("Graph"), BorderLayout.NORTH);

        SingleGraph graph = new SingleGraph(Func.SIN);
        graph.setPreferredSize(new Dimension(400, 400));
        container.add(graph);

        JPanel navContainer = new NavContainer(new Dimension(400, 300));
        FuncPicker funcPicker = new FuncPicker(Func.SIN, graph);
        navContainer.add(funcPicker);
        navContainer.add(Box.createHorizontalStrut(10));
        navContainer.add(new IntervalField());
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setLabel("Цвет");
        JColorChooser colorChooser = colorPicker.getColorChooser();
        colorChooser.getSelectionModel().addChangeListener(e -> {
            Color color = colorChooser.getColor();
            graph.setCurveColor(color);
        });
        navContainer.add(colorPicker);

        container.add(navContainer, BorderLayout.SOUTH);
        add(container);
        setSize(800, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task4::new);
    }
}
