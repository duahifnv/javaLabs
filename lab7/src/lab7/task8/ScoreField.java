package lab7.task8;

import lab7.elements.Label;
import lab7.elements.LabelPanel;

import javax.swing.*;
import java.awt.*;

public class ScoreField extends LabelPanel {
    private int score;
    private Label scoreText;
    public ScoreField(String nickname) {
        setLabel(nickname);
        scoreText = new Label(String.valueOf(score));
        scoreText.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreText.offsetFontSize(-8);
        add(scoreText);
    }
    public void setScore(int score) {
        this.score = score;
        scoreText.setText(String.valueOf(score));
    }
    public int getScore() {
        return score;
    }
}
