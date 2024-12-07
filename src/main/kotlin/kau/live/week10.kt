package kau.live

import kotlin.math.sqrt

// 상속 받으려면 'open' 예약어 필요(상속 가능여부)
open class Shape(var x: Double, var y: Double) {

    // 중심과 원점과의 거리
    // 이 메서드가 오버라이드가 가능하게 하기 위해선 open 예약어 사용
    open fun distanceFromOriginMethod(): Double {
        return sqrt(x * x + y * y)
    }

    open val distanceFromOrigin = sqrt(x*x + y*y)
}

class Circle(x: Double, y: Double, var radius: Double)
    : Shape(x, y) {
    override fun distanceFromOriginMethod(): Double {
        val d = sqrt(x*x + y*y)
        if (d < radius) return 0.0
        return d - radius
    }

    override val distanceFromOrigin: Double
        get()  {
            val d = sqrt(x*x + y*y)
            if (d < radius) return 0.0
            return d - radius
        }
}

class Rectangle(x: Double, y: Double, var width: Double, var height: Double) : Shape(x, y) {

}

fun main() {
    val c1 = Circle(1.0, 1.0, 1.0)
    val r = Rectangle(3.0, 3.0, 1.0, 2.0)
    val c2 = Circle(-1.0, -2.0, 1.5)
    val s = Shape(5.0, 5.0)

    // 원 2개, 직사각형 1개, shape 1개
    val shapeArray: Array<Shape> = arrayOf(c1, r, c2, s)

    for (s in shapeArray) {
        // 만약 null이면 수행해라(let 영역함수)
        (s as? Circle)?.let {
            println("Radius of Circle: ${s.radius}")
        }

        // 스마트 캐스트 -> circle이라는 것이 확정이 됨
        if (s is Circle) {
            println("Radius of circle: ${s.radius}")
        }
    }

//    val s: Shape = c // 변수의 타입보다 객체의 타입이 더 중요하다!!

//    println(c.getDistanceFromOrigin())
//    println(s.getDistanceFromOrigin())
}