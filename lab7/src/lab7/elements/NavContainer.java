package lab7.elements;

import javax.swing.*;
import java.awt.*;

public class NavContainer extends JPanel {
    public NavContainer(Dimension size) {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setPreferredSize(size);
    }
}
