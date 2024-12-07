package kau.inClass;

public interface Measurable {

    default double getWidth() {
        return width;
    }

    default double getHeight() {
        return height;
    }

    default double getArea() {
        return getWidth() * getHeight();
    }
}
