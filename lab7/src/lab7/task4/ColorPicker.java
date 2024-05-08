package lab7.task4;

import lab7.elements.LabelPanel;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorPicker extends LabelPanel {
    private JColorChooser colorChooser;
    public ColorPicker() {
        label.setText("Выбор цвета");
        colorChooser = new JColorChooser();
        AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
        for (AbstractColorChooserPanel accp : panels) {
            if(!accp.getDisplayName().equals("RGB")) {
                colorChooser.removeChooserPanel(accp);
            }
        }

        colorChooser.setPreviewPanel(new JPanel());
        add(colorChooser);
    }
    public JColorChooser getColorChooser() {
        return colorChooser;
    }
}