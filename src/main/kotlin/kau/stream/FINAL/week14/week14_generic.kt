package kau.stream.FINAL.week14

import javax.xml.crypto.Data

/*
< Generic >
- 제네릭 클래스를 직접 만들 수 있다.

< generic 상속 >
 */

open class DataHolder<T>(val data: T)
class TreeNode<T>(data: T) : DataHolder<T>(data) {
    var parent: TreeNode<T>? = null
        private set

    private val _children = arrayListOf<TreeNode<T>>()
    val children: List<TreeNode<T>> get() = _children

    fun addChild(data: T) = TreeNode<T>(data).also {
        _children += it
        it.parent = this
    }

    override fun toString(): String
        = _children.joinToString(prefix = "$data {", postfix = "}" )
}

// vararg 라는 2개 이상의 타입
fun<T> TreeNode<T>.addChildren(vararg data: T) {
    data.forEach {
        addChild(it)
    }
}

// Number 하위 타입만 가능하도록 바운드 - 제네릭 한정
fun<T : Number> TreeNode<T>.averageChildren(): Double {
    var count = 0
    var sum = 0.0

    children.forEach {
        sum += it.data.toDouble()
        count ++
    }
    return sum / count
}

fun main() {
//    val list = ArrayList<Int>()

//    list.add(5)
//    list.add(6)

//    list.forEachIndexed {idx, v -> println("$idx : $v") }

//    val list2 = ArrayList<String>()
//    list2.add("Hello")
//    list2.add("World")

//    list2.forEachIndexed {idx, v -> println("$idx : $v") }

//    val map = HashMap<String, Int>()
//    map["I"] = 1
//    map["V"] = 5
//    map["X"] = 10
//    map["L"] = 50

//    map.forEach {k, v -> println("$k -> $v") }

//    val map2: HashMap<String, Int> = HashMap() // 앞에 타입 선언을 해줬으므로, 생성자에는 필요없음
//    val arr = arrayOf("abc", "def") // arr: Array<String> 으로 되어있는 거임

    val root = TreeNode(1).apply {
//        addChild("World")
//        addChild("!!")
        // 위 아래 둘 다 똑같은 거임
//        addChildren("World", "!!")
        addChildren(2, 3)
    }

//    println(root)
    println(root.averageChildren())
}