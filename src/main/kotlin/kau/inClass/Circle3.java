package kau.inClass;

class Circle3 extends Shape implements Measurable {
    double radius;

    public double getWidth() {
        return 2.0 * radius;
    }

    public double getHeight() {
        return 2.0 * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    Circle3(double x, double y, double _r) {
        super(x, y);
        radius = _r;
    }
}