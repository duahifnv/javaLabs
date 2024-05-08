package lab7.elements;

import javax.swing.*;

public abstract class LabelPanel extends JPanel {
    protected JLabel label = new JLabel();
    public LabelPanel() {
        add(label);
    }
    public void setLabel(String label) {
        this.label.setText(label);
    }
}