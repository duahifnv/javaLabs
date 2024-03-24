package lab4.plot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Легенда графика
 */
public class Legend {
    public enum Position {
        UPPERLEFT("Слева сверху"),
        UPPERRIGHT("Справа сверху"),
        BOTTOMLEFT("Слева снизу"),
        BOTTOMRIGHT("Справа снизу");
        private String label;
        Position(String label) {
            this.label = label;
        }
    }
    private Position pos;
    private final int width;
    private final int height;
    private final Map<String, String> curveInfo;      // Label, color
    public Legend(ArrayList<Plot> plots, Position pos, int width, int height) {
        this.pos = pos;
        this.width = width;
        this.height = height;
        this.curveInfo = new HashMap<>();
        for(Plot plot : plots) {
            curveInfo.put(plot.getLabel(), plot.getColor());
        }
        draw();
    }
    public void addPlot(Plot plot) {
        curveInfo.put(plot.getLabel(), plot.getColor());
    }
    public void position(Position position) {
        this.pos = position;
    }
    public void draw() {
        System.out.printf("Отрисовка легенды размером %d x %d с кривыми: %s%n",
                width, height, String.join("|", curveInfo.keySet()));
    }
}
