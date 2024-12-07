package kau.stream.MID.week5

// 고차 함수(람다 함수)
// 파라미터에 함수도 함께 보내줌. 필요한 거 있으면 파라미터에 있는 함수에게 할당
fun initializeIntArray(n: Int, initializer: (Int) -> Int): IntArray {
    val arr = IntArray(n)

    for (i in 0 until n)
        arr[i] = initializer(i)

    return arr
}

// isTrue라는 함수도 매개변수로 받은 고차함수
// isTrue 함수는 Int를 매개변수로 받아서, 그 리턴값이 Boolean이다.
// 만약, 고차함수(람다함수)에서 리턴 값이 없는 경우에도 Unit(void) 이라고 명시해줘야 한다.
fun countIntArray(arr: IntArray, isTrue: (Int) -> Boolean): Int {
    var count = 0

    for (elem in arr)
        if (isTrue(elem)) count++;

    return count
}

fun aggregate(arr: IntArray, initValue: Int, op: (resultSoFar: Int, elem: Int) -> Int): Int {
    var result = initValue

    for (elem in arr)
        op(result, elem)

    return result
}

fun check(s: String, condition: (Int, Char) -> Boolean): Boolean {
    for (i in s.indices)
        if (!condition(i, s[i])) return false
    return true
}

fun add(a: Int, b: Int): Int = a + b

fun main() {
//    val arr = initializeIntArray(5, {idx -> idx * idx})
//    for (index in arr.indices)
//        println("$index : ${arr[index]}")

    // 정수형 배열에서 조건별로 카운팅해야될 때 -> 여러 함수를 만드는 경우가 있다.
    // ex) 짝수, 0, 음수 등...
    // 하지만, 이를 고차함수를 이용해보자
    val arr = intArrayOf(-2, -1, 0, 1, 2, 3, 4, 7)
//    println(countIntArray(arr, {elem -> elem % 2 == 0})) // 짝수 카운팅
//    println(countIntArray(arr, {elem -> elem == 0})) // 0 카운팅
//    println(countIntArray(arr, {elem -> elem < 0})) // 음수 카운팅

//    println(aggregate(arr, 0, {result, elem -> result + elem}))     // sum(덧셈
//    println(aggregate(arr, 1, {result, elem -> result * elem}))     // prod(곱셈)
//    println(aggregate(arr, Int.MIN_VALUE, { result, elem -> if (result > elem) result else elem})) // max(최대값)

    // 람다함수가 마지막 인자일 경우에는 굳이 안해도 상관없음
//    val aaa = IntArray(5) {it * it}

    // 사용하지 않는 파라미터는 밑줄 기호로 지정한다. "_"
//    println(check("Hello") {_, c -> c.isLetter()})
//    println(check("Hello") {i, c -> i == 0 || c.isLowerCase()})

    // 익명 함수 -> 람다함수의 대안으로, 함수의 형태로 파라미터로 넘기는 것을 뜻한다.
    // 근데, 람다함수를 더 많이 쓰이긴 한다.
//    println(check("Hello", fun(_, c) = c.isLetter()))
//    println(check("Hello", fun(i, c): Boolean { return i == 0 || c.isLowerCase() }))

    // 이미 존재하는 함수일 경우에는 람다 함수를 굳이 안써도 된다.
    println(aggregate(arr, 0, ::add)) // sum 과 동일
}