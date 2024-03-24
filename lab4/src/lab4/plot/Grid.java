package lab4.plot;

/**
 * Вспомогательная сетка
 */
class Grid {
    private double xSpacing;
    private double ySpacing;
    public Grid(double xSpacing, double ySpacing) {
        setSpacing(xSpacing, ySpacing);
        draw();
    }
    public void setSpacing(double xSpacing, double ySpacing) {
        this.xSpacing = xSpacing;
        this.ySpacing = ySpacing;
    }
    public void draw() {
        System.out.printf("Отрисовка сетки с промежутками (X: %.02f Y: %.02f)%n", this.xSpacing, this.ySpacing);
    }
}
