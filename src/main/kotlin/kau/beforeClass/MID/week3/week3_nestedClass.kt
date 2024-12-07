package kau.beforeClass.MID.week3

// 장점: 내포된 클래스는 밖에 있는 클래스의 private 멤버에 접근할 수 있따.
class Person(private val id: Id, private val age: Int) {

    // id 클래스는 firstName 이라는 파라미터이면서 멤버 변수(property)와 familyName 이라는 파라미터이면서 멤버 변수(property)
    class Id(val firstName: String, val familyName: String)

    fun showMe() = println("${id.firstName} ${id.familyName}: $age")
}

fun main() {
    val id = Person.Id("John", "Doe")
    val person: Person = Person(id, 25)

    person.showMe()
}