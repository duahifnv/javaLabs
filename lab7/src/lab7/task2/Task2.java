package lab7.task2;

import lab7.SceneUtils;
import javax.swing.*;
import java.awt.*;

public class Task2 extends JFrame {
    public Task2() {
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel();
        label.setText("Image101");
        label.setSize(container.getPreferredSize());
        container.add(label);

        //SceneUtils.configFrame(jPanel);
        add(container);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task2::new);
    }
}
