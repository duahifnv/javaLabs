package lab4.plot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Оси координат
 */
public class Axes extends Figure{
    private final double[] x = new double[size[0]];
    private final double[] y = new double[size[1]];
    private String xlabel;
    private String ylabel;
    private final ArrayList<Plot> plots = new ArrayList<>();
    private Grid grid;
    private Legend legend;
    private ArrayList<Point> points;
    public Axes(int[] size, double xMin, double xMax, double yMin, double yMax) {
        super(size);
        double xStep = (double) (xMax - xMin) / size[0];
        double yStep = (double) (yMax - yMin) / size[1];
        int i = 0;
        for(double dx = xMin; dx < xMax && i < size[0]; dx += xStep) {
            this.x[i] = dx;
            i++;
        }
        int j = 0;
        for(double dy = yMin; dy < yMax && j < size[1]; dy += yStep) {
            this.y[j] = dy;
            j++;
        }
        draw();
    }
    public void setXLabel(String label) {
        this.xlabel = label;
    }
    public void setYLabel(String label) {
        this.ylabel = label;
    }
    public void draw() {
        System.out.println("Отрисовка оси X: " + Arrays.toString(x));
        System.out.println("Отрисовка оси Y: " + Arrays.toString(y));
    }
    public void addPlot(double[] x, double[] y, String label) {
        for (Plot plot:
                plots) {
            if (plot.getLabel().equals(label)) {
                System.out.printf("Кривая с именем %s уже есть на графике", label);
                return;
            }
        }
        plots.add(new Plot(x, y, label));
    }
    public void removePlot(String label) {
        for (Plot plot: plots) {
            if (plot.getLabel().equals(label)) {
                plots.remove(plot);
                break;
            }
        }
    }
    public void setGrid(double xSpacing, double ySpacing) {
        this.grid = new Grid(xSpacing, ySpacing);
    }
    public void removeGrid() {
        this.grid = null;
    }
    public void setLegend(Legend.Position position, int width, int height) {
        if (plots.size() == 0) {
            System.out.println("На графике нет кривых. Невозможно создать легенду");
            return;
        }
        this.legend = new Legend(plots, position, width, height);
    }
    public void removeLegend() {
        this.legend = null;
    }
}
