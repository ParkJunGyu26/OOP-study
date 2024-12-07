package kau.beforeClass.MID.week7

// run-let-with 유사성
// apply-also 유사성
// run & let & apply 정도 잘 사용하면 좋다.
// 개념 자체는 중요!! 다른 사람 코드 읽을 수 있또록


class Address {
    var city: String = ""
    var street: String = ""
    var house: String = ""
    fun post(message: String): String =
        "Message for ($city, $street, $house): $message"
}

class Address1(val city: String, val street: String, val house: String) {
    fun asText() = "$city, $street, $house"
}

fun readInt() = try {
    readLine()?.toInt()
} catch (e: NumberFormatException) {
    null
}

fun main() {
    // run 영역 함수 -> 클래스().run
    // 객체를 초기화하는 루틴에서 많이 사용됨(또는 반환)
    // 확장함수처럼 사용됨
    // 하나의 모듈처럼 사용될 수 있음
    val msg1 = Address().run {
        city = "London"
        street = "Baker Street"
        house = "221b"
        post("Hello!")
    }

    /* run을 안썼다면?
    val addr = Address()
    addr.city = "London"
    addr.street = "Baker Street"
    addr.house = "221b"
    val msg = addr.post("Hello")
     */

    // with 영역 함수 -> with(클래스())
    // run과 동일한 의미
    // with의 파라미터로 클래스를 던져줌
    val msg2 = with(Address()) {
        city = "London"
        street = "Baker Street"
        house = "221b"
        post("Hello!")
    }

//    val city = readLine() ?: return
//    val street = readLine() ?: return
//    val house = readLine() ?: return
//    val address = Address1(city, street, house)

    // 위의 라인 바이 라인을 하나의 모듈로 run을 통해 완성
//    val address1 = run() {
//        val city1 = readLine() ?: return
//        val street1 = readLine() ?: return
//        val house1 = readLine() ?: return
//        Address1(city1, street1, house1)
//    }

    // 영역함수 let
    // run과 유사함
    // run은 this를 넘겻다면, let은 파라미터를 넘김
    // 초기화하는 용도 보다는 널 안정성 처리하기 위해 많이 사용됨
    val msg3 = Address().let { addr ->
        addr.city = "L"
        addr.street = "B"
        addr.house = "2"
        addr.post("H!")
    }

    // 영역함수 apply
    // run과 유사한데, 마지막에 반환값이 없어도 됨
    val msg4 = Address().apply {
        city = "L"
        street = "B"
        house = "@"
    }.post("Hello!")

    // 영역함수 also
    // apply와 유사한데, 파라미터로!
    val msg5 = Address().also {
        it.city = "L"
        it.street = "B"
        it.house = "@"
    }.post("Hello!")

    val arr = intArrayOf(3, 9, 7, 6, 4)
//    val num = readInt()

    // result1과 result2는 동일한 로직임
//    val result1 = if ( num != null ) arr.getOrNull(num) else null
//    val result2 = num?.let { arr.getOrNull(it) }
}