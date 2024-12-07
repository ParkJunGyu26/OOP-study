package kau.beforeClass.week12

/*
< 일반 class - 동등성 >
일반 클래스의 동등성 비교는 equals(), hashCode() 에 대한 커스텀(오버라이딩)이 필요하다.

모든 객체는 equals(), hashCode(), toString() 세 가지 메서드를 가지고 있다. -> 왜냐하면, 최상위 클래스의 Any 를 상속받기 때문이다
1) equals() : 개념상 같으냐? (재정의하지 않으면, 객체가 같은지를 묻도록 되어 있음)
2) hashCode()

 */

class Person12(
    val firstName: String,
    val lastName: String,
    val age: Int
) {
    // 비교하는 두 객체간 프로퍼티가 동일하다면 true 로 판단
    override fun equals(other: Any?): Boolean {
        if (other !is Person12) return false
        return other.firstName == this.firstName
            && other.lastName == this.lastName
            && other.age == this.age
    }

    // 난수 31을 곱해야 hashCode 와 가까워짐
    override fun hashCode(): Int {
        var hash = firstName.hashCode()
        hash = lastName.hashCode() + 31 * hash
        return age.hashCode() + 31 * hash
    }
}

/*
< data class - 동등성 >
data class 는 파라미터로 프로퍼티를 정의를 하도록 하는 것이
같으면 자동으로 같도록 동등성 비교를 해줌

하지만, 파라미터로 받지 않는 프로퍼티가 있고,
그 프로퍼티가 객체의 아이덴티티 역할을 한다고 하면, 오히려 동등성 파악에 안 좋을 수 있다.

따라서, 이 클래스로 만든 정체성은 파라미터로 받은 프로퍼티만으로 정해지는 클래스임을 확신할 때만
data class 를 사용해야 된다. (무조건 data 붙인다고 좋은 것은 아님)

또한, data class 의 파라미터의 값들이 모두 data class 타입이어야 한다.
만약 파라미터로 일반 클래스가 올 경우에는 모호해질 수 있다.
따라서, 두 객체(data class 타입)을 비교할 때 거짓이 나온다.

ex) Person(일반 class), Mailbox(data class)
Mailbox(val address: String, val person: Person)

val box1 = Mailbox(~~~)
val box2 = Mailbox(~~~)
box1 != box2

또한, toString() 이 자체적으로 구현되어 있다.

또한, copy() 가 구현되어 있다.
1) 일반적인 복사
2) 재정의해서 복사

또한, Pair, Triple 가 있다.

그리고, 구조 분해 선언도 된다.
val person = Person("john", "doe", 25)
val (firstName, lastName, age) = person

또는, 모두 받을 필요가 없다.
val (firstName, lastName) = person
val (_, lastName, age) = person

Pair, Triple 과 구조 분해 for 문에서 활용할 수 있다.
val array = arrayOf(1 to "one", 2 to "two", 3 to "three")


 */

data class Person12_1(
    val firstName: String,
    val lastName: String,
    val age: Int
)

class Person12_2(val firstName: String,
    val lastName: String,
    val age: Int)

data class MailBox(val address: String, val person: Person12_2)

fun main() {
    // 일반 클래스의 경우에는 equals(), hashCode(), toString() 을 커스텀(오버라이딩) 필요함
//    val person12_1 = Person12("John", "Doe", 25)
//    val person12_2 = Person12("John", "Doe", 25)
//    val person12_3 = person12_1
//
//    println(person12_1 == person12_2) // 서로 다른 객체이므로 false
//    println(person12_1 == person12_3) // 서로 같은 객체이므로 true
//    println(person12_2 == person12_3) // 서로 다른 객체이므로 false

    // 데이터 클래스의 경우에는 equals(), hashCode(), toString() 을 커스텀 되어있음.
//    val person12_1 = Person12_1("John", "Doe", 25)
//    val person12_2 = Person12_1("John", "Doe", 25)
//    val person12_3 = person12_1
//
//    println(person12_1 == person12_2) // 서로 다른 객체이지만, 데이터 클래스의 equals 때문에 true
//    println(person12_1 == person12_3) // 서로 같은 객체이므로 true
//    println(person12_2 == person12_3) // 서로 다른 객체이지만, 데이터 클래스의 equals 때문에 true

    // Mailbox 는 data class 타입이지만, 해당 클래스의 모든 파라미터가 data class 이어야 equals 효과가 동일하다
    // 즉, Person12_2 라는 일반 클래스 타입이 있어서 data class 정체성을 잃어버리게 된다.
    // Person12_2 도 data class 타입이어야 Mailbox 의 data class 정체성을 갖게 된다.
//    val mailbox1 = MailBox("Unknown", Person12_2("John", "Doe", 25))
//    val mailbox2 = MailBox("Unknown", Person12_2("John", "Doe", 25))
//    println(mailbox2 == mailbox1)

    // toString() 을 커스텀 안하면 'kau.beforeClass.week12.Person12_2@7699a589' 이렇게 해시 값? 으로 나옴
//    val person12_2 = Person12_2("John", "Doe", 25)
//    println(person12_2)
//
//    // toString() 을 커스텀(오버라이딩) 하기 귀찮다면 data class 를 쓰자.
//    val person12_1 = Person12_1("John", "Doe", 25)
//    println(person12_1)

    // pair 와 구조분해를 활용한 for 문 (파이썬과 c++ 비슷)
    val array = arrayOf(1 to "one", 2 to "two", 3 to "three")
    for (elem in array)
        println("${elem.first} -> ${elem.second}")

    for ((number, name) in array)
        println("$number -> $name")
}