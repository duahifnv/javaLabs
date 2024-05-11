package lab7.task6;

import lab7.elements.ItemPicker;

import javax.swing.*;
import java.util.ArrayList;

public class GroundPicker extends ItemPicker<String> {
    private JComboBox<String> comboBox;
    public GroundPicker() {
        super(new ArrayList<>(){{
                add("Кружки");
                add("Задний фон");
                }});
    }
}
