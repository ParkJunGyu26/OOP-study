package kau.stream.FINAL.week12

/*
< eunm class - 세팅 >
여기에 있는 것들을 상수 취급한다.
그리고, 세미 콜론(;) 을 써줘야 상수들의 끝이다. 라는 것을 나타냄 -> 반드시 필요함

enum 내부의 상수는 enum class 의 타입을 가지는(WeekDay1) 객체들이다.
그리고, 그 7개의 객체 한정된 것이다. 더이상 만들 수 없는 것이다. 이 외에는 없는 것이다.
 */

enum class WeekDay1 {
    MONDAY, TUESDAY, WEDNESDAY, THURDAY, FRIDAY, SATURDAY, SUNDAY;

    // fun isWorkDay() = this == WeekDay1.SATURDAY || this == WeekDay1.SUNDAY

//    fun isWorkDay() = when (this) {
//        SATURDAY, SUNDAY -> true
//        else -> false
//    }
}

// 교재처럼 클래스 내부가 아니라, 확장 함수 형태
fun WeekDay1.isWorkDay() = this == WeekDay1.SUNDAY || this == WeekDay1.SATURDAY

/*
< enum class - 꿀팁1 >
when 과 함께 사용하면 편리하다
 */

enum class Direction {
    NORTH, SOUTH, WEST, EAST;

//    fun rotateClockwise() = when (this) {
//        Direction.WEST -> Direction.NORTH
//        Direction.NORTH -> Direction.EAST
//        Direction.SOUTH -> Direction.WEST
//        Direction.EAST -> Direction.SOUTH
//    }
}

//fun rotateClockwise(direction: Direction) = when (direction) {
//    Direction.WEST -> Direction.NORTH
//    Direction.NORTH -> Direction.EAST
//    Direction.SOUTH -> Direction.WEST
//    Direction.EAST -> Direction.SOUTH
//}

fun Direction.rotateClockwise() = when (this) {
    Direction.WEST -> Direction.NORTH
    Direction.NORTH -> Direction.EAST
    Direction.SOUTH -> Direction.WEST
    Direction.EAST -> Direction.SOUTH
}

/*
< enum class - 꿀팁2 >
import 를 활용하면, 조금 더 짧아진다.

import kau.beforeClass.week12.Direction2.*
 */

enum class Direction2 {
    NORTH, SOUTH, WEST, EAST;

    fun rotateClockwise() = when (this) {
        WEST -> NORTH
        NORTH -> EAST
        EAST -> SOUTH
        SOUTH -> WEST
    }
}

/*
< enum class - 커스텀 멤버 >
주의할 점은 상수를 모두 선언한 뒤, '세미콜론'을 반드시 붙여줘야 한다.

name 이란 해당 enum class 내부에 있는 상수들을
string 으로 바꾼 것을 뜻한다.

 */

enum class WeekDay2 { // 세미콜론 반드시 써줘야 됨
    MONDAY, TUESDAY, WEDNESDAY, THURDAY, FRIDAY, SATURDAY, SUNDAY;

    val lowerCaseName get() = name.lowercase()
    fun isWorkDay() = this == SATURDAY || this == SUNDAY
}

/*
< enum class - 생성자 >
만약 enum class 가 생성자가 있을 경우에는
각 상수들은 생성자 호출이 반드시 필요하다

 */

enum class RainbowColor(val isCold: Boolean) { // VIOLET 이후 멤버를 선언하기 위해선 ';' 세미콜론이 반드시!!!
    RED(false), ORANGE(false), YELLOW(false),
    GREEN(true), BLUE(true), INDIGO(true), VIOLET(true);

    val isWarm get() = !isCold
}

/*
< enum class - 공통 멤버 >
1) name : 상수 이름을 String 타입으로 변환 -> valueOf(), values()
2) ordinal : 상수의 순번(0번 부터 시작) -> 숫자가 나오므로 서로 대소 비교 연산이 가능하다

 */

/*
< enum class - name 의 확장 >
1) values() : enum class 의 상수들의 모은 배열
2) valueOf() : enum class 에 해당 문자열의 존재 여부
 */

fun main() {
    // Enum 클래스 사용 방법
//    println(WeekDay1.MONDAY.isWorkDay())
//    println(WeekDay1.SUNDAY.isWorkDay())

    // Enum 클래스를 when 을 활용한
//    val dir = Direction.EAST
//    println(rotateClockwise(dir))

    // 확장함수를 이용해서 조금 더 객체지향적인
//    val dir = Direction.EAST
//    println(dir.rotateClockwise())

    // import 를 활용하면, 앞에 클래스를 붙여주지 않아도 사용 가능하다.
//    println(MONDAY.isWorkDay())
//    println(WEDNESDAY.lowerCaseName)

    // enum 클래스의 생성자 활용
//    println(RainbowColor.BLUE.isWarm)
//    println(RainbowColor.RED.isCold)

    // enum 클래스의 공통 멤버 (name, ordinal)
//    println(RainbowColor.RED.name)
//    println(RainbowColor.VIOLET.ordinal)

    // enum 클래스의 ordinal 비교
//    println(RainbowColor.RED.ordinal < RainbowColor.VIOLET.ordinal)

    // name 의 valueOf, values 의 활용 방법
    val rainbowColors = RainbowColor.values()
    fun RainbowColor.nextColor() = rainbowColors[(ordinal + 1) % rainbowColors.size]

    println(RainbowColor.VIOLET.nextColor())
}