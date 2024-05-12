package lab7.task8;

import lab7.elements.LabelPanel;
import lab7.task6.Dice;

import javax.swing.*;
import java.awt.*;

public class CellCore extends LabelPanel {
    private int size;
    private ScoreField[] fields;
    public CellCore() {
        size = DiceGame.frameSize / 3;
        setPreferredSize(new Dimension(size, size));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLabel("Dice Game");
        offsetFontSize(10);
        JPanel diceWrapper = new JPanel();
        diceWrapper.setLayout(new FlowLayout());
        diceWrapper.setMinimumSize(new Dimension(size / 5, size / 5));
        Dice dice = DiceGame.dice;
        dice.setBorderRadius(20);
        diceWrapper.add(dice);
        add(diceWrapper);
        fields = new ScoreField[DiceGame.players.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new ScoreField("Player " + (i + 1));
            add(fields[i]);
        }
    }
    public void updateFields() {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setScore(DiceGame.players[i].getScore());
        }
    }
}
