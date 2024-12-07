package kau.stream.MID.week2

// 6번 실습 -> if 문 기초
// fun max(a: Int, b: Int): Int = if( a >= b ) a else b
fun max(a: Int, b: Int): Int {
    if (a >= b) return a
    return b
    // return if (a >= b) a else b
}

// 6-3번 실습 -> if문과 함수의 return 응용
fun renamePackage(fullName: String, newName: String): String {
    val i = fullName.lastIndexOf(".")

    // substring(0, i+1)는 0부터 i번째 인덱스까지만 반환해줌
    val prefix = if (i >= 0) fullName.substring(0, i+1) else return newName
    return prefix + newName
}

// 6번 실습 -> if문 기초
fun main() {
//    val a = readLine()!!.toInt()
//    val b = readLine()!!.toInt()
//
//    println("max value is ${max(a, b)}")

    // 6-2번 실습 -> if문 응용
//    val s = readLine()!!
//    val i = s.indexOf("/") // s에서 '/'를 찾으면 인덱스 번호를 저장

    // 변수 result는 if 문에 따라서 결과가 다르게 저장됨
//    val result = if (i >= 0) {
//        // substring은 0부터 i번째가 아니라 0부터 i-1번째 까지임!!! 중요
//        val a = s.substring(0, i).toInt()
//        val b = s.substring(i+1).toInt()
//        (a / b).toString()
//    } else "Not a division"
//
//    println("result : $result")

    // 6-3번 실습 -> if문과 함수의 return 응용
//    val f = readLine()!!
//    val r = readLine()!!
//    println("rename package result : ${renamePackage(f, r)}")
}