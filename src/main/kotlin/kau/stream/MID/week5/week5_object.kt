package kau.stream.MID.week5

// 오브젝트 : 예외적으로 사용되는 타입이다.
// 타입을 대표하는 이름이면서, 객체의 이름이기도 하다!!
// 선언 즉시, 객체가 생성된다
//object Application {
//    val name = "My Application"
//    override fun toString() = name // 모든 객체는 "toString" 함수를 가지고 있으므로 오버라이딩 해준다. 오버라이드 : 상위 클래스에서 상속받을 때 정의
//    fun exit() {}
//}

class Application private constructor(val name: String) {
    // 팩토리라는 오브젝트를 통해서 Application 객체를 간접적으로 만듦 -> 팩토리 패턴
    // 팩토리는 하나뿐인 객체(오브젝트)이다 -> Application 내부 객체(Factory)
//    object Factory {
//        fun create(args: Array<String>): Application? {
//            val name = args.firstOrNull() ?: return null
//            return Application(name)
//        }
//    }

    // object에 대한 객체를 계속해서 선언하는 것이 귀찮다면,
    // 동반 객체(companion object)를 활용하자
    // 참조자 역할
    // 자바에서는 static 함수(모든 객체들이 공유하는 함수)들이 companion 오브젝트에 해당
    companion object {
        fun create(args: Array<String>): Application? {
            val name = args.firstOrNull() ?: return null
            return Application(name)
        }
    }

    // 모든 객체에서 toString을 커스텀하고 싶다면, 오버라이딩을 써야한다.
    override fun toString() = name
}

fun main() {
    // 객체의 이름이 Application이면서, 동시에 객체의 참조자 이름이 Application
//    println(Application)

    // 오브젝트 활용한 디자인 패턴(팩토리 패턴) -> 내부 객체
//    val a = Application("My Application") -> 생성자가 private이라서 외부에서는 절대 만들 수 없다..(컴파일 에러)
//    val a = Application.Factory.create(arrayOf("My Application"))
//    println(a)

    // 해당 오브젝트를 일일이 쓰는 게 귀찮다 -> 동반 객체(companion object)
//    val aa = Application.create(arrayOf("Park Application"))
//    println(aa)

    // object의 다른 방법 익명으로 객체를 선언한다
    // 만약 같은 위치(함수 등) 외에서 사용하려면 private을 붙여준다.
    fun midPoint(xRange: IntRange, yRange: IntRange) = object {
        val x = (xRange.first + xRange.last) / 2
        val y = (yRange.first + yRange.last) / 2
    }
    val midA = midPoint(1..3, 3..7)
    val midB = midPoint(9..29, 30..40)
    println("${midA.x}, ${midA.y}")
    println("${midB.x}, ${midB.y}")
}