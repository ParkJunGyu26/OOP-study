package kau.stream.MID.week7

//class Circle(private var radius: Double)

class Circle(private var radius: Double) {
    val area: Double
        get() = radius * radius * Math.PI

    // 생성자(하나 생성때 마다 적용)
    init {
        numberOfCircles += 1
    }

    companion object {
        var numberOfCircles = 0
    }
}

class Circle222() {
    var radius: Double = 0.0
    val area: Double
        get() = radius * radius * Math.PI


}

// Circle 클래스의 radius 프로퍼티는 private 이라서, 클래스 외부에서는 접근할 수 없음
//fun Circle.setRadius(newRadius: Double) {
//    radius = newRadius
//}

// String 클래스에 새로운 함수 truncate 이란 것이 생김
// 글자수만큼 출력
// 외부 패키지는 import 해줘야 함
//fun String.truncate(maxLenth: Int): String {
//    return if ( this.length <= maxLenth ) this else substring(0, maxLenth)
//}

fun Circle222.init() {
    radius = 3.0
}

fun main() {
//    println("Hello".truncate(10))
//    println("Hello".truncate(3))
//    val c = Circle(3.0)
//    val d = Circle(5.0)
//    println("total circles are ${Circle.Companion.numberOfCircles}")

    // 이렇게 생성자를 선언안해주면, 일일이 다 적어야 됨.. -> 그래서 등장한 게 확장함수
    val cc = Circle222()
    cc.radius = 3.0

    val ccc = Circle222()
    cc.init()

    // 확장함수 보다 더 모듈적으로 제공하는 것이 영역 함수
    // 영역함수 run
    val cccc = Circle222().run {
        radius = 3.0
    }

    // 이렇게 계속 ?를 처리하는 게 귀찮음
    val cdcd: Circle222? = null

    // 영역함수 let
    // null 처리에서 많이 사용됨
    cdcd?.let {
        it.radius = 3.0
        println("Area is ${it.area}")
    }
}