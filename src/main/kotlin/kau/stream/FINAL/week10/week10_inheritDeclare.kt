package kau.stream.FINAL.week10

open class Entity {
    open val name: String get() = ""

    // 상속 받는 클래스만 사용 가능
    protected open fun onStart() {}
    fun start() {
        println("Starting up ...")
        onStart()
    }
}

class Person : Entity() {
    override var name = ""

    override fun onStart() {
        println("It's a car")
    }
}

// 확장은 상속과 다르다

// 자바는 open 안 붙여도 상속 가능
// 코틀린은 open 붙여야만 상속 가능
// 상속받기 위한 지시어 : open
open class Vehicle {
    var currentSpeed = 0

    // 오버라이딩 하기 위해선 open 지시어 필요
    open fun start() {
        println("I'm moving")
    }
}

// 확장 개념으로 재정의한다는 것은 변수의 타입을 따라가서 호출이 된다
fun Vehicle.stop() {
    println("stop vehicle")
}

open class Car : Vehicle() {
    // 상위 클래스의 메서드를 커스텀 : 오버라이드(override) 지시어 필요
    final override fun start() { // 오버라이딩을 하려면 매개변수도 동일해야 한다. 즉, 상위 클래스의 start에 매개변수가 존재한다면, 상속받은 하위 클래스에도 매개변수 필요함
        super.start() // super를 쓸 경우, 상위 클래스를 먼저 호출
        println("I'm riding")
    }
}

// Car 클래스에서는 start 메서드를 상속 못 받도록 해서, override가 불가능
//class Bus : Car() {
//    override fun start() {
//        println("I'm riding a bus")
//    }
//}

fun Car.stop() {
    println("stopped riding")
}

class Boat : Vehicle() {
    override fun start() {
        println("I'm sea")
    }
}

// 생성자 호출로 상속받는거임 -> Vehicle()
// 상위 클래스를 먼저 초기화시키고, 하위 클래스를 초기화시킬 때 상위 클래스를 주입
open class FlyingVehicle : Vehicle() {
    fun takeOff() {
        println("Taking off")
    }

    fun landing() {
        println("Landing")
    }
}

class Aircraft(val seats: Int) : FlyingVehicle()

fun main() {
    /*
    <상속 - 초기화>
    val aircraft = Aircraft(100)
    val vehicle: Vehicle = aircraft // vehicle 변수는 aircraft를 가리키곤 있지만, 타입이 결국엔 Vehicle이다. 따라서, Aircraft 클래스의 메서드를 호출할 수 없다.

    vehicle.start()
    vehicle.stop()
    aircraft.start()
    aircraft.takeOff()
    aircraft.landing()
    aircraft.stop()
    println(aircraft.seats)

    println("-------")
     */

    /*
    <상속 - 오버라이딩은 어떤 타입을 따르는지? 객체냐? 변수 타입이냐?>
    오버라이딩은 변수의 타입 보다 객체의 타입을 우선시한다.(즉, 변수 타입을 따르는 것이 아니라 객체의 타입을 따른다)
    val vehicle2: Vehicle = Car()
    val vehicle3: Vehicle = Boat()
    vehicle2.start()
    vehicle3.start()

    vehicle2.stop()
    vehicle3.stop()
     */


    /*
    <상속 - 확장함수와의 차이는? 객체를 따르는지? 변수 타입을 따르는지?>
    // start가 일반 오버라이딩 함수, stop가 확장 함수라면
    // start는 객체의 타입을 따르고,
    // stop은 변수의 타입을 따른다.
    val car1: Car = Car() // car1 : 변수 타입(Car), 객체 타입(Car)
    val car2: Vehicle = car1 // car2 : 변수 타입(Vehicle), 객체 타입(Car)

    car1.start()
    car1.stop()

    println("-----")

    car2.start()
    car2.stop()
     */

    /*
    <상속 - 오버라이딩 받을 시, 주의사항(시그니처)>
    상위 클래스의 상속을 받을 때는, 매개변수가 동일해야 한다.
    open fun fun1(param: Int) {}

    override fun fun1() {}

    이렇게 되면 상속받은 하위 클래스의 fun1은 컴파일 에러 발생
     */

    /*
    <상속 - 오버라이딩 메서드에 대한 오버라이딩>
    override 는 open 이 생략되어있어서, 하위 클래스에서 언제든 오버라이딩이 가능하다
    만약, 상속을 못받도록. 즉, 오버라이딩이 불가능하게 하기 위해선 override 앞에 final 을 붙이면 된다.
     */

    /*
    <상속 - 프로퍼티의 상속>
    불변 프로퍼티를 가변 프로퍼티로 오버라이딩 가능하다.
    하지만, 반대로 가변 프로퍼티를 불변 프로퍼티로 오버라이딩은 불가능하다.
     */

    /*
    <상속 - protected 접근 제어자>
    상속 체계 안에서는 해당 프로퍼티를 사용할 수 있지만
    상속 체계 밖에서는 읽을 수 없다.

    val person = Person()
    person.start()
    person.onStart() // Cannot access 'onStart': it is protected in 'Person'
     */
}