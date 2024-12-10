package kau.stream.FINAL.week13

import java.util.TreeSet

/*
< collection - TreeSet >
- 코틀린 기본 패키지에 없기 때문에 java.util 에서 import 해야된다
- 대소 비교를 하는 검색 트리를 이용함
    - 숫자 순서, 알파벳 순서 등 정렬한 검색트리 형태

- 근처에 어떤 값이 있는지 찾을 수 있다.
    - lower : 자신 보다 작은 값(직전 값)
    - higher : 자신 보다 큰 값(직후 값)

- 클래스 타입을 사용하기 위해선 Comparable 을 선언하고, compare to 를 오버라이딩해야됨
 */

data class Person13(val firstName: String, val familyName: String, val age: Int) : Comparable<Person13> {
    val fullName get() = "$firstName $familyName $age"

    // 앞 쪽이면 음수, 같으면 0, 크다면 양수를 반환
    override fun compareTo(other: Person13): Int = fullName.compareTo(other.fullName)
}

fun main() {
    val s3 = sortedSetOf("Apple", "Orange", "Mango")
    println(s3)
    println(s3.lower("Mango")) // Mango 보다 바로 작은 값(왼쪽 인덱스들) -> Apple
    println(s3.higher("Mango")) // Mango 보다 바로 다음 값

    // Jane 이 John 보다 앞서는 이유는 알파벳 순서가 앞서기 때문임
    val s3_2 = sortedSetOf(Person13("John", "Doe", 30), Person13("Jane", "Doe", 25))
    println(s3_2)

    println(s3_2.contains(Person13("Jane", "Doe", 25)))

    // 나이는 다른데, 왜 같은 사람으로 나오지?! -> fullName 으로 여부를 판단하고 있음. 그래서, age 를 추가해주면 됨
    println(s3_2.contains(Person13("Jane", "Doe", 30)))
}