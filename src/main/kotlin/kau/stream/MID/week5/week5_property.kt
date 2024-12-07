package kau.stream.MID.week5

import java.io.File
import java.util.*

// private 은 같은 파일에서만
// internal 은 같은 컴파일에서만
// public 은 어디서든 가능
private val prefix = "Hello, "

// 컴파일 단계에서는 lateinit을 잡아내지 못한다. 프로그래머를 믿기 때문....
class Content {
    // 늦은 초기화 보다는 by lazy를 사용하는 것이 나음(늦게 초기화하겠다!!)
    lateinit var text: String // not null이고, 생성자 안에서는 초기화할 방법이 없다. 따라서 나중에 대입한다고 약속한다는 lateinit

    // 해당 메서드가 초기화를 해줌.. 즉, 수동으로 해줘야 함
    fun loadFile(file: File) {
        text = file.readText()
    }

}

// 생성자를 뒤로 미룸. 즉, 객체가 생성되었을 때 프로퍼티들이 만들어지는 게 기본이지만
// lazy를 통해 "호출"될 때 프로퍼티가 만들어짐
// 초기화 시점을 최대한 뒤로 미룰 수 있다.
class NewContent(var file: File) {
    val text by lazy {
        println("Hello 오늘 날짜는 ${Date()}")
        file.readText() }
}

class Person(var firstName: String, var familyName: String) {
//    val fullName: String // = "$firstName $familyName"으로 해도 되지만, 이러면 메모리 등 자원이 할당됨

    // 커스텀 접근자(게터)
//        get() {
//            println("Hello")
//            return "$firstName $familyName"
//        }
//        get() = "$firstName $familyName" // 메모리 공간을 따로 할당해주지 않아도 됨

    // 뒷받침하는 필드 -> 위에서 단순히 getter는 메모리할당을 해주지 않아서 변수 선언이 안된거임
    // 그런데, 커스텀 접근자 게터로도 메모리에 뒷받침하는 필드를 두어 값 저장 가능 -> 근데 이건 왜 있는거지? 어차피 바로 생성자로 뽑으면 안되나??
//    val age = age
//        get() {
//            println("Getter was called")
//            return field
//        }

    // 커스텀 생성자(세터)
//    var age: Int? = null
//        set(value) {
//            if (value != null && value <= 0)
//                throw IllegalArgumentException("Invalid age: $value")
//            field = value
//        }

    // 뒷받침하는 필드가 없는 가변 프로퍼티
//    var fullName
//        get() = "$firstName $familyName"
//        set(value) {
//            val names = value.split(" ")
//            if (names.size != 2) throw IllegalArgumentException("이름을 두 글자 이상이어야 합니다.")
//            firstName = names[0]
//            familyName = names[1]
//        }
}

// 세터에 대한 접근 지시어(private)
class NewPerson(name: String) {
    // 세터에 대해 private을 한다면, 외부에서는 건드릴 수 없다.
    var lastChanged: Date? = null
        private set

    // 하지만, 이름을 바꾸게 된다면 자동으로 changed가 업데이트된다
    var name = name
        set(value) {
            lastChanged = Date()
            field = name
        }
}

fun main() {
    // 커스텀 접근자(게터)
//    val p = Person("Park", "Jun")
//    println(p.fullName)

    // 커스텀 생성자(세터)
//    val pp = Person("Park", "Jun")
//    pp.age = 20
//    println(pp.age)
//    pp.age = 0
//    println(pp.age)

    // 뒷받침 필드 없는 게터 및 세터
//    val ppp = Person("Park", "Jun")
//    ppp.familyName = "Hong"
//    ppp.firstName = "GilDong"
//    println("full name : ${ppp.fullName}")
//    println("family name : ${ppp.familyName}")
//    println("first name : ${ppp.firstName}")
//    println("----")
//
//    ppp.fullName = "Park JunGyu"
//    println("ppp.full name : ${ppp.fullName}")
//    println("----")
//    ppp.fullName = "HI"

    // 접근 지시어를 통한 세터
//    val pppp = NewPerson("Park")
//    println("lastchanged : ${pppp.lastChanged}")
//    pppp.lastChanged = Date() -> lastChanged는 해당 클래스에서만 접근 가능하므로 외부에서는 접근 금디라서 컴파일 에러 발생
//    println("----")
//    pppp.name = "ParkJunGyu"
//    println("lastchanged : ${pppp.lastChanged}")

    // 이제 입력받을 때는 !! 절대 쓰지말자!!(null아님 단언)
//    val name = readLine()?: return
//    println("$prefix$name")


    // 프로퍼티를 초기화시키는 것을 생성자 시점보다 더 뒤로 미루는 기법 2가지
    // 초기화 뒤로 미루기1(프로그래머가 직접 수동으로)
//    val c = Content()
//    println(c.text) -> text가 초기화되지 않았는데, 호출한다? 이건 에러지

    // 초기화 뒤로 미루기2(코드에서 자체적으로 -> 자동 시스템) -> 안전함... 실수가 발생하지는 않음
//    val cc = NewContent(File("Quiz.txt"))
//    println("Before access text")
//    println(cc.text)
}