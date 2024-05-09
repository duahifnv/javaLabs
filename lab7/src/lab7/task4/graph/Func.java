package lab7.task4.graph;

public enum Func {
    SIN("sin(x)"),
    SINCOS("sin(x*x)+cos(x*x)"),
    SINCOS2("2*sin(x)+cos(2*x)");
    public final String label;
    Func(String label) {
        this.label = label;
    }
    public double[] getYdata(double[] xData) {
        int scale = xData.length;
        double[] yData = new double[scale];
        switch (this) {
            case SIN -> {
                for (int i = 0; i < scale; i++) {
                    yData[i] = Math.sin(xData[i]);
                }
            }
            case SINCOS -> {
                for (int i = 0; i < scale; i++) {
                    yData[i] = Math.sin(xData[i]*xData[i]) + Math.cos(xData[i]*xData[i]);
                }
            }
            case SINCOS2 -> {
                for (int i = 0; i < scale; i++) {
                    yData[i] = 2 * Math.sin(xData[i]) + Math.cos(2 * xData[i]);
                }
            }
        }
        return yData;
    }
}
