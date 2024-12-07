package kau.stream.MID.week3

// 자바와 코틀린의 큰 차이점이 바로 null을 예방할 수 있는 것이 있는 것이다.

// 파라미터 s는 절대로 Null 은 올 수 없다.
fun isLetterString1(s: String): Boolean {
    if (s.isEmpty()) return false // isEmpty는 null이 아닌 그냥 공백
    for (ch in s) {
        if (!ch.isLetter()) return false
    }
    return true
}

// 파라미터 s는 null 을 받을 수 있다.(nullable)
fun isBooleanString(s: String?) = s == "true" || s == "false"

fun isLetterString2(s: String?): Boolean {
    if (s == null) return false

    if (s.isEmpty()) return false

    for (ch in s) {
        if (!ch.isLetter()) return false
    }
    return true
}

fun describeNumber(n: Int?)
    = when (n) {
        null -> "null" // null 에 대한 예방이 필요함
        // 스마트 캐스트로 아래 지시어들은 null 이 아님을 알 수 있어서 가능
        in 0 .. 10 -> "small"
        in 11 .. 100 -> "large"
        else -> "out of range"
    }

fun isSingleChar(s: String?) = s != null && s.length == 1

//class MyString {
//    var str: String?
//
//    fun isStrEmpty(): Boolean {
//        if (str == null) return true      -> null 처리를 한 것처럼 보이지만
//                                          -> 중간에 다른 비동기처리로 인해 str 이 다시 null 이 될 수 있음(var 이기 때문)
//        if (str.length == 0) return true  -> 그래서 str.length == 0 에서 스마트 캐스트가 불가능
//        else return false                 -> 이를 해결하기 위해선 로컬 변수 val 을 이용해서 하면 스마트 캐스트가 가능하다
//    }
//}

class MyString2 {
    var str: String? = null

    fun isStrEmpty(): Boolean {
        val a: String? = str
        if (a == null) return true

        if (a.length == 0) return true
        else return false
    }
}

// 읽는 것이 nullable 이므로, 이에 대한 타입도 nullable 해야되므로 ? 연산자 꼭 붙이기
fun readInt(): Int? = readLine()?.toInt()

// 엘비스 연산자
fun sayHello(name: String?){
    println("Hello ${name ?: "Unknown"}")
}

class Name(val firstName: String, val familyName: String)

class Person11(val name: Name?) {
    fun describe(): String {
        val currentName = name ?: return "Unknown"
        return "${currentName.firstName} ${currentName.familyName}"
    }
}

fun main() {
//    println(isLetterString1("abc")) // true
//    println(isLetterString1("")) // false(공백)
//    println(isLetterString1("123")) // false(글자가 아님)
//    println(isLetterString1(null)) // 애초에 컴파일 단계에서 null을 받으므로 에러
//    println("---")
//
//    println(isBooleanString(null)) // false
//    println(isBooleanString("true")) // true

//    val s: String = "abc"
//    val ss: String? = s // s는 nullable 이 아니지만, ss는 nullable 이라서 좋지 않은 코드
//    if (s == null) return
//    val ss: String = s // 위의 null에 대해 예방할 수 있어서 문맥상 ss 는 String?이 아닌 String이 확실함을 알 수 있다.

//    println(describeNumber(null))
//    println(isSingleChar("a"))

    // 널 아님 단언 연산자(!!) 를 자주 쓰면 감점?! -> 확실하지 않을 때는 쓰지마라!!!!!!
//    val s = readLine()!!.toInt() // readLine()은 null을 반환할 수 있다.....
    // 안전한 호출 연산자
//    val ss: Int? = readLine()?.toInt() // ss은 nullable -> 프로그래밍 제대로 하는 거임
    // 엘비스 연산자
//    val sss: Int = readLine()?.toInt() ?: 0 // sss은 not nullable 임. 만약 null 일 경우에는 뒤에 있는 값으로 바꿔주기 때문이다. 그래서 타입도 당연히 not null
//    sayHello("Jun")
//    sayHello(null) -> 엘비스 연산자
    val p = Person11(null)
    println( p.describe())
    val pp = Person11(Name("JunGyu", "Park"))
    println( pp.describe())
}