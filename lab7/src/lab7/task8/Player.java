package lab7.task8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel {
    private int position = 0;
    private BufferedImage icon;
    private final int fieldSize = 8;
    private int score = 0;
    private boolean isFinished = false;
    public Player(String iconPath) {
        try {
            icon = ImageIO.read(new File(iconPath)); // Путь к иконке
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new Error("Не удалось считать изображение");
        }
    }
    public boolean isFinished() {
        return isFinished;
    }
    public void setFinished(boolean finished) {
        isFinished = finished;
    }
    public int getPosition() {
        return position;
    }
    public void move(int moveCount) {
        if (position + moveCount > fieldSize - 1) {
            position += moveCount - (fieldSize - 1);
        }
        else position += moveCount;
    }
    public BufferedImage getIcon() {
        return icon;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Нарисовать фишку
    }
}
