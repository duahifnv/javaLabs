package lab6.task5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DisplayApp extends JPanel {
    private BufferedImage image;
    private boolean flipped = false;
    public DisplayApp() {
        try {
            image = ImageIO.read(new File("D:\\DSTU\\ява\\lab6\\img\\bl.jpg")); // Путь к изображению
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new Error("Не удалось считать изображение");
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                flipped = !flipped;
                repaint();
            }
        });
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (image != null) {
            int width = getWidth();
            int height = getHeight();
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            double aspectRatio = (double) imageWidth / imageHeight;
            int displayWidth = (int) (height * aspectRatio);
            int displayHeight = height;

            if (displayWidth > width) {
                displayWidth = width;
                displayHeight = (int) (width / aspectRatio);
            }

            int x = (width - displayWidth) / 2;
            int y = (height - displayHeight) / 2;

            if (flipped) {
                g.drawImage(image, x + displayWidth, y + displayHeight, x, y, imageWidth, 0, 0, imageHeight, null);
            }
            else {
                g.drawImage(image, x, y, x + displayWidth, y + displayHeight, 0, 0, imageWidth, imageHeight, null);
            }
        }
    }
}

