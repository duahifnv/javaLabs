package lab7.elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class Button extends JButton {
    public Button() {
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setBorder(new RoundedBorder(10));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(200, 50));
    }
    public void setIcon(String path) {
        try {
            Image img = ImageIO.read(new File(path));
            setIcon(new ImageIcon(img));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

