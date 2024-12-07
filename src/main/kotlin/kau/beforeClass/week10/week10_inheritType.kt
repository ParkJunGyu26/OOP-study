package kau.beforeClass.week10

/*
모든 클래스의 최상위 클래스는 Any 클래스이다.
굳이 Any 클래스를 지정(상속)하지 않더라도 Any 가 최상위 클래스이다.

그렇다면, 어떠한 객체의 변수 타입과 객체 타입이 다를 경우에는 타입 검사를 어떻게 하는 걸까??
예를 든다면,
Vehicle 이라는 변수 타입을 가진 Car 객체와
Vehicle 이라는 변수 타입을 가진 Truck 객체를 생각해보자.
Car 객체는 사람을 태우는 메서드를,
Truck 객체는 짐을 싣는 메서드를 사용하고 싶은데, 이를 어떻게 캐스팅할까??
 */

/*
컴파일 시간에 어떤 변수의 타입을 연산에 맞추지 않으면 에러가 발생한다.
예를 들면, 문자열과 숫자가 섞인 배열에서 곱셈을 할 경우처럼 말이다.
 */

/*
is 연산자는 타입을 검사하는 연산자이다.
이를 활용하면, 스마트 캐스트가 가능하다
특히, when 과 이용하면 더욱 효율적이다
 */

/*
객체에 있는 프로퍼티(var)는 스마트 캐스트가 안된다.
어디선가 타입이 바뀌었을 수 있기 때문이다.(any의 경우) 또는 as 등을 이용한 형변환
그래서 이럴 경우에는 as 와 let 을 적절히 사용하면
타입 캐스팅에 대해 스마트 캐스트가 가능하다
 */
class Holder {
    var o: Any = ""
}

fun main() {
    // array 는 같은 타입의 객체들을 가리키게 된다.
    // 아래의 objects 는 String 과 Int 를 모두 가리키는데, 타입이 최상위인 Any 가 된다.
    val objects = arrayOf("1", 2, "3", 4)

    /*
    < 타입 캐스팅 - is >
    is 연산자는 타입을 검사하는 연산자이다.
    이를 활용하면, 스마트 캐스트가 가능하다
    특히, when 과 이용하면 더욱 효율적이다
    */

    // is 를 활용한다면, 타입 캐스팅을 할 수 있다.
    for (obj in objects) {
        // 스마트 캐스트
        if (obj is Int) {
            println(obj * 2)
        }
    }

    // is 와 when 을 활용한다면, 보다 가독성이 좋아진다
    var sum = 0
    for (obj in objects) {
        when (obj) {
            is Int -> sum += obj
            is String -> sum += obj.toInt()
        }
    }
    println("sum : $sum")

    /*
    < 타입 캐스팅 - as >
    as는 강제 형변환
     */

    val o: Any = 123
    println((o as Int) + 1)
    println((o as? Long) ?: 0 + 1) // o 는 123 이라는 정수 객체인데, Long 이라는 타입과 일치하지 않으므로 에러 발생 -> ? 과 ?: (엘비스 연산자)를 이용
    // as? 로 타입캐스팅 했을 때, 뒤의 타입과 일치하지 않을 경우에는 NULL 로 반환됨을 주의하자

    val holder = Holder()

    // 객체에 있는 프로퍼티는 스마트 캐스트가 적용이 안된다.
    // 바뀔 수 있는 프로퍼티이므로 안됨(var)
//    if ( holder.o is String) {
//        println(holder.o.length)
//    }

    // 타입 캐스팅이 성공한다면 let 의 로직처리 가능
    (holder.o as? String)?.let {
        println(it.length)
    }
}