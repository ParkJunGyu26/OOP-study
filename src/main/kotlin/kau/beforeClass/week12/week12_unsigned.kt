package kau.beforeClass.week12

/*
< 부호 없는 정수 타입 - unsigned >

사용하기 위해서 마지막에 'u'를 붙여줘야 한다.
붙여주지 않으면, 음수를 허용하는 것이다.
명시적으로 'u'를 붙여야 unsigned 를 지칭하는 것이다.
 */

/*
< 부호 없는 정수 타입 - 연산 >

일반 타입과 unsigned 타입 간의 연산은 불가능하다.
ex) 1 + 2u 는 안된다는 의미

즉, signed 는 signed 끼리, unsigned 는 unsigned 끼리만 연산 가능하다.

만약 서로 다른 타입끼리 연산하고 싶다면, unsigned 와 signed 둘 타입 중 하나로 형변환시켜야 한다.
 */

fun main() {
    val uByte: UByte = 1u
    val uShort: UShort = 1u
    val uInt: UInt = 1u
    val uLong: ULong = 1uL

    println(1u + 1u)
    println(1 + 1)
    println(1 + 2u.toInt())
    println(1.toUInt() + 2u)

    val s: Int = -3
    println(s.toUInt() + 2u) // 만약에 음수를 UInt 로 변환한다면 오버플로우 발생
}