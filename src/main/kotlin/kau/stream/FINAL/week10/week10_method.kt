package kau.stream.FINAL.week10

/*
최상위 클래스는 Any
여기에는 3가지 메서드가 있다.
1) equals
2) hashCode
3) toString
 */

/*
1) equals

조건 : 구조적 동등성(참조 동등성(같은 객체냐), 구조 동등성(다른 객체지만, 개념적으로 같은지))
-> 참조 동등성('===') : 비교하는 두 대상이 모두 같은 '객체'인지
-> 구조 동등성('==') : 비교하는 두 대상이 개념적으로 같은지 -> equals 를 오버라이딩(커스텀)
 */

class Address(
    val city: String,
    val street: String,
    val house: String
) {
    // '=='에 대해 커스텀(오버라이딩)
    override fun equals(other: Any?): Boolean {
        if (other !is Address) return false

        // 이후에 other 은 Address 가 확정(스마트 캐스트)
        if (city == other.city && street == other.street && house == other.house) return true
        return false
    }

    // 31 을 곱하는 것은 난수와 가까워짐(재정의)
    override fun hashCode(): Int {
        var code = city.hashCode()
        code = 31 * code + street.hashCode()
        code = 31 * code + house.hashCode()
        return code
    }

    override fun toString(): String {
        return "$city, $street, $house"
    }
}

/*
2) hashCode

조건1) : 구조적 동등한 객체는 같은 hashCode
조건2) : hashCode 는 난수 값과 동일
 */

/*
3) toString

따로 조건은 없음.
다만, 커스텀(오버라이딩) 안 해주면 의미없는 문자열
kau.beforeClass.week10.Address@6f9cf654
이렇게 나옴

사람이 읽기 좋은 형태로 나타나게 해줌

 */

fun main() {
    val addr1 = Address("Seoul", "Mapodae-ro", "5")
    val addr2 = Address("Seoul", "Mapodae-ro", "5")

    // equals
//    println(addr1 == addr2) // 구조적으로 같은지? (같은 '객체'인지) -> 오버라이딩을 해서 커스텀했다면 true
//    println(addr1 === addr2) // 참조자가 동일한지? -> 서로 다른 객체이므로 false

    // hashCode -> 커스텀(오버라이딩)해주면 구조적으로 동등하면 동일한 해시코드
//    println(addr1.hashCode())
//    println(addr2.hashCode())
//    val set = HashSet<Address>()
//    set.add(addr1)
//    println(addr2 in set) // 구조적으로 addr2는 addr1과 동일하다. 따라서, set 안에 addr2도 있어야 하는데...?! -> false(두 객체의 해시코드가 다르기 때문)

    // toString -> 커스텀(오버라이딩)안하면, 해시코드가 나옴(의미없는 문자열)
    // 커스텀하면, 보기 좋게 표현 가능
    println(addr1)
    println(addr2)
}