package lab7.elements;

import lab7.theme.Theme;

import javax.swing.*;

public class ThemeManager {
    public static void initTheme(Theme theme) {
        UIManager.put("Panel.background", theme.getBackground());
        UIManager.put("Panel.foreground", theme.getForeground());
        UIManager.put("Label.font", theme.getFont().deriveFont((float)(theme.getFont().getSize() + 10)));
        UIManager.put("Label.foreground", theme.getForeground());
        UIManager.put("Panel.font", theme.getFont());
        UIManager.put("Button.background", theme.getBackground());
        UIManager.put("Button.foreground", theme.getForeground());
        UIManager.put("TextField.background", theme.getForeground());
        UIManager.put("TextField.foreground", theme.getBackground());
    }
}