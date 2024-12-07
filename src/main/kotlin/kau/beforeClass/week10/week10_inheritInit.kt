package kau.beforeClass.week10

/*
< 상속 - 생성 순서 >
생성자는 상위 클래스가 모두 생성이 되어야 하위 클래스가 만들어진다.
즉, 최상위 클래스가 먼저 생성
 */

open class Vehicle2() {
    init {
        println("Vehicle 초기화")
    }
}

open class Car2 : Vehicle2() {
    init {
        println("Car 초기화")
    }
}

open class Truck2 : Car2() {
    init {
        println("Truck 초기화")
    }
}

/*
< 상속 - 파라미터(주생성자) >
하위 클래스가 파라미터로 받은 것들을 상속해주는 클래스의 생성자로 보내주면 된다.
따라서, 하위 클래스에서는 굳이 상위 클래스의 프로퍼티를 정의할 필요가 없다(val, var 등)
-> 하위 클래스의 생성자에서 상위 클래스 생성자로 파라미터 넘겨줌
 */

open class Person2(val name: String, val age: Int)

class Student2(name: String, age: Int, val university: String) : Person2(name, age)

/*
< 상속 - 부생성자 >
주생성자는 상속받는 클래스에 생성자를 해줘야한다.
하지만, 부생성자 예약어(constructor)는 상속받는 클래스의 생성자가 필요없다.
다만, super 예약어가 필요하다
 */

open class Student2_1 : Person2 {
    val university: String
    constructor(name: String, age: Int, university: String) : super(name, age) {
        this.university = university
    }
}

/*
< 상속 - 주생성자와 부생성자 혼용 >
주생성자와 부생성자가 있을 때는, constructor 에서 super 호출이 안된다.
this 를 통해서 호출해야 된다.
즉, 주생성자가 있을 때는 부생성자는 바로 상위 클래스의 생성자를 호출할 수 없다.
부생성자는 주생성자를 통해서만 상위 클래스 생성자를 호출할 수 있다.
 */

/*
< 상속 - 상위 클래스의 여러 생성자 활용법 >
주생성자를 사용해선 안된다.
주생성자가 존재하는 순간, 상위 클래스에 있는 생성자는 주생성자를 통해서만 생성할 수 있따.
상위 클래스의 여러 생성자를 다 활용하고 싶다면, 부생성자만을 활용해야한다.
즉, "주생성자 없이" 부생성자 여러 개로, 서로 다른 상위 클래스 생성자를 통해서 상위 클래스를 초기화할 수 있다.
 */

open class Person2_1(val name: String, val age: Int) {
    constructor(firstName: String, familyName: String, age: Int)
        : this("$firstName $familyName", age)
}

open class Student2_2 : Person2_1 {
    val university: String

    constructor(name: String, age: Int, university: String) : super(name, age) {
        this.university = university
    }

    constructor(firstName: String, familyName: String, age: Int, university: String)
            : super(firstName, familyName, age) {
                this.university = university
            }
}

/*
< 상속 - this 누출 >
하위 클래스가 생성되지 않았는데, 오버라이딩된 함수를 호출한다면
null이 반환된다...

val student2 = Student2_3("CHAR", 23, "KAU")
CHAR, 23 : (null) 으로 출력되는 것을 확인할 수 있다.

Student2_3에 해당하는 객체이기 때문에 상위 클래스에서 init할 때, 하위 클래스의 showInfo가 호출된다.
 */

open class Person2_2(val name: String, val age: Int) {
    open fun showInfo() {
        println("$name, $age")
    }

    init {
        showInfo()
    }
}

class Student2_3(name: String, age: Int, val university: String) : Person2_2(name, age) {
    override fun showInfo() {
        println("$name, $age : ($university)")
    }
}

fun main() {
    // <상속 - 생성 순서>
//    val truck = Truck2()

    // <상속 - 하위 클래스 파라미터를 상위 클래스 파라미터로 전달>
//    val student = Student2("Hello", 23, "KAU")
//    println(student.name)
//    println(student.age)
//    println(student.university)

    val student2 = Student2_3("CHAR", 23, "KAU")
}