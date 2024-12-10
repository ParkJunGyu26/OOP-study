package kau.stream.FINAL.week13

/*
< collection - HashMap >
- Pair 형태로 넣는다.
- 생성법 : hashMapOf(key to value, ...)

< collection - TreeMap >
- key 는 comparable 해야 된다.
- 생성법 : sortedMapOf(key to value, ...)
 */

fun main() {

    val m = hashMapOf(1 to "One", 2 to "Two", 3 to "Three")
    m[4] = "Four"
    m[100] = "One Hundred" // 100번째가 아니라 그냥 100이라는 인덱스임
    println(m)
    println(m[5]) // 아무것도 없으니 null 을 반환

    val m2 = sortedMapOf(1 to "One", 2 to "Two", 3 to "Three")
    m2[4] = "Four"
    m2[100] = "One Hundred"
    println(m2)
}