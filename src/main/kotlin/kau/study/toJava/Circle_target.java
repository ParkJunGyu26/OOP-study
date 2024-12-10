package kau.study.toJava;

public class Circle_target extends Shape_target implements Measurable_target {
    private double radius;

    public Circle_target(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }
}
