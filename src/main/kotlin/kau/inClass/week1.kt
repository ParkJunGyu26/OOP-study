package kau.inClass

fun main() {
//    val s1 = "hello"
//    val n = 5
//    val s2 = "hello" + n
//    println(s2)
//    val target = "hello5"
//    println(target)
//    println(s2 === target)


    print("첫 번째 정수를 입력하세요: ")
    val a = readLine()!!.toInt()
    print("두 번째 정수를 입력하세요: ")
    val b = readLine()!!.toInt()
    print("세 번째 정수를 입력하세요: ")
    val c = readLine()!!.toInt()
    print("${a} + ${b} + ${c} = ${a+b+c}입니다.")
}