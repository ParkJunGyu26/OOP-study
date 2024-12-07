package kau.stream.FINAL.week12

/*
< 봉인 클래스 - ENUM >
ENUM 이란 특정 개념에 대해 분류를 할 때 사용
ex) 월 ~ 일 / 동서남북 , ...
 */

enum class Result_1 {
    SUCCESS, ERROR // 성공과 실패 여부에 따라 다른 값을 반환해주는 것이 기대되는데
}

/*
< 봉인 클래스 - ENUM class 상속 >
SUCCESS (성공)일 때, 값을 담아서 보내고 싶다.
그렇다면, enum class 를 상속하자
 */

// 그런데, 해당 추상 클래스는 하위 클래스로 Success, Error 외에 더 올 수 있다.
// 따라서, when 을 사용한다면, else 를 통해 약간의 예외처리 필요하다.
abstract class Result_2 {
    class Success(val value: Any) : Result_2() {
//        fun showResult() {
//            println(value)
//        }
    }

    class Error(val message: String) : Result_2() {
        fun throwException() {
            throw Exception(message)
        }
    }
}

/*
< 봉인된 클래스 - 목적 >
1) 하위 클래스를 더 만들지 못하도록 함.
상속을 금지하는 것이 아니라 봉인하는 것이다.
그 클래스의 내부에 정의한 클래스만 상속할 수 있도록 하라

sealed class 는 상속을 할 수 있되,
이걸 상속하는 클래스는 하위 클래스만 있다. (Success, Error) 만 있다고 확정지어주는 거임
 */

// 하위 클래스에 더 클래스를 만들지못하도록 봉인
// 즉, Result12_1 클래스는 하위에 두 클래스밖에 없다고 확정지음
sealed class Result_3 {
    class Success(val value: Any) : Result_3() {
        fun showResult() {
            println(value)
        }
    }

    class Error(val message: String) : Result_3() {
        fun throwException() {
            throw Exception(message)
        }
    }
}

fun runComputation() : Result_1 {
    val a = readLine()?.toIntOrNull() ?: return Result_1.ERROR
    val b = readLine()?.toIntOrNull() ?: return Result_1.ERROR

    return Result_1.SUCCESS
}

fun runComputation2() : Result_2 {
    val a = readLine()?.toIntOrNull() ?: return Result_2.Error("첫 번째 인자 에러")
    val b = readLine()?.toIntOrNull() ?: return Result_2.Error("두 번째 인자 에러")

    return Result_2.Success(a + b)
}

fun runComputation3() : Result_3 {
    val a = readLine()?.toIntOrNull() ?: return Result_3.Error("첫 번째 인자 에러")
    val b = readLine()?.toIntOrNull() ?: return Result_3.Error("두 번째 인자 에러")

    return Result_3.Success(a + b)
}

fun main() {
    // RESULT 타입을 반환하고, 그 이후에 로직을 처리해야되는 불편함이 있음
    println(when (runComputation()) {
        Result_1.SUCCESS -> "Completed Successfully"
        Result_1.ERROR -> "Error!"
    })

    // RESULT 타입을 추상을 이용해서, 원하는 값이 나오도록 해보자
    // 그런데, 해당 enum class 를 상속받으면, 하위 클래스가 언제든 들어올 수 있으므로
    // 이에 대한 else 예외 처리를 해야된다.
    println(when (val result = runComputation2()) {
        is Result_2.Success -> "Completed Successfully: ${result.value}"
        is Result_2.Error -> "Error! : ${result.message}"
        else -> return
    })

    // 아래는 sealed class 를 상속받은 예시이다.
    // 따로 else 로 예외처리를 안해줘도 된다.
    println(when (val result = runComputation3()) {
        is Result_3.Success -> "Completed Successfully: ${result.value}"
        is Result_3.Error -> "Error! : ${result.message}"
    })
}