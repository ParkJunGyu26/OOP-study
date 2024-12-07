package kau.stream.MID.midterm

/*

    한 줄 짜리 주석 -> '//'
    여러 줄 주석 -> ' /* */ '
    주석 안에 주석 넣기 가능

    식별자 규칙
    - 문자, 숫자, 밑줄 문자(_) 만 포함
    - 숫자로 식별자 시작 못함
    - 밑줄로만 이뤄진 식별자는 이미 예약된 식별자라 사용 안 됨
    - 하드 키워드(val, fun 등)은 식별자로 사용 X

    정수 타입
    - Byte : 1바이트
    - Short : 2바이트
    - Int : 4바이트
    - Long : 8바이트

    정수 리터럴
    - 10진수 : ',' 대신 '_'
    - Long : 뒤에 'L' 붙이기
    - 2진수 : 앞에 '0b' 붙이기
    - 16진수 : 앞에 '0x' 붙이기

    소수 타입(부동소수점)
    - Float :
    - Double : 뒤에 'f' 붙임

    상수
    - Float.MIN_VALUE
    - Double.MAX_VALUE
    - Double.POSITIVE_INFINITY
    - Float.NEGATIVE_INFINITY
    - Double.NaN

    산술 연산의 형 변환 -> 서로 다른 형끼리 연산하면, 표현 값이 더 넓은 형으로 변환
    <타입 계층>
    Byte < Short < Int < Long < Float < Double

    int + byte = int
    int + long = long
    long + double = double
    float + double = double
    float + int = float

    불 타입과 논리 연산
    - and, or는 비교 연산(<. >, ==) 보다 우선순위가 높다
    - &&, ||는 비교 연산(<, >, ==) 보다 우선순위 낮다.
    -> and, or > 비교 연산 > &&, ||

    비교와 동등성
    - 서로 다른 수 타입끼리 비교 연산 가능
    - NaN은 어떤 수와도 같지 않고, 크기 비교를 하더라도 어떤 수보다 크거나 작지 않다.
        Double.NaN == Double.NaN -> False
        Double.NaN != Double.NaN -> True
        Double.NaN <= Double.NaN -> False
        Double.NaN < Double.POSITIVE_INFINITY -> False
        Double.NaN.isNaN() -> True

    문자열
    - 문자열 템플릿 ${변수명}
    - 문자열 안에 이스케이프('\')을 이용해서 특수문자 표현
    - 문자열은 내부 안에 수정 불가능 S[2] = 5 이렇게 안됨 (불변 객체)
    - 문자열과 다른 타입을 합치기 위해선 '+' 또는 toString()을 사용
    - 동등 및 비교
        - 의미 : '==', '!='
        - 객체 : '===', '!=='
        - 사전상 순서 비교 : '>'
    - 로우 문자열
        """ ~~~~ """.trimIndent()
        이스케이프 시퀀스 필요하면 ${} 문자열 템플릿 사용

    배열
    - 빈 배열 만들기 : emptyArray<타입>()
    - 배열 초기화 : arrayOf(~~~~) / Array(사이즈) { 람다함수 }
    - 배열 최적화 : intArrayOf() / charArrayOf()
    - '문자열'은 내부 수정이 안되지만, '배열'은 내부 요소 수정 가능 (가변 객체)
    - size, lastIndex, String[index] 등으로 메서드 가능
    - 배열 타입은 정해지면, 다른 타입 배열로 참조안됨
    - 배열 생성하면, 그 길이는 바꿀 순 없지만 + 연산자로 원소 추가한 새로운 배열 생성 가능
    - 동등 및 비교
        - 의미 : 'contentEquals()
        - 객체 : '==', '!='
    - 함수 : isEmpty(), isNotEmpty(), indexOf() -> 일치하는 요소의 인덱스 반환
    - 배열 대입(복사)
        - 단순히 = 을 이용하면, 배열의 주소를 공유하므로 복사라기 보다는 또 다른 별칭인거임
        - 복사본을 만들기 위해선, 배열.copyOf() 으로 복사본 만듦 -> 서로 다른 주소값
            - 배열.copyOf(숫자) -> 해당 숫자만큼 복사함. 만약에 복사본 대상 보다 숫자가 큰 경우에는 0으로 초기화 됨
 */

fun main() {
    val a: Int = 15 // 불변 변수 val
//    val b = readLine()!!.toInt() // 널 아님 단언 : '!!'
//    val c = readLine()!!.toInt() // readLine()은 문자열을 입력받음. 그리고 그 문자열을 Int로 타입 변환
    val d: String // 초깃값 생략되면, '타입'을 반드시 작성해줘야 함 -> 타입 선언까지 했지만, 초기화안해주면 컴파일 에러

    var e: Int = 10 // 가변 변수 var
    e = 15

    val f: String = "PJK"
//    println("My name is ${f}")
//    println(f.length)
//    println(f.lastIndex)

    val g = emptyArray<String>() // 빈 문자열 배열
    val h = arrayOf("hello", "hhh") // 문자열 배열 초기화
    val i = arrayOf(1, 4, 9) // 정수 배열

    val squares = Array(5) { (it + 1) * (it + 1) }

    val j = charArrayOf('a', 'b', 'c') // 문자 배열 -> but, 박싱 없이 최적화. Char가 아니라, char형임
    val k = intArrayOf(1, 4, 9) // 정수 배열 -> but, 박싱 없이 최적화.

    val aa = k + 5

}