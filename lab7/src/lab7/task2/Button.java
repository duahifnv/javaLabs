package lab7.task2;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String label) {
        setLabel(label);
        setMinimumSize(new Dimension(2500, 50));
    }
}

