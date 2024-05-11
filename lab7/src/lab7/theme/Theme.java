package lab7.theme;

import java.awt.*;

public enum Theme {
    LIGHT(Color.BLACK, Color.WHITE),
    COFFEE(new Color(0x564C41), new Color(0x1a130f)),
    FOREST(new Color(0x2f3811), new Color(0x555c33)),
    DARK(new Color(0x60666F), new Color(0x202225));
    private Color foreground;
    private Color background;
    private Font font = new Font("MONTSERRAT", Font.PLAIN, 16);
    Theme(Color foreground, Color background) {
        this.foreground = foreground;
        this.background = background;
    }
    public Color getForeground() {
        return foreground;
    }
    public Color getBackground() {
        return background;
    }
    public Font getFont() {
        return font;
    }
}
