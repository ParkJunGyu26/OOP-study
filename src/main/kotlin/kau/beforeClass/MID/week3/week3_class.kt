package kau.beforeClass.MID.week3

//class Person1 {
//    var firstName: String = ""
//    var faimilyName: String = ""
//    var age: Int = 0
//
//    fun fullName() = "$firstName $faimilyName"
//    fun showMe() {
//        println("${fullName()}: $age")
//    }
//}

//class Person2(firstName: String, familyName: String) { // 주 생성자
//    val fullName = "$firstName $familyName"
//}

//class Person3(fullName: String) {
//    val firstName: String
//    val familyName: String
//
//    init {
//        val names = fullName.split(" ")
//        if (names.size != 2) throw IllegalArgumentException("Invaild Name: $fullName") // 예외 처리
//        firstName = names[0]
//        familyName = names[1]
//    }
//}


// firstName은 생성자의 파라미터일뿐이다
// 다만, 파라미터에 val, var 으로 변수로 선언해주면, 해당 클래스의 property(속성)이 된다.

//class Person4(val firstName: String, val familyName: String) {
//    val fullName = "$firstName $familyName"
//
//    // 생성자의 파라미터에 val, var가 안붙으면 해당 메서드는 사용할 수 없음
//    // firstName은 생성자의 파라미터이므로, 일반적 함수에서는 사용할 수 없다. 생성자 끝나면 해당 파라미터는 의미가 없기 때문에 안됨
//    fun printFirstName() {
//        println("$firstName")
//    }
//}

//class Person5(val fullName: String) {
////    val fullName: String = fullName -> 주생성자에 val을 쓰면 굳이 안 써도 됨
//
//    constructor(firstName: String, familyName: String) : // 보조 생성자
//        this("$firstName $familyName")
//
//    // this.fullName을 쓰는 이유는 파라미터에 fullName와 클래스 속성인 fullName 이 동일하므로 사용한다.
//    // 여기에서 this.fullName 이 해당 클래스의 속성이다
////    constructor(fullName: String) {
////        this.fullName = fullName
////    }
//}


// 가시성(private, internal, public) -> 접근 제어성

//class Person6 internal constructor(private val fullName: String) {
//    // (같은 패키지 안)컴파일 내에서만 읽을 수 있는 'internal'
//    internal val firstName: String
//
//    // 클래스 내에서만 읽을 수 있는 'private'
//    private val familyName: String
//
//    // 자바와 다르게 멤버가 속한 하위 클래스에서 볼 수 있는 'protected' (상속)
//    protected val tmp: String = ""
//    init {
//        val names = fullName.split(" ")
//        firstName = names[0]
//        familyName = names[1]
//    }
//
//    fun showMe() {
//        println("$firstName $familyName")
//    }
//}


// 만약 생성자에 private를 한다면 생성자는 어떻게 만드는지 설명 -> 나중에 배움

//class Person7 private constructor(private val fullName: String) {
//    private val firstName: String
//    private val familyName: String
//
//    init {
//        val names = fullName.split(" ")
//        firstName = names[0]
//        familyName = names[1]
//    }
//
//    // 이게 있어야 생성 가능
//    // 생성자를 만드는 함수를 따로 만듦
//    companion object {
//        fun makePerson(): Person7 {
//            return Person7("John Doe")
//        }
//    }
//}


fun main() {
    // 주생성자 -> 생성자가 하나
//    val person: Person = Person1()
    // 직접 멤버 변수 할당
//    person.firstName = "John"
//    person.faimilyName = "Doe"
//    person.age = 25
//    person.showMe()

    // 생성자에서 멤버 변수 생성
//    val person2 = Person2("John", "Doe")
//    println(person2.fullName)

//    val person3 = Person3("John Doe")
//    println(person3.firstName)
//    println(person3.familyName)

//    val person4 = Person4("John", "Doe")
//    person4.printFirstName()


    // 부생성자 -> "오버로딩" 을 통해 여러 생성자 만들 수 있음
//    val person5 = Person5("John", "Doe")
//    println("person5 : ${person5.fullName}")
//
//    val person6 = Person5("Jane Doe")
//    println("person6 : ${person6.fullName}")

//    val person7 = Person6("John Doe") // 주 생성자에 private constructor를 선언하면 안됨
//    println(person7.firstName)

    // 함수 내에서 만드는 클래스 -> 안드로이드에서 많이 쓰인다네..
//    var x = 1
//
//    class Counter {
//        fun increment() {x++}
//    }
//
//    val c = Counter()
//    c.increment()
//
//    println("x : $x")
}