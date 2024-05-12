package lab7.task8;

import lab7.elements.ThemeManager;
import lab7.task6.Dice;
import lab7.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DiceGame extends JFrame {
    // Field: size x size
    protected static final int size = 3;
    protected static final int frameSize = 600;
    protected static Cell[] cells;
    protected static Player[] players = new Player[Players.values().length];
    protected static int[] playersScores;
    protected static int playerToMove = 0;
    protected static Dice dice = new Dice(frameSize / 3 / 5);
    protected static CellCore cellCore;
    public DiceGame() {
        ThemeManager.initTheme(Theme.DARK);
        setLayout(new GridLayout(3,3));
        cells = setField();

        for (int i = 0; i < 3; i++) {
            add(cells[i]);
        }
        add(cells[7]);
        cellCore = new CellCore();
        add(cellCore);
        add(cells[3]);
        for (int i = 6; i > 3; i--) {
            add(cells[i]);
        }
        for (int i = 0; i < players.length; i++) {
            Player player = new Player(Players.values()[i].getIconPath());
            players[i] = player;
            cells[0].addPlayer(player);
        }
        playersScores = new int[Players.values().length];
        GameLogic.run();
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
        gameField[random.nextInt(length - 1)] = new Cell(Cell.State.REPEAT);
        return gameField;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DiceGame::new);
    }
}
enum Players {
    PLAYER1("D:\\DSTU\\ява\\lab7\\img\\chips\\blue_chip.png"),
    PLAYER2("D:\\DSTU\\ява\\lab7\\img\\chips\\red_chip.png");
    private String path;
    Players(String path) {
        this.path = path;
    }
    public String getIconPath() {
        return path;
    }
}