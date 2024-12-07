package kau.inClass

interface Measure2 {
    val width: Double
    val height: Double
    val area: Double
        get() = width * height
}

abstract class Shape2(var x: Double, var y: Double) {

}

// Shape를 x, y를 상속받고
// Measure2를 상속받음
class Rectangle2(
    x: Double,
    y: Double,
    override var width: Double,
    override var height: Double) : Shape2(x, y), Measure2 {}

class Circle2(x: Double, y: Double, var radius: Double): Shape(x, y), Measure2 {
    override val width: Double
        get() = 2.0 * radius

    override val height: Double
        get() = 2.0 * radius

    override val area: Double
        get() = Math.PI * radius
}