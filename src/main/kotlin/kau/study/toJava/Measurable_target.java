package kau.study.toJava;

public interface Measurable_target {
    double getWidth();
    double getHeight();
    default double getArea() {
        return getWidth() * getHeight();
    }
}
