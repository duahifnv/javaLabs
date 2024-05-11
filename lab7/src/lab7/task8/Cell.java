package lab7.task8;

import java.awt.*;

import lab7.elements.LabelPanel;

public class Cell extends LabelPanel {
    private int points;
    private State state;
    public Cell(State state) {
        this.state = state;
        initCellState();
    }
    public Cell(int points) {
        this.points = points;
        initCellState();
    }
    private void initCellState() {
        setPreferredSize(new Dimension(DiceGame.frameSize / 3, DiceGame.frameSize / 3));
        setLayout(new FlowLayout());

        offsetFontSize(3);
        setColor(Color.BLACK);
        if (state == null) {
            if (points > 0) setBackground(Color.GREEN);
            else setBackground(Color.RED);
            setLabel(String.valueOf(points));
        }
        else {
            switch (state) {
                case FINISH -> setBackground(Color.BLUE);
                case REPEAT -> setBackground(Color.ORANGE);
                case LOSTALL -> {
                    setBackground(Color.BLACK);
                    setColor(Color.WHITE);
                }
            }
            setLabel(state.getText());
        }
    }
    public int getPoints() {
        return points;
    }
    public State getCellState() {
        return state;
    }
    enum State {
        LOSTALL ("Проебать все"),
        REPEAT ("Повторить ход"),
        FINISH ("Конец");
        private String text;
        State(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }
    }
}

