package lab7.task8;

import lab7.elements.ThemeManager;
import lab7.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DiceGame extends JFrame {
    // Field: size x size
    protected static final int size = 3;
    protected static final int frameSize = 600;
    protected static Cell[] vectorField;
    public DiceGame() {
        ThemeManager.initTheme(Theme.DARK);
        setLayout(new GridLayout(3,3));
        vectorField = setField();

        for (int i = 0; i < 3; i++) {
            add(vectorField[i]);
        }
        add(vectorField[7]);
        add(new CellCore());
        add(vectorField[3]);
        for (int i = 6; i > 3; i--) {
            add(vectorField[i]);
        }
        setMinimumSize(new Dimension(frameSize, frameSize));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DiceGame");
        setResizable(false);
        setFocusable(true);
        setVisible(true);
    }
    private Cell[] setField() {
        int length = ((int) (Math.pow(size, 2) - 1));
        Cell[] gameField = new Cell[length];
        Random random = new Random();
        for (int i = 0; i < gameField.length - 1; i++) {
            int randomPoint = (random.nextInt(6) + 1) * 10;
            randomPoint *= random.nextInt(2) == 0 ? 1 : -1;
            gameField[i] = new Cell(randomPoint);
        }
        gameField[gameField.length - 1] = new Cell(Cell.State.FINISH);
        gameField[random.nextInt(length - 1)] = new Cell(Cell.State.LOSTALL);
        gameField[random.nextInt(length)] = new Cell(Cell.State.REPEAT);
        return gameField;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DiceGame::new);
    }
}
