package lab7.task2;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String label) {
        setText(label);
        setPreferredSize(new Dimension(200, 100));
        setBorder(new RoundedBorder(10));
        setBackground(Color.WHITE);
    }
}

