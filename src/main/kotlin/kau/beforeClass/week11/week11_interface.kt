package kau.beforeClass.week11

/*
< 인터페이스 >
인터페이스란 추상 클래스의 일종이다.
하지만, 추상 클래스보다 제약이 많은 것이 인터페이스이다.

인터페이스의 목적은 클래스를 만들 때, 여러 가지의 상속을 받기 위함이다.
원래는 클래스마다 상속을 받기 위해선 하나의 클래스만 받을 수 있다.
즉, 하나의 클래스는 하나의 클래스만 상속받을 수 있다. (하나의 클래스는 하나의 상위 클래스만을 가질 수 있다)
왜냐하면 다중 상속에 대한 위험성이 있기 때문이다. 여러 개의 클래스를 상속받을 수 없다.

하지만, 종종 여러 개의 클래스를 상속받아야 할 수도 있다.
예를 들면, 자동차는 Vehicle 과 Machine 클래스 두 개가 필요할 수도 있기 때문이다.

여러 개의 개념을 상위 클래스로 갖고 싶다면
하나만 클래스로 갖고, 하나만 인터페이스를 사용할 수 있다.
 */

// 인터페이스 안에 있는 것은 초기화할 수 없다(불가능)
// 인터페이스는 초기화나 구현이 애초에 하지 않는 것이 default
// 즉, abstract 가 생략되어 있는 거다.
interface Vehicle11 {
    abstract val currentSpeed: Double
    fun start()
    fun stop()
}

/*
< 인터페이스 - 상속 >
인터페이스는 인터페이스끼리만 상속할 수 있다.
상위에 클래스가 있다면 안된다.

인터페이스는 생성자가 존재하지 않는다.
인터페이스를 상속할 때는 괄호(생성자)가 안붙어 있다.
 */

class Car11 : Vehicle11, Vehicle11_1 {
    // 속도는 바꿀 수 있어야 하므로 var
    // 하지만, 외부에선 바꿀 수 없도록 private set
    override var currentSpeed = 0.0
        private set

    override fun start() {
        println("Start riding")
        currentSpeed = 50.0
    }

    override fun stop() {
        println("Stop riding")
        currentSpeed = 0.0
    }
}

/*
< 인터페이스 - 추상 클래스보다 저 엄격 >
인터페이스는 abstract 가 기본이다. 즉, 선언은 했지만 초기화는 되어 있지 않음
하지만, getter 등으로 구현하는 것은 가능하다.

인터페이스도 추상 멤버가 아닌 것을 가질 수 있다.
즉, 인터페이스 내에서 구현할 수 있다.

그러면, 상속받은 클래스에서는
인터페이스의 추상 멤버가 아닌 것을 굳이 구현해주지 않아도 된다.
즉, 오버라이딩(커스텀)을 할 필요가 없다.
 */

// 인터페이스가 abstract 라서 구현하지 않는 것이 디폴트
// 하지만, getter 등 구현을 직접할 수도 있긴 함
interface Vehicle11_1 {
    val currentSpeed: Double
    val isMoving get() = currentSpeed != 0.0 // isMoving 은 자신의 메모리를 가지지 않음(상태 정의는 안됨)
    fun start()
    fun stop()
    fun report() = println(if(isMoving) "Moving at $currentSpeed" else "Still")
}

/*
< 인터페이스 - 프로퍼티에 메모리 할당 불가능 >
상태 정의가 불가능하다 -> 안에 구체적으로 정의된 메모리를 가지지 않는다.
즉, 프로퍼티를 가질 순 있다. 하지만 그것은 메모리를 할당받아선 안된다.(getter 만 된다는 거군)
당연히, by lazy, 뒷받침 필드도 안된다.
인터페이스의 추상 멤버(프로퍼티)는 메모리 가져선 안된다.

상태 정의 불가능 == 프로퍼티의 메모리에 할당할 수 없다.
 */

/*
< 인터페이스 - 다중 상속 >
1) 메모리가 할당된 프로퍼티를 다중 상속 허용한다면? -> 상속받는 입장에서 모호해진다.
즉, Car 의 speed 와 Aircraft 의 speed 가 서로 다른 상황에서 어떤 것을 상속받는지가 애매해짐. 따라서, 서로 메모리 할당 X
-> 그래서 상위 클래스의 메모리를 가지게 된다면 똑같은 프로퍼티가 두 개 이상 존재할 수 있으므로 메모리 할당 금지

2) 만약 여러 인터페이스 동일한 메서드가 구현이 되어있다면 어떤 것을 사용할 것인가?
인터페이스를 다중 상속했을 때, 그 상속해준 인터페이스에 구현이 있다면
상속받은 하위 클래스에서 해당 구현체를 override 해줘야만 한다.

즉, A 인터페이스의 move 메서드는 선언이, B 인터페이스의 move 메서드가 모두 구현되어있을 때
이 두 인터페이스를 상속받은 C 클래스에서는 move 메서드를 반드시 override 해줘야 모호함이 사라진다
또는 super 를 사용한다면 move 메서드는 B 인터페이스에서만 구현되었으므로
B 인터페이스의 move 메서드가 호출

3) 만약 두 인터페이스의 메서드가 둘 다 구현되어있다면

super<T> 으로 모호함을 해소
만약 A의 move 를 사용하기 위해선 super<A>.move()
만약 B의 move 를 사용하기 위해선 super<B>.move()
 */

interface Car {
    fun ride()
}

interface Aircraft {
    fun fly()
}

interface Ship {
    fun sail()
}

interface FlyingCar : Car, Aircraft

class Transformer : FlyingCar, Ship {
    override fun ride() {
        println("I'm riding")
    }

    override fun fly() {
        println("I'm flying")
    }

    override fun sail() {
        println("I'm sailing")
    }

}

fun main() {
    // v 의 타입은 Vehicle11 로, 인터페이스 타입이지만 실제로 Car 에 구현된 것들이 있음
//    val v : Vehicle11 = Car11()
//    v.start()
//    println(v.currentSpeed)
//    v.stop()
//    println(v.currentSpeed)

    // 인터페이스는 추상 멤버만 있는 것이 아니다. 구현체가 들어갈 수도 있다.
//    val v2 : Vehicle11_1 = Car11()
//    v2.start()
//    v2.report()
//    v2.stop()
//    v2.report()

    // 인터페이스의 다중 상속
    val t = Transformer()
    t.ride()
    t.fly()
    t.sail()

    val s: Ship = t
    s.sail()

    val fc: FlyingCar = t
    fc.fly()
    fc.ride()
}