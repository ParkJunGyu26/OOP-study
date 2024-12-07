package kau.stream.MID.week7

//class Person123(val firstName: String, val lastName: String)
//val Person123.Companion.UNKNOWN = Person123("John", "Doe")
// -> Person123 클래스는 컴패니언 객체가 없는데, 확장하려고 하니깐 컴파일에서 오류

class Person1234(val firstName: String, val lastName: String) {
    companion object
}

// 뒷받침하는 필드가 없어도 레이지를 통해 초기화를 할 수 있다.
val Person1234.Companion.UNKNOWN by lazy { Person1234("John", "Doe") }

// 컴패니언 객체 - 하나뿐인 객체 자체도 확장할 수 있다.
fun IntRange.Companion.singletonRange(n: Int) = n .. n

fun main() {
    println(IntRange.singletonRange(3))
    println(IntRange.Companion.singletonRange(10))
}