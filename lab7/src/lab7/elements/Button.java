package lab7.elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Button extends JButton {
    public Button() {
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setBorder(new RoundedBorder(10));
        setBorderPainted(false);
        setFocusPainted(false);
        setPreferredSize(new Dimension(200, 80));
    }
    public void setIcon(String path, double ratio) {
        try {
            Image img = ImageIO.read(new File(path));
            img = img.getScaledInstance(((int) (img.getWidth(this) * ratio)),
                                        ((int) (img.getWidth(this) * ratio)),
                                        Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(img));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

