package lab7.task8;

import lab7.elements.LabelPanel;

import java.awt.*;

public class CellCore extends LabelPanel {
    public CellCore() {
        setPreferredSize(new Dimension(DiceGame.frameSize / 3, DiceGame.frameSize / 3));
        setLayout(new FlowLayout());
        setLabel("Dice Game");
        offsetFontSize(10);
    }
}
