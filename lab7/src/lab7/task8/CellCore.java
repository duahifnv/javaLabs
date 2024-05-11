package lab7.task8;

import lab7.elements.LabelPanel;
import lab7.task6.Dice;

import javax.swing.*;
import java.awt.*;

public class CellCore extends LabelPanel {
    private int size;
    public CellCore() {
        size = DiceGame.frameSize / 3;
        setPreferredSize(new Dimension(size, size));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLabel("Dice Game");
        offsetFontSize(10);
        JPanel diceWrapper = new JPanel();
        diceWrapper.setLayout(new FlowLayout());
        diceWrapper.setMinimumSize(new Dimension(size / 5, size / 5));
        Dice dice = new Dice(size / 5);
        dice.setBorderRadius(20);
        diceWrapper.add(dice);
        add(diceWrapper);
        ScoreField first = new ScoreField("Player 1");
        first.setScore(20);
        ScoreField second = new ScoreField("Player 2");
        add(first);
        add(second);
    }
}
