package kau.study

interface Measurable_Test {
    val width: Double
    val height: Double
    val area: Double
        get() = width * height
}

open class Shape_Test(var x: Double, var y: Double) {}

class Rectangle_Test(x: Double, y: Double, override var width: Double, override var height: Double) : Shape_Test(x, y), Measurable_Test {}

class Circle_Test(x: Double, y: Double, var radius: Double) : Shape_Test(x, y), Measurable_Test {
    override val area: Double
        get() = Math.PI * radius * radius

    override val width: Double
        get() = radius * 2

    override val height: Double
        get() = radius * 2
}

fun main() {
    val r = Rectangle_Test(10.0, 10.0, 3.0, 4.0)
    val c = Circle_Test(5.0, 5.0, 2.0)
    val arr: Array<Measurable_Test> = arrayOf(r, c)

    for (s in arr) {
        println("Height is ${s.height}")
        println("Area is ${s.area}")
    }
}