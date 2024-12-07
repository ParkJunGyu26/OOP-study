package kau.beforeClass.MID.week7

// 하나의 변수(메모리 할당)은 할 수는 없으므로, getter가 필요함
val IntRange.leftHalf: IntRange
    get() = start .. (start + endInclusive) / 2

fun main() {
    println(1 .. 3)
    println(1 until  10)

    println((1 .. 3).leftHalf)
    println((1 until 10).leftHalf)
}