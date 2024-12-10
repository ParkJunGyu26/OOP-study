package kau.stream.FINAL.week13

/*
< collection - ArrayList >
- 배열을 이용한 MutableList (파이썬의 리스트와 유사)
    - Collection : 원소들의 집단
        - List : 순서를 가진 원소들의 집단
            - MutableList : 원소의 삽입, 삭제, 대치가 가능한 List

- 조회, 대치는 O(1)
- 삽입, 삭제는 O(N)

cf) Collection 과 Iterable 을 굳이 구분해주지 않아도 된다. 그래도, Iterable 이 더 상위 클래스다.
cf) List 는 순서가 있는 원소들의 집단이지만, Set 은 순서가 없는 원소들의 집단이다.


< collection - ArrayList 생성법>
- arrayListOf()
- ArrayList<T>(size)

파이썬의 list도 ArrayList로 구현, 코틀린의 list도 기본적으로 ArrayList으로 구현됐다.
 */

fun main() {
    val list = arrayListOf(1, 2, 3, 4, 5)
    list.add(2, 8)
    println(list.joinToString())

    list.removeAt(0)
    println(list)

    // 비어있는 ArrayList이지만, 사이즈가 100이다
    val list2 = ArrayList<String>(100) // ArrayList<Type> (사이즈)
    list2.add("Hello")
    list2.add("World")
    list2.add(1, "This")
    println(list2)
}