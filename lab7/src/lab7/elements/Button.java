package lab7.elements;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String label) {
        setText(label);
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        setPreferredSize(new Dimension(200, 50));
        setBorder(new RoundedBorder(10));
        setBackground(Color.WHITE);
    }
}

