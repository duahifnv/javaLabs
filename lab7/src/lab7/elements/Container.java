package lab7.elements;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Container extends JPanel {
    public Container() {
        setLayout(new BorderLayout(20, 15));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.WHITE);
    }
}
