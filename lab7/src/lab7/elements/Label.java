package lab7.elements;

import javax.swing.*;

public class Label extends JLabel {
    public Label(String text) {
        super.setText("<html>" + text + "</html>");
        setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void setText(String text) {
        super.setText("<html>" + text + "</html>");
    }
    public void offsetFontSize(int size) {
        setFont(getFont().deriveFont((float)(getFont().getSize() + size)));
    }
}
