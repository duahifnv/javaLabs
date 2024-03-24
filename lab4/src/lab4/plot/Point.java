package lab4.plot;

/**
 * Точка на графике
 */
class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        // draw();
    }

    public void draw() {
        System.out.printf("Отрисовка точки: (%.02f, %.02f)%n", this.x, this.y);
    }
}
