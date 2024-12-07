package kau.beforeClass.MID.week2

// 2진수를 10진수로 변환
fun paresIntNumberInBinary(s: String): Int {
    var num = 0

    println("자원 할당 ")

    try {
        if (s.length !in 1 .. 32) throw NumberFormatException("Not a Number: $s")

        for (c in s) {
            if (c !in '0' .. '1') throw NumberFormatException("Not a Number: $s")
            num = num * 2 + (c - '0')
        }
    } finally { // 예외처리가 발생하더라도 finally는 반드시 실행된다
        println("자원 정리")
    }

    return num
}

fun main() {
//    val s = readLine()!!
//    var num: Int
//    try {
//        num = paresIntNumberInBinary(s)
//    } catch (e : NumberFormatException) {
//        num = -1
//    }
//    println("Number is $num")

    val num = try {
        readLine()!!.toInt()
    } catch (e : NumberFormatException) {
        -1
    }
}