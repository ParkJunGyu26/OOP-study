package kau.inClass

//fun min(a: String, b: String): String {
//    if (a.length > b.length) return b
//    else if (a.length < b.length) return a
//    else {
//        for (i in a.indices) {
//            if (a[i] < b[i]) return a
//            else if (a[i] > b[i]) return b
//        }
//    }
//    return a
//}
//
//fun max(a: String, b: String): String {
//    if (a.length > b.length) return a
//    else if (a.length < b.length) return b
//    else {
//        for (i in a.indices) {
//            if (a[i] < b[i]) return b
//            else if (a[i] < b[i]) return a
//        }
//    }
//    return a
//}
//
//fun fun1(a: String, b: String) {
//    val MAX = max(a, b)
//    val MIN = min(a, b)
//
//    var ans = ""
//
//    val maxLength = MAX.length
//    val minLength = MIN.length
//
//    for (i in maxLength-1 downTo 0) {
//        if (i >= minLength) ans += MAX[i]
//        else {
//            var cnt = 0
//            for (j in minLength-1 downTo  0) {
//                if ((MAX[j] - '0') + (MIN[j] - '0') > 9) cnt = 1
//                else
//            }
//        }
//    }
//}

fun main() {
    val a = readLine()!!
    val b = readLine()!!

}