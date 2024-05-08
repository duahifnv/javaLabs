package lab7.elements;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String text) {
        setText("<html>" + text + "</html>");
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
