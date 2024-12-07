package kau.beforeClass.MID.week1

import java.util.Date

fun main() {
    // 'readLine()' 은 문자열을 입력받음
    // '!!' 은 앞에 입력받는 값이 Null이 아님을 선언
    // 'toInt()' 는 정수형으로 변환해줌
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()

    val aaa = 3;
//    aaa = 5; -> val은 불변 변수이므로 처음에 입력했던 값에서 변경이 불가능
    var aab = 5;
    aab = 10; // var은 가변 변수이므로 처음에 입력했던 겂에서 변경이 가능

    println("first : $first")
    println("second : " + second)
    println("first + second = ${first+second}")
//    println(13 and 19)
//    println('\u03C0')

    val str1 = "Hello "
    val str2 = "World"
    val str3 = str1 + str2
//    println("str1 : " + str1)
//    println("str2 : " + str2)
//    println("str3 : " + str3)

    val str4 = "Hello World\nThis is \"multiline\" string"
//    println(str4)

    val str5 = "\u03C0 \u2248 3.14" // (유니코드) π ≈ 3.14
//    println(str5)

    val str6 = "Charlie"
//    println("Hello, $str6! Today is ${Date()}") // 문자열 템플릿 '${}' 변수

    // 큰 따옴표 세 개는 이스케이프 문자 없이도 사용 가능함
    val str7 = """
        Hello.
        "Today" is \ 
        ${Date()}
    """.trimIndent()
//    println(str7)

    // 만약 세 개의 큰 따옴표 안에서 이스케이프를 사용하고 싶다면 ${} 템플릿을 이용해야된다.
    val str8 = """
        raw string starts with ${"\"\"\""}
    """.trimIndent()
//    println(str8)

    val str9 = "Hello"
//    println(str9.length)
//    println(str9.lastIndex)

    val str10 = "Hello!"
//    println(str10[3])
//    str10[3] = 'i' -> 코틀린에서 문자열은 배열이 아니라서 객체 그 자체이므로 중간에 바꿀 수 없음
//    str10[100] -> 범위를 벗어나므로 에러

    val sum = 10
    val str11 = "This is " + sum // sum 뒤에 toString()이 생략된 것임
//    println(str11)
    val str12 = "This is ${sum}"
//    println(str12)

    val str13 = "h = 10"
    val tmp = 10
    val str14 = "h = " + tmp
//    println(str13 == str14) // true -> '내용'을 비교하므로 참이 나옴
//    println(str13 === str14) // false -> 내용은 같지만 객체 자체는 다르므로 거짓이 나옴

    val str15 = "Hello"
//    println(str15.isEmpty()) // false -> 빈 값이 아니므로
    val str16 = ""
//    println(str16.isEmpty()) // true -> 빈 값이므로
    val str17 = "Hello"
//    println(str17.substring(2)) // 2번째 인덱스부터 출력
//    println(str17.substring(2, 3)) // 2번째 인덱스부터 3-1번째 인덱스까지
//    println(str17.substring(2, 4)) // 2번째 인덱스부터 4-1번째 인덱스까지
//    println(str17.startsWith("H"))
//    println(str17.startsWith("e"))

    val a = emptyArray<String>()
    val b = arrayOf("Hello", "World")
    val c = arrayOf(1, 4, 9) // arrayOf를 그냥 이용하면 바로 객체로 만들어짐(boxing)
    val d = intArrayOf(1, 4, 9) // 만약 객체가 아닌 변수 그 자체의 배열로 만들고 싶다면 -> 최적화
//    println("c : " + c)
//    println("d : " + d)

//    val size = readLine()!!.toInt()
//    val squares = Array(size) { (it + 1) * (it + 1) } // it는 인덱스번호, 람다함수를 이용하여 배열을 초기화
//    val square = IntArray(size) { (it + 1) * (it + 1) } // 위와의 차이는 박싱 유무(최적화)
//    println("${squares[0]} ${squares[1]} ${squares[2]}")
//    println("${square[0]} ${square[1]} ${square[2]}")
//    for (it in square)
//        println("${it}")

    val e = arrayOf(1, 4, 9) // boxing 함
//    println(e.size)
//    println(e.lastIndex)
//    println("before : " + e[2])
    e[2] = 100                  // string(문자열)에서는 변경이 안됨
//    println("after : " + e[2])

    val squares = arrayOf(1, 4, 9, 16)
    val numbers = squares.copyOf()              // 그대로 가져오긴 함. 근데, 같은 객체를 가리키는 것은 아님. 그래서 서로 수정했을 때, 공유되지 않음
//    println("before squares[2] : ${squares[2]}")
//    println("before numbers[2] : ${numbers[2]}")
    numbers[2] = 100
//    println("after squares[2] : ${squares[2]}")
//    println("after numbers[2] : ${numbers[2]}")

    var f = arrayOf(1, 4, 9) // val은 변경이 안됨. var은 변경 가능
//    println(f)
//    f = arrayOf("hello", "world") -> 배열은 하나의 타입이 초기화되면 다른 타입으로 변경할 수 없다.

    val g = intArrayOf(1, 2, 3) //  g = [1, 2, 3]
    val h = g + 4               //  h = [1, 2, 3, 4] -> 새로운 배열을 만드는 거임 (기존(g)의 배열에서 늘리는 것이 아님)
    val i = g + intArrayOf(5, 6)//  i = [1, 2, 3, 5, 6] -> 새로운 배열을 만드는 거임 (기존(g)의 배열에서 늘리는 것이 아님)

//    println(intArrayOf(1, 2, 3,) == intArrayOf(1, 2, 3)) // false -> 박싱이 되지 않은 서로 다른 배열임. 그래서 서로 다른 객체
//    println(intArrayOf(1, 2, 3,).contentEquals(intArrayOf(1, 2, 3))) // true -> '내용' 자체만 비교함
    val aa = intArrayOf(1, 2, 3)
//    println(aa.isEmpty()) // 빈값이 아니므로 false
//    println(aa.indexOf(4)) // 2가 가지는 인덱스 값을 반환 -> 만약 없다면 -1을 반환
}