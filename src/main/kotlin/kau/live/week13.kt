package kau.live

abstract class Character(var hp: Int = 100, val name: String)

abstract class Sword<T: Character>(val owner: T) {
    abstract fun swing()
    abstract fun block()
}

class Knight() : Character(name = "Knight", hp = 100) {}

class Magician(var mp: Int = 100) : Character(name = "Magician", hp = 50) {}

class BigSword(owner: Knight) : Sword<Knight>(owner) {
    override fun swing() {
        println("슈룽")
    }

    override fun block() {
        println("챙")
        owner.hp -= 10
    }
}

class MagicSword(owner: Magician) : Sword<Magician>(owner) {
    override fun swing() {
        println("숑")
    }

    override fun block() {
        println("칭")
        owner.hp -= 10
        owner.mp -= 10
    }
}

fun main() {
    // 람다는 인덱스를 파라미터로 받아옴(it)
    // 모든 Any에는 toString이란는 메서드가 있음 -> open으로 상속 받는 거 가능
    val arr: Array<Any> = Array(3) {it}
}