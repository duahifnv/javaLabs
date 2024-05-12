package lab7.task8;

import java.awt.*;
import java.util.ArrayList;

import lab7.elements.LabelPanel;

public class Cell extends LabelPanel {
    private int points;
    private State state;
    private ArrayList<Player> playerContainer;
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

        playerContainer = new ArrayList<>();
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
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xOffset = 0;
        for (Player player : playerContainer) {
            g.drawImage(player.getIcon(), xOffset, getHeight() / 2, this);
            xOffset += 30;
        }
    }
    public void addPlayer(Player player) {
        playerContainer.add(player);
        repaint();
    }
    public void removePlayer(Player player) {
        playerContainer.remove(player);
        repaint();
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

