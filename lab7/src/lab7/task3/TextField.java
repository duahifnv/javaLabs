package lab7.task3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TextField extends JTextField {
    public TextField() {
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        setPreferredSize(new Dimension(200, 80));
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}
