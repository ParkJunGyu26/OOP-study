package kau.stream.MID.week3

// inner 클래스는 상위 객체 안에 하위 객체가 존재한다. nested Class와는 조금 다른 형태를 가지고 있어서 비교해보면 좋다
class Person2(val firstName: String, val familyName: String) {
    inner class Possession(val description: String) {
        fun showOwner() = println(fullName())
        fun getOwner() = this@Person2 // 자신을 감싸고 있는 클래스를 반환
    }
    fun fullName() = "$firstName $familyName"
}

fun main() {
    val a = Person2("JunGyu", "Park")
    val wallet = a.Possession("Wallet")
    wallet.showOwner()
    println(wallet.getOwner().fullName())
}