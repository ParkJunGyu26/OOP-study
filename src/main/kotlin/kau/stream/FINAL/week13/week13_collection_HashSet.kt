package kau.stream.FINAL.week13

/*
< collection - HashSet >
- hashCode 를 이용한 집합이다. (내용물이 같으면 똑같은)
- MutableSet
- 삽입, 삭제, 조회가 O(1)
- 생성법 : hashSetOf(...) , HashSet<T>(initialCapacity)

- 특징
    - 중복되지 않은 원소들의 집합
    - MutableSet : 원소의 삽입/삭제가 가능한 Set
 */

fun main() {
    val s = hashSetOf("Apple", "Banana", "Orange")
//    println(s.contains("Apple"))
//    println(s.contains("Hello"))
//    println(s)

    // 삽입한 순서대로 저장하는 LinkedSet(삭제하고, 다시 추가하면 맨 뒤에 저장됨)
    val s2 = linkedSetOf("Apple", "Orange", "Banana")
//    println(s2)
    s2.remove("Orange")
    s2.add("Orange")
    println(s2)
}