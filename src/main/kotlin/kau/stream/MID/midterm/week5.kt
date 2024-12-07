package kau.stream.MID.midterm

/*

    고차함수
    - 함수의 파라미터로 함수가 적용됨
    - 배열 조건을 검사하는 함수 등으로 사용됨
    - 코드 재사용성 증가
    ex) aggregate(arr: IntArray, op: (Int, Int) -> Int)
        - 함수 op는 두 개의 Int 파라미터를 받고, 그 함수의 반환값은 Int이다.
        - 반환 값 앞에는 '->'를 사용
        - 반환 값이 없을 경우에는 'Unit'을 사용하는데, 이는 반드시 명시해줘야 한다.

    람다함수
    - 이름 없는 함수
    - 람다 함수는 고차 함수에 쉽게 전달할 수 있어 코드 간결화
    - 단일 매개변수로 it을 사용
    - 람다함수 앞에서 괄호를 닫고, 그 뒤에 람다함수를 쓸 수 있음
    val total = aggregate(array, 0) { res, elm -> res + elm }
    - 사용하지 않는 파라미터는 '_'로 지정

    익명 함수
    - 람다 함수와 유사하지만, fun 키워드 사용

    이미 존재하는 함수를 파라미터로(고차함수)
    - aggregate(array) { res, elm -> add(res, elm) }
    - aggregate(array, ::add)

    확장 함수
    - 이미 존재하는 클래스의 새로운 멤버를 확장
    ex) fun String.truncate(maxLength: Int): String { }
    - 기존 클래스의 비공개 멤버에는 접근 불가능
    - 기존 멤버와 동일한 멤버는 기존 멤버에 우선 순위 부여
    - 타 패키지에 정의된 것은 import 필요(import util.truncate) 처럼 패키지 위치와 함수 명을 선언

    확장 프로퍼티
    - 뒷받침 필드가 불가능해서, 명시적인 getter를 정의하는 방법으로만 프로퍼티 정의

    동반 확장
    - 동반 객체도 확장이 가능하다
    - 동반 객체에 대한 확장 프로퍼티도 가능하다
    - 다만, 동반 객체가 존재하는 경우에만 동반 객체 확장이 가능하다
    ex) class Person(val firstName: String, val familyName: String) { companion object }
    - Any는 동반 객체가 없기 때문에 동반 확장 X

    영역 함수
    - run, let, with, apply, also
    - 람다함수로 모듈화 하여 분리

    val msg = Address().run {
        (this.)city = "O"
        street = "~"
    }

    val msg = with(Address()) {
        (this.)city = "0"
        ~~~
    }

    val msg = Address().let {
        it.city = ~
    }
    - let의 경우에 null 안전성 처리가 가능하다
    val arg = index?.let { ~~ }
    - index가 null이면 let 뒤에 호출

    apply - run, also - let에 대응되지만, 최종적으로 수신 객체를 반환
    Address().apply { }.method()
    Address().also { it. ~~~ }.method()

 */