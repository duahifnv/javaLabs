package lab7.elements;

import javax.swing.*;
import java.awt.*;

public abstract class LabelPanel extends JPanel {
    protected JLabel label = new JLabel();
    public LabelPanel() {
        label.setFont(label.getFont().deriveFont((float)(label.getFont().getSize() - 5)));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(label);
    }
    public void setLabel(String text) {
        label.setText(text);
    }
}