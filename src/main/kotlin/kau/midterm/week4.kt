package kau.midterm

import java.util.Date

/*

    클래스
    - 프로퍼티(변수)와 메쏘드(함수/연산)를 가지는 타입 정의

    객체(인스턴스)
    - 클래스를 통해 새롭게 만들어진 값

    (주)생성자
    - 함수처럼 매개변수를 선언하여, 생성자를 정의 -> 이러한 생성자는 1개만 가능하므로 '주생성자'라고 부른다.
    - 생성자 파라미터 정의 앞에 val, var를 붙이면 파라미터를 프로퍼티로 만들 수 있음
    - init
        - 하나의 식으로 표현하기 힘든 초기화 로직을 실행해야 할 때는 init 블록을 사용
        - 프로퍼티는 반드시 모두 초기화되어야한다. 그렇지 않으면 컴파일 에러 발생

    부생성자 -> 오버로딩 개념임
    - 하나 이상의 생성자를 정의하고 싶을 때는 fun 함수 대신, constructor 라는 예약어 사용하여 추가 생성자 정의
    - 부생성자와 주생성자를 같이 사용할 수 있다.

    가시성
    - public : 모든 곳에서 가능, 디폴트
    - private: 해당 클래스에서만 가능
    - internal : 같은 모듈, 같은 컴파일에서는 가능
    - protected : 객체지향 특징 중 하나인 '캡슐성'을 고려해서, 하위 클래스 또는 해당 클래스에서만 가능

    생성자의 가시성
    - 주생성자에도 가시성을 줄 수 있다.
    - class 클래스명 (가시성) constructor() { }
    - 당연히, 생성자가 가시성 특성에 따라 결정된다. 만약, private라면 해당 클래스에서만 생성자를 사용할 수 있다.

    내포된 클래스(nested class)
    - 외부 클래스 인스턴스 관계없음(독립성)
    - 함수처럼 클래스 내에 클래스를 선언할 수 있다.
    - 내포된 클래스는 외부 클래스가 만약 private라면, 접근할 수 없다
    - 외부 클래스와의 관계 예시
        - 한 건물 안의 사무실.
            건물 = 외부 클래스, 사무실 = nested class
            사무실과 건물은 같은 공간을 쓰는 것처럼 보이지만 결국 서로 주고받는 게 없음
        - 학교와 학생의 관계
            학교 = 외부 클래스, 학생 = 내포 클래스
            학생은 학교 시스템적으로 접근할 수 없다.
    -

    내부 클래스(inner class)
    - 외부 클래스의 인스턴스가 반드시 필요(연관성)
    - 내포된 클래스에서 조금 더 발전된?
        - 내포된 클래스처럼 클래스 내에 클래스를 선언하되, inner class 로 선언한다.
    - 내포된 클래스와는 다르게, 외부 클래스가 private라도, 접근할 수 있다.
    - 외부 클래스와의 관계 예시
        - 학교와 교사의 관계
            학교 = 외부 클래스, 교사 = 내부 클래스
            교사는 학교 시스템적으로 대부분 접근할 수 있다.

    지역 클래스
    - 함수 내에 클래스 정의할 경우 지역 클래스라고 부름
    - 자신을 둘러싼 코드의 멤버에 접근 가능

    널(null)
    - 아무것도 참조하지 않는 참조 값의 특별 상태
    - null에 접근하면 NPE 발생

    코틀린의 NULL
    - 일반 참조형(Int, String, ...)에서는 null 허용되지 않음

    nullable
    - 참조자 타입 뒤에 ? 붙이기
    - String 타입과 String? 타입은 전혀 다른 것이다. 컴파일에러 에러 발생함
    - nullable 타입의 경우에는 Null을 사전에 차단하고, 로직을 작성해야됨(논리적으로 배제되면)
        - if (s == null) return false 처럼 null은 로직에 포함시키지 않도록 스마트 캐스트
    - 객체가 만약 가변 프로퍼티라면, 안됨. 가변 프로퍼티는 언제든 null이 될 수 있으므로, 스마트 캐스트가 안됨
    cf) !! -> 널이 아님을 단언하는 연산자
    - 안전한 호출 연산자
    ex) fun readInt() = readLine()?.toInt() -> 만약 null이라면, 결과도 null을 반환

    엘비스 연산자 ( ?: )
    - 엘비스 연산자 왼쪽 값이 null이라면, 연산자 오른쪽 값으로 치환
    ex) fun readInt() = readLine()?.toInt() ?: 0 -> null 이라면 0 반환
    - 엘비스도 조건문의 일부라서, 연산자 우측 값 대신, return 또는 throw를 쓸 수 있다.

    최상위 프로퍼티
    - 전역 변수 또는 상수 역할로 메인 함수 외부에 존재
    - 가시성 : public, private, internal

    늦은 초기화
    - lateinit var 변수명: 변수타입
    - 생성자에서 초기화되지 않지만, 프로그램 흐름 상 실사용 시는 초기화되는 것이 명백한 변수에는 lateinit 예약어로 표기하여 null 값 불가함 표기
    - 이는 프로그래머가 직접 언젠간 수동으로 작성해줘야됨

    커스텀 접근자(get)
    - 프로퍼티에 대한 접근을 함수로 수행
    - 이는 메모리에 저장되는 변수와 전혀 다름

        val r1 = Rect(5, 4)
        println(r1.area)
        r1.width = 6
        println(r1.area)
        println("----")

        val r2 = Rect2(5, 4)
        println(r2.area)
        r2.width = 6
        println(r2.area)

        위 r1과 r2는 서로 다르다. r1은 get을 사용해서 area가 호출되면 사라지는 휘발성. 즉, 메모리에 저장되지 않고 매번 호출될 때마다 새로운 값을 불러온다.

    커스텀 세터
    - 가변 프로퍼티를 계속해서 수정할 때 검증 등을 수정하면서 여러 로직을 할당할 수 있음
    - private으로 접근 통제 가능함.

    뒷받침 필드
    - 커스텀 접근자 게터(세터) 등을 사용할 때, 메모리에 뒷받침하는 필드를 두어 값을 저장할 수 있다.
    - get, set을 커스텀할 때 변수명을 그대로 사용할 경우 무한루프에 빠짐. 그래서 filed를 통해 백 필드로 할당해줌
    - 만약, set에서 뒷받침하는 필드가 없다면 메모리 할당이 되지 않음. 이럴 때는 다른 값을 수정하는 등을 위해서 사용됨

    지연 계산 프로퍼티
    - lateinit과 유사하지만, 이는 자동으로 해줌. 즉, 해당 객체의 프로퍼티를 호출할 때 생성함
    - by lazy { }

    객체
    - 오직 하나의 인스턴스만 존재하는 클래스는 object라는 키워드로 정의하며, 객체라 부름
    - 선언과 동시에 인스턴스가 생성됨

    내포 객체
    - 특정 클래스의 모든 인스턴스가 공유하는 객체를 만들 때 내부 객체를 정의하여 사용
    ex) 팩토리 디자인 패턴
        class Application private constructor(val name: String) {
            object Factory {
                fun create(args: Array<String>): Application? {
                    val name = args.firstOrNull() ?: return null
                    return Application(name)
                }
            }
        }

        이는 팩토리 객체로만 application 객체를 생성할 수 있음을 뜻한다.

    동반 객체
    - 내부 객체명을 일일이 작성하는 것보다는 companion object로 선언하면 해당 객체명을 작성하지 않아도 됨

    익명 객체
    - object를 활용한다
    - 지역 선언, 비공개 선언으로만 가능하다
    ex) fun midPoint(xRange: IntRange, yRange: IntRage) = object {
        val x = (xRang~~

    }

 */
class Rect(var width: Int, var height: Int) {
    val area: Int
        get() = width * height
}

class Rect2(var width: Int, var height: Int) {
    val area: Int = width * height
}

class People {
    // 프로퍼티
    var firstName: String = ""
    var familyName: String = ""
    var age: Int = 0

    // 메소드
    fun fullName() = "$firstName $familyName"

    fun showMe() {
        println("${fullName()}: $age")
    }
}

class People2(firstName: String, familyName: String) {
    val fullName = "$firstName $familyName"
}

// 이렇게, 프로퍼티를 초기화할 때 로직이 복잡하다면, init을 활용
class People3(fullName: String) {
    val firstName: String
    val familyName: String
    init {
        val names = fullName.split(" ")
        if (names.size != 2) throw IllegalArgumentException("Invalid name: $fullName")

        firstName = names[0]
        familyName = names[1]
    }
}

class People4{
    val fullName: String
    constructor(firstName: String, familyName: String):
            this("$firstName $familyName")
    constructor(fullName: String) {
        this.fullName = fullName
    }
}

class People5(val fullName: String) {
    constructor(firstName: String, familyName: String):
            this("$firstName $familyName")
}

class People6(val id: Id, val age: Int) {
    class Id(val firstName: String, val familyName: String)
    fun showMe() = println("${id.firstName} ${id.familyName}, $age")
}

class People7(name: String) {
    var lastChanged: Date? = null
        private set

    var name: String = name
        set(value) {
            lastChanged = Date()
            field = value
        }
}

fun main() {
//    val person = People() // person 이라는 객체의 참조자 변수가 새롭게 생성한 People 객체를 가리킴
//
//    person.firstName = "Jungyu"
//    person.familyName = "Park"
//    person.age = 27
//
//    // 또는
//
//    val message = People().run {
//        firstName = "JunGyu"
//        familyName = "Park"
//        age = 27
//    }
//
//    val p2 = People2("JG", "P")

    val r1 = Rect(5, 4)
    println(r1.area)
    r1.width = 6
    println(r1.area)
    println("----")

    val r2 = Rect2(5, 4)
    println(r2.area)
    r2.width = 6
    println(r2.area)

//    val id = People6.Id("JG", "P")
//    val p = People6(id, 25)
//    p.showMe()

//    var x = 1
//    class Counter {
//        fun increment() = x++
//    }
//
//    Counter().increment()
//    println(x)

}