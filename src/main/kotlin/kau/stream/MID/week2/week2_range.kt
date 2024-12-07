package kau.stream.MID.week2

// 7번 실습 -> 범위('..', 'until', 'downTo', 'in')
fun main() {
//    val num = readLine()!!.toInt()

    // '..'은 양 끝 값도 동일하게 포함된다! (이상 및 이하)
//    println("$num in 10 .. 99 : ${num in 10 .. 99}")
//    println("$num !in 10 .. 99 : ${num !in 10 .. 99}")
//    println("----")

    // 'until'은 오른쪽 끝 값이 포함되지 않는다! (미만)
//    println("$num in 10 util 100 : ${num in 10 until 99}")
//    println("$num !in 10 util 100 : ${num !in 10 until 99}")
//    println("----")

    // 'downTo'은 높은 값에서 낮은 값으로 진행하는 진행 타입도 존재
    // downTo 는 보통 for 문에서 많이 사용
//    println("$num in 10 downTo 1 : ${num in 10 downTo 1}")
//    println("$num !in 10 downTo 1 : ${num !in 10 downTo 1}")
//    println("----")

    // '..' 은 증가하는 방향 -> 1 ~ 10
    // 'downTo' 는 감소하는 방향 -> 10 ~ 1
    // 위 두개에는 기본 값이 +- 1인데, 이 점프되는 구간 값을 설정하는 명령어는 step 이다.
    // 주의할 점은 downTo 는 감소한다고 해서, step 도 음수가 아니다.
    // step은 반드시 양수만 가능하다
//    print(".. is : ")
//    for (n in 1 .. 10) print("$n ")
//    println()
//    println("---")

//    print("downTo is : ")
//    for (n in 10 downTo 1) print("$n ")
//    println()
//    println("---")

//    print("step is : ")
//    for (n in 1 .. 10 step 2) print("$n ")
//    println()
//    println("---")

//    val str = readLine()!!
//    println("$str in \"def\" .. \"xyz\" : ${str in "def" .. "xyz"}")

    // 문자열에도 .. 을 사용할 수 있다.
    // 이도 동일하게 1번 인덱스부터 4번 인덱스 모두 포함하여 출력
//    println("Hello World".substring(1 .. 4))

    // 문자열에도 until 을 사용할 수 있다.
    // 이도 동일하게 1번 인덱스부터 3번 인덱스까지만 포함하여 출력
    // 이것이 substring 의 디폴트 값이다.
//    println("Hello World".substring(1 until 4))
//    println("Hello World".substring(1, 4))

    // 각 인덱스별 제곱수를 만들어 크기가 10인 정수형 배열을 만듦
//    val arr = IntArray(10) {it * it}
//    for (n in arr) print("$n ")
//    println()

    // 문자열처럼 배열도 슬라이싱할 수 있다.
    // .. 도 동일하게 양 끝 값을 모두 포함한다.
//    val subArr = arr.sliceArray(2 .. 5)
//    for (n in subArr) print("$n ")
//    println()

    // 배열도 마찬가지로 until로 인덱스에 접근할 수 있다.
//    val subArr2 = arr.sliceArray(2 until 5)
//    for (n in subArr2) print("$n ")
//    println()

    // 배열 또는 문자열에 in 을 활용해서 내부에 해당 원소가 존재하는지 파악이 가능하다
//    val numbers = intArrayOf(3, 7, 2, 1)
//    println("2 in numbers : ${2 in numbers}")
//    println("9 in numbers : ${9 in numbers}")
//    println("3 !in numbers : ${3 !in numbers}")
//    println()
//
//    val text = "Hello!"
//    println("'a' in text : ${'a' in text}")
//    println("'H' in text : ${'H' in text}")
//    println("'e' !in text : ${'e' !in text}")
}