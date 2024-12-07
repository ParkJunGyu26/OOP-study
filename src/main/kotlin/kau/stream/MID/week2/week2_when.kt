package kau.stream.MID.week2

// 해당 숫자를 16진수로 바꿔줌
fun hexDigit(n: Int): Char {
    // if 문으로 했을 때
//    if (n in 0 .. 9) return '0' + n
//    else if (n in 10 .. 15) return 'A' + (n - 10)
//    return '?'

    // when으로 했을 때 (읽기 편함)
//    when {
//        n in 0 .. 9 -> return '0'+n
//        n in 10 .. 15 -> return 'A' + n - 10
//        else -> return '?'
//    }

    // when 을 조금 더 짧게
    when(n) {
        in 0 .. 9 -> return '0' + n
        in 10 .. 15 -> return 'A' + n - 10
        else -> return '?'
    }
}

fun numberDescription(n: Int): String {
    when(n) {
        0 -> return "Zero"
        in 1 .. 3 -> return "Small"
        in 4 .. 9 -> return "Medium"
        in 10 .. 100 -> return "Large"
        !in 0 .. Int.MAX_VALUE -> return "Negative"
        else -> return "Huge"
    }
}

// 8번 실습 -> if, else 를 조금 더 깔끔하게 when 구문
fun main() {
//    val n = readLine()!!.toInt()
//    println(hexDigit(n))

    val nn = readLine()!!.toInt()
    println(numberDescription(nn))
}