package kau.stream.FINAL.week13

/*
< collection - Array >

배열(Array)는 배열 크기가 정해져있다.
그래서, 추가하거나 삭제할 순 없다.
다만, 대치(해당 값을 바꾸기)는 가능하다.

어떤 것을 상속받는 것이 아니라
기본적으로 제공해주는 자료구조다.

하지만, 배열에는 iterator() 라는 함수가 있다.
이걸 통해서 반복문에서 활용 가능하다

< collection - intArray >
IntArray 보다 성능이 좋다

< collection - Array 생성법 >
1) arrayOf( ... )
2) Array(크기) { 인덱스 별 생성자 }
3) intArrayOf( ... ) : 성능이 더 최적화 (Int 보다는 int 는 객체가 아니라서 효율적)
2) IntArray() {} ex) IntArray(10) { it * 2 } // 람다함수

 */

fun main() {
    val arr = arrayOf("Hello", "Kotlin")
    val arr2 = intArrayOf(1, 2, 3)

    for (elem in arr)
        println(elem)

    for (elem in arr2)
        println(elem)
}