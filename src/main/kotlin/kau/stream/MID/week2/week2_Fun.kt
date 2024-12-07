package kau.stream.MID.week2

import kotlin.math.PI

// 1번 실습
// 함수 정의 : fun 함수명(변수1 이름: 타입, 변수2 이름: 타입, ...): 반환 타입
// 코틀린에서는 매개변수의 타입을 반드시 적어줘야 된다.
fun circleArea(radius22: Double): Double {
    // radius += 1 -> 에러 발생 : 함수의 매개변수 무조건 val 타입이라서 수정 불가능
    // 만약 굳이 사용하고 싶다면, 새로운 변수를 선언해줘서 사용한다.
    val radius = radius22 + 1
    return (radius * radius) * PI
}

// 1-2번 실습
// 함수에서 단순하게 return 만 하는 경우에는 return 을 쓰지 않고,
// = 을 활용해서 간단하게 작성할 수 있다.
fun testArea(testNum: Int): Int = (testNum + 3)

// 2번 실습
// 함수의 반환값을 유추할 수 있다면, 함수의 반환 타입을 생략할 수 있다.
// 파라미터 인자값을 직접 매개변수로 사용할 수 있다.
fun rectangleArea(width: Double, height: Double) = width * height

// 3번 실습
// 함수의 오버로딩 : 변수명은 같지만, 매개변수의 개수, 타입에 따라 결정
//fun readInt() = readLine()!!.toInt()
//fun readInt(radix: Int) = readLine()!!.toInt(radix)

// 3-2번 실습
// 함수의 디폴트 매개변수
// 만약 매개변수로 아무것도 주지 않는다면 10이 default가 되어 전달
// 만약 매개변수 주어지면 그 값으로 전달
fun readInt(radix: Int = 10) = readLine()!!.toInt(radix)

// 4번 실습
// 함수의 오버로딩 -> 여러 경우의 수 테스트해보기
// 조금 더 매개변수와 가까운 타입에 맞도록 실행됨
fun mul(a: Int, b: Int) = a * b
fun mul(a: Int, b: Int, c: Int) = a * b * c
fun mul(s: String, n: Int) = s.repeat( n )
fun mul(o: Any, n: Int) = Array(n) { o }

// 5번 실습
// 함수의 가시성
public fun test1(a: Int) = a+1 // 모든 파일에서 사용 가능(디폴트)
internal fun test2(a: Int) = a+2 // 컴파일 같이 되면 사용 가능(같은 패키지)
private fun test3(a: Int) = a+3 // 같은 파일에서만 사용 가능

// main 함수처럼 반환 값이 없는 경우에는 반환 타입을 생략할 수 있다.
// (또는 Unit 이라고 명시할 수 있음) fun main(): Unit {}
fun main() {
    // 1번 실습 -> 함수
//    print("Enter Radius : ")
//    val radius = readLine()!!.toDouble()
//    println("Circle Area : ${circleArea(radius)}")

    // 2번 실습 -> 함수의 매개변수
    // 매개변수 이름을 명시하지 않아도 됨
//    println("Rectangle Area1 : ${rectangleArea(10.0, 20.0)}")
    // 매개변수 이름을 직접 명시해도 됨
//    println("Rectangle Area2 : ${rectangleArea(width = 10.0, height = 20.0)}")
    // 매개변수 순서를 바꿔서 직접 기입해도 됨
//    println("Rectangle Area3 : ${rectangleArea(height = 20.0, width = 10.0)}")

    // 3번 실습 -> 함수의 오버로딩 기초
    // 같은 함수이지만, 요구하는 매개변수가 달라서 이를 함수의 오버로딩이라고 한다.
//    print("Enter decimal number: ")
//    val dec = readInt()
//    println("Decimal number : $dec")
//
//    print("Enter hexadecimal number : ")
//    val hex = readInt(16)
//    println("Hex number : $hex")

    // 4번 실습 -> 함수의 오버로딩 심화
//    println("${mul(1, 2)}")
//    println("${mul(1L, 2)}")
//    println("${mul("0", 3)}")
//    println("${mul("0" as Any, 3)}")

    // 5번 실습 -> 다른 패키지에서 함수 호출
//    print("Enter radix : ")
//    val radix = readLine()!!.toInt()

//    print("Enter Number : ")
//    val num = test4(radix) -> 기존 패키지의 이름 그대로 호출
//    val num = myFun(radix) // 기존 패키지 함수 이름을 as를 이용하여 커스텀
//    println(num)
}