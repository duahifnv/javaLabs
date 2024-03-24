package lab4.plot;

/**
 *  Фигура, на которой будет все отрисовываться
 */
public class Figure {
    protected final int[] size = new int[2];         // [x, y]
    private String title;
    private Axes ax;
    public Figure(int[] size) {
        this.size[0] = size[0];
        this.size[1] = size[1];
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Axes setAxes(double xMin, double xMax, double yMin, double yMax, String labelX, String labelY) {
        this.ax = new Axes(size, xMin, xMax, yMin, yMax);
        ax.setXLabel(labelX);
        ax.setYLabel(labelY);
        return ax;
    }
    public void drawFigure() {
        System.out.printf("Отрисовка фигуры размером %dx%d%n", size[0], size[1]);
    }
}
