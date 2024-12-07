package kau.stream.FINAL.week11

import kotlin.math.PI

/*
< 추상 - 주생성자 >
abstract 는 클래스를 인스턴스(객체)에 대해 직접 만들 순 없다.
하지만, 하위 클래스를 이용해서 생성은 가능

다만, 변수의 타입은 추상 클래스를 가질 수 있다.

추상 클래스를 계층화시켜서 시스템 자체를 구조적으로 설계 가능(추상 클래스를 실제 객체화시키는 것은 불가능)

추상 클래스도 생성자가 있긴 하다.
하지만, 추상 클래스의 생성자로 직접 객체를 인스턴스화할 수는 없고,
하위 클래스에서 상위 클래스에 있는 프로퍼티를 초기화할 때 사용한다.(위임 호출)
 */

// 직접 객체화(생성) 할 수는 없음
abstract class Entity(val name: String)

// Person11 의 클래스에는 name 필요 없음. 추상 클래스(Entity)가 파라미터를 가지고 있기 때문
class Person11(name: String, val age: Int) : Entity(name)

/*
< 추상 - 부생성자 >
추상 클래스(상위)는 생성자를 표시하지 않고,
constructor 를 이용해서 추상 클래스를 활용한다.

상위 클래스의 위임 호출(super)
 */

class Person11_1 : Entity {
    val age: Int
    constructor(name: String, age: Int) : super(name) {
        this.age = age
    }

    constructor(firstName: String, familyName: String, age: Int)
        :super("$firstName $familyName") {
            this.age = age
        }
}

/*
< 추상 - 멤버(프로퍼티 & 메서드) >
추상 클래스 안에 있는 프로퍼티, 함수들도 구현할 필요없다.
하위 클래스가 추상 클래스를 상속 받아서 구현해도 괜찮다.

추상 클래스의 추상 멤버를 구현 없이 선언할 수 있다.
추상 멤버들은 반환 타입은 정의가 되어있지만,
세부적인 구현은 없다
-> 구현 : getter, setter 등

어쨋든, 하위 클래스를 만들었으면 상위 클래스를 어떻게 생성할지는 얘기해야된다.
따라서, 상속받을 때 추상 클래스에 대해 생성자를 불러와도 됨.
 */

abstract class Shape {
    abstract val width: Double
    abstract val height: Double
    abstract fun area(): Double
}

// Circle 클래스가 abstract 를 안 붙여도 되는 이유는
// Shape 추상 클래스에 있는 추상 멤버들을 모두 오버라이딩 했기 때문이다.
class Circle(val radius: Double) : Shape() {
    // getter 는 따로 메모리를 사용하진 않음.
    override val width: Double
        get() = radius*2

    override val height: Double
        get() = radius*2

    override fun area(): Double {
        return PI * radius * radius
    }
}

// 추상 클래스의 프로퍼티를 사용하기 정의해줘야 한다. 따라서, val 또는 var 가 필요하다.
// 또한, 추상 클래스의 프로퍼티는 선언이 되었긴하므로 override 를 붙여줘야 한다.
class Rectangle(override val width: Double, override val height: Double) : Shape() {
    // 추상 멤버(프로퍼티)를 메모리를 사용하는 실제 프로퍼티로 정의
    override fun area(): Double {
        return width * height
    }
}

/*
< 추상 - 추상 멤버에 대한 제약 >
1) 추상 멤버(프로퍼티, 메서드)는 초기화할 수 없다. -> 추상 프로퍼티라는 것은 getter(메모리 X) 와 val, var(메모리 할당) 방법을 정하지 않았기 때문에 사용하는 것임
2) 추상 함수에 본문이 없어야 한다. -> 본문이 있다면 굳이 추상화를 할 필요가 없다.
3) 추상 멤버(프로퍼티, 메서드)에는 반환 타입은 명시적으로 정의되어 있어야만 한다. -> 반환 값이 추론이 불가능하므로 타입을 반드시 써줘야 됨.
4) 추상 멤버들은 기본적으로 open 이다. 즉, 상속받을 준비가 된 거임.
 */

fun main() {
    // 주생성자를 사용한 추상 클래스
//    val entity = Entity("charles") -> Entity 는 추상 클래스이므로 직접 객체를 생성해줄 순 없다.
    val entity: Entity = Person11("Charlse", 20) // 변수의 타입을 Entity 할 수는 있다. 그리고 조금 더 구체적인 객체(Person11)를 객체화(인스턴스화)

    // 부생성자를 사용한 추상 클래스
    val entity2: Entity = Person11_1("Charles", "King", 15)

    // 추상클래스의 추상멤버
    val shape: Shape = Circle(1.0)
    println(shape.area())
    val shape2: Shape = Rectangle(1.0, 2.0)
    println(shape2.area())
}