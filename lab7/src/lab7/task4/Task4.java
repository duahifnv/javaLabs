package lab7.task4;

import lab7.elements.Container;
import lab7.elements.Label;
import lab7.elements.ThemeManager;
import lab7.task4.graph.*;
import lab7.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class Task4 extends JFrame {
    public Task4() {
        ThemeManager.initTheme(Theme.LIGHT);
        JPanel container = new Container();
        container.add(new Label("Graph"), BorderLayout.NORTH);

        SingleGraph graph = new SingleGraph(Func.SIN);
        graph.setPreferredSize(new Dimension(400, 400));
        container.add(graph);

        JPanel navContainer = new JPanel();
        navContainer.setLayout(new BoxLayout(navContainer, BoxLayout.Y_AXIS));
        navContainer.setPreferredSize(new Dimension(200, 400));

        FuncPicker funcPicker = new FuncPicker(Func.SIN, graph);
        navContainer.add(funcPicker);

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setLabel("Цвет кривой");
        navContainer.add(colorPicker);

        container.add(navContainer, BorderLayout.EAST);
        add(container);
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task4::new);
    }
}
