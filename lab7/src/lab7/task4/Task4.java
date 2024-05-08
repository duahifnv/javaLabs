package lab7.task4;

import lab7.elements.Container;
import lab7.elements.Label;
import lab7.task4.graph.*;

import javax.swing.*;
import java.awt.*;

public class Task4 extends JFrame {
    public Task4() {
        JPanel container = new Container();
        container.add(new Label("Graph"), BorderLayout.NORTH);

        SingleGraph graph = new SingleGraph(Func.SIN);
        graph.setPreferredSize(new Dimension(400, 400));
        graph.setBackground(Color.WHITE);
        container.add(graph);
        JPanel navContainer = new JPanel();
        navContainer.setLayout(new FlowLayout());
        navContainer.setPreferredSize(new Dimension(200, 400));

        FuncPicker funcPicker = new FuncPicker(Func.SIN, graph);

        navContainer.add(funcPicker);
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
