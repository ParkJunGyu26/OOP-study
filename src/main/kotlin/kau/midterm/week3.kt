package kau.midterm

import kotlin.random.Random

// 아래 두 경우에서 mul 함수를 호출할 때, 더 구체적인 아래 midterm의 mul가 우선순위 가장 높음
//import kau.*
//import kau.midterm.mul

/*

    함수
    - 형식
        - fun 함수명(매개변수이름: 타입, ...): 함수 반환타입 { }
    - 특징
        - 파라미터 타입은 필수
        - 반환값 생략 가능 -> void == Unit, Unit을 생략해도 ㄱㅊ
        - 파라미터는 수정할 수 없음.
        - return 대신, = 으로 함수형 프로그래밍 가능
        - 타입 유추가 될 경우에는 타입 생략 가능
            ex) fun getArea(radius: Double) = radius * radius * PI
    - 호출 방법
        - 파라미터 값을 즉시 적용
        - 파라미터 값에 = 이용해서 파라미터 이름으로 바로 전달 가능(순서는 상관없음)
    - 오버로딩
        - 매개변수 개수, 매개변수 타입에 따라서 후보군 생성
        - Any 는 객체의 최상위
        - 덜 구체적인(포괄적인) 것은 후보에서 계속 제외하면서 하나 남은 함수를 호출
            - 만약, 후보가 계속 2개 이상이라면, 컴파일 에러
    - 디폴트 파라미터
        - 파라미터가 없을 경우, 디폴트 값을 매개변수로 취급
    - 가시성
        - public : 디폴트, 어디에서나 접근 가능
        - private : 같은 파일에서만 접근 가능
        - internal : 컴파일되는 모듈 안에서만 접근 가능
    - 함수 내 함수(지역 함수?)
        - 해당 함수 외에선 호출 불가능

    패키지
    - 프로그램을 계층화하여 체계적으로 관리하는 방법
    - 디렉토리 구조와 일치
    - 호출
        - 동일 패키지 : import 없어도 호출 가능
        - 다른 패키지
            - import 없음 : 패키지위치.함수명 으로 함수를 호출해서 사용 가능
            - import 있음 : 맨 윗 부분에 import 패키지 위치를 선언해주면, 단순히 함수명으로 호출 가능
                - import .. as .. 는 해당 함수를 별칭으로 사용 / 서로 다른 패키지이지만 같은 함수일 경우 함수명을 커스텀해서 사용 가능
                - 패키지 내 모든 선언을 임포트할 경우, 구체적 import에 비해 우선 순위 떨어짐

    조건
    - if : Boolean 필요
    - if ~ else로 변수 선언 가능
        - c 언어의 ?(삼항 연산자)는 if (a>b) a else b 이렇게 표현 가능
    - if 문을 return 과 함께 사용가능
        - substring은 파이썬의 [index_1: index_2] 느낌 디폴트로 index_2는 마지막 인덱스

    범위 타입
    - '..'은 이상 과 이하를 뜻한다.
    - 'until'은 이상과 미만을 뜻한다.
    - 'in'은 특정 값이 범위에 포함되는지를 판단하는 연산
    - 'downTo' 은 큰 값에서 아래 값으로
        5 in 10 downTo 1
        - downTo도 .. 처럼 이하 와 이상을 뜻함
    - 'step'은 점프 기준(진행 간격)
        - 양수만 가능

    문자열 범위
    - String.substring()에 범위 지정하기
        - "Hello, World".substring(1 .. 4)
        - "Hello. World".substring(1 until 4)
        - "Hello. World".substring(1, 4) -> 1 unitl 4와 동일

    배열 범위
    - Array.sliceArray()
        - IntArray(10) { it * it }.sliceArray(2 .. 5)
        - IntArray(10) { it * it }.sliceArray(2 until 5)

    when
    - if .. else if .. else if .. 의 깔끔한 대안

    반복문은 기본적으로 내포된 루프에서 우선적으로 break, continue 실행
    따라서, 외부 루프로 적용시키려면 레이블 @outerLoop 사용하기
    break, continue 바로 뒤에 @outerLoop를 붙이면, 루프 중 @outerLoop 라벨 붙은 곳을 break, continue 진행
 */

//fun mul(a: Int, b: Int) = a * b
//fun mul(a: Int, b: Int, c: Int) = a * b * c
//fun mul(s: String, n: Int) = s.repeat(n)
//fun mul(o: Any, n: Int) = Array(n) { o }

// outerLoop는 중첩된 루프에서 외부 루프에 라벨 지정하는 방법
// 라벨은 "이름@" 으로 루프 앞에 붙여서 정의
// break, continue 바로 뒤에 @outerLoop로 외부 루프를 break, continue 진행
fun indexOf(subArray: IntArray, array: IntArray): Int {
    outerLoop@ for (i in array.indices) {
        for (j in subArray.indices) {
            if (subArray[j] != array[i+j]) continue@outerLoop
        }
        return i
    }
    return -1
}

// throw를 통해 비정상적인 상황 발생을 런타임에서 예외처리
// 2진수를 10진수로 변환
fun parseIntNumberInBinary(s: String): Int {
    var num = 0

    if (s.length !in 1 .. 31) throw NumberFormatException("Not a number $s")

    for (c in s) {
        if (c !in '0' .. '1') throw NumberFormatException("Not a number $s")
        num = num * 2 + (c - '0')
    }
    return num
}

// try & catch를 이용해서 예외처리 안전하게 처리
// finally는 try, catch 상관없이 마지막에 항상 실행이 됨
fun readInt(default: Int): Int? = try {
    readLine()?.toInt()
} catch (e: NumberFormatException) {
    default
} finally {
    println("finally 실행")
}

fun main() {
//    println(mul(1, 2))
//    println(mul(1L, 2))
//    println(mul("0", 3))
//    println(mul("0" as Any, 3))

//    val args = arrayOf("ABC", "DEF", "HIJ")
//    fun swap(i: Int, j: Int): String { // main 함수 외부에선 호출 불가능 (import 로도 안됨)
//        val chars = args[0].toCharArray() // args 문자열 배열의 0번째 인덱스의 문자열을 문자 배열로 타입 변환
//        val tmp = chars[i]
//        chars[i] = chars[j]
//        chars[j] = tmp
//        return chars.concatToString()
//    }
//    println(swap(0, args[0].lastIndex))
//    val i = readLine()?.toInt()
//    val s = arrayOf("AB", "CD", "EF", "GH")

//    val s = readLine()
//    val i = s?.indexOf("/")
//    val result = if (i != null && i >= 0) {
//        println("i : ${i}")
//        val a = s.substring(0, i).toInt() // [0:i]
//        val b = s.substring(i+1).toInt() // [i:1:]
//        println("a : $a")
//        println("b : $b")
//        (a/b).toString()
//    } else ""
//    println(result)

//    val chars = "abc" .. "xyz"
//    val result = if ("bbb" in chars) "Good" else "Bad"
//    println(result)

//    println(5 in 10 downTo 1)
//    println(5 in 1 downTo  -5)

//    println("Hello, World".substring(1 .. 4))
//    println("Hello, World".substring(1 until  4))
//    println("Hello, World".substring(1, 4))

//    val a = IntArray(10) {it + 2}.sliceArray(0 .. 5)
//    val b = IntArray(10) {it + 2}.sliceArray(0 until  5)
//    println(a.lastIndex)
//    println(b.lastIndex)

//    val num = 1 .. 100
//    println(50 in num)
//    println(50 !in num)

//    val a = intArrayOf(1, 4, 9)
//    val b = IntArray(3) { (it+1) * (it+1) }

//    fun hexDigit(n: Int): Char {
//        if (n in 0 .. 9) return '0' + n
//        else if (n in 10 .. 15) return  'A' + (n - 10)
//        else return '?'
//    }
//
//    fun hexDigit2(n: Int): Char {
//        when(n) {
//            in 0..9 -> return  '0' + n
//            in 10 .. 15 -> return 'A' + n - 10
//            else -> return '?'
//        }
//    }

//    fun numberDescription(n: Int): String
//    = when(n) {
//        0 -> "Zero"
//        in IntArray(3) {it + 1} -> "Small" // intArrayOf(1, 2, 3) == 1, 2, 3
//        in 4..9 -> "Medium"
//        in 10 .. 100 -> "Large"
//        !in 0 .. Int.MAX_VALUE -> "Negative"
//        else -> "Huge"
//    }
//    println(numberDescription(1))

//    var sum = 0
//
//    do {
//        val num = readLine()?.toInt()
//        if (num != null) sum += num
//    } while (num != 0)
//
//    println("Sum : $sum")

//    val num = Random.nextInt(1, 101)
//    var guess: Int? = 0
//
//    while (guess != num) {
//        guess = readLine()?.toInt()
//        if (guess != null && guess < num) println("Too small")
//        else if (guess != null && guess > num) println("Too big")
//    }
//    println("Right, it's $guess")

//    val a = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9 ,10)
//    val b = IntArray(10) {it + 1}
//    for (x in b) println(x)

//    val num = Random.nextInt(1, 101)
//    while (true) {
//        val guess = readLine()?.toInt() ?: 0
//        if (guess < num) println("Small")
//        else if (guess > num) println("Big")
//        else break
//    }
//    println("one, Right it's $num")
//
//    val num2 = Random.nextInt(1, 101)
//    while (true) {
//        val guess = readLine()?.toInt() ?: 0
//
//        val message =
//            if (guess < num2) "Small"
//            else if (guess > num2) "Big"
//            else break
//        println(message)
//    }
//    println("two, Right it's $num2")

//    val a = intArrayOf(1, 2, 3, 4, 5, 6, 7)
//    val b = IntArray(7) { it + 1 }
//    println(indexOf(a, b))


}