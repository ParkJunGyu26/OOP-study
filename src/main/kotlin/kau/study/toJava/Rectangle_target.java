package kau.study.toJava;

public class Rectangle_target extends Shape_target implements Measurable_target {
    private double width;
    private double height;

    public Rectangle_target(double x, double y,double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }
}
