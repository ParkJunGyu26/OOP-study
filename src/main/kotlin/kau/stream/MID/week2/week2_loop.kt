package kau.stream.MID.week2

fun countLetters(text: String): IntArray {
    val counts = IntArray('z' - 'a' + 1)

    for (char in text) {
        val charLower = char.lowercaseChar()
        if (charLower !in 'a' .. 'z') continue
        counts[charLower - 'a']++
    }
    return counts
}

fun indexOf(subarray: IntArray, array: IntArray): Int {
    outerLoop@ for (i in array.indices) {
        for (j in subarray.indices) {
            if (array[i+j] != subarray[j]) continue@outerLoop
        }
        return i
    }
    return -1
}

// 9번 실습 -> 반복(루프)
fun main() {
//    var sum = 0
//    var num: Int

    // var 보다 더 좋은 코드를 쓸 수 있는
//    do {
//        val num = readLine()!!.toInt()
//        sum += num
//    } while ( num != 0 )

//    println("sum = $sum")

    // 9-2번 실습 -> do while 을 이용해서 랜덤 숫자 맞추기
    // 1부터 100까지의 숫자 중에 랜덤으로 숫자 정해짐
//    val num = Random.nextInt(1, 101)
//    var guess = 0
//    while (guess != num) {
//        guess = readLine()!!.toInt()
//        if (guess < num) println("Too small")
//        else if (guess > num) println("Too big")
//    }

    // 위의 while 문을 do while 으로 코드 리팩토링
    // var 가 아닌 val 로 수정
//    do {
//        val g = readLine()!!.toInt()
//        if (g < num) println("Too small")
//        else if (g > num) println("Too big")
//    } while (g != num)
//    println("Right: it's $num")

    // for 문에서 값 자체의 이터레이터에 접근
//    val a = IntArray(10) { it * it }
//    val b = IntArray(10) { it * it }
//    val c = IntArray(10) { it * it }
//    var sum = 0
//
//    for (x in a) {
//        sum += x
//    }
//    print("sum is $sum")
//    println("----")

    // for 문에서 인덱스로 접근
//    for (i in 0 .. a.lastIndex) {
//        a[i] *= 2
//        println("a[$i] = ${a[i]}")
//    }
//    println("----")
//    println("another method")
//    for (i in b.indices) {
//        b[i] *= 2
//        println("b[$i] = ${b[i]}")
//    }
//    println("----")
//    println("step is")
    // for 문도 동일하게 디폴트가 1이므로 step을 활용할 수 있음
//    for (i in c.indices step 2) {
//        c[i] *= 2
//        println("c[$i] = ${c[i]}")
//    }

    // break 문
//    val number = Random.nextInt(1, 101)
//
//    while (true) {
//        val guess = readLine()!!.toInt()
//        val message = when (guess) {
//            in 1 until number -> "small"
//            in number+1 .. 100 -> "big"
//            else -> break
//        }
//        val message = when {
//            number > guess -> "small"
//            number < guess -> "big"
//            else -> break
//        }
//            if (number > guess) "small"
//            else if (number < guess) "big"
//            else break
//        println(message)
//        if (guess > number) println("Too big")
//        else if (guess < number) println("Too small")
//        else break
//    }
//    println("number is $number")

    // continue
//    val t = readLine()!!
//    val counts = countLetters(t)
//
//    for (c in counts.indices) {
//        println("${'a' + c} = ${counts[c]}")
//    }

    // continue 의 응용(outerLoop)
    // 짧은 배열(sub)이 긴 배열(arr)에서 어디에서 등장하는지 체크하는 함수
//    val arr = intArrayOf(2, 7, 3, 4, 6, 9, 4, 2)
//    val sub = intArrayOf(4, 6, 9)
//
//    println(indexOf(sub, arr))
//    println("---")
//    val sub2 = intArrayOf(4, 6, 7)
//    println(indexOf(sub2, arr))
}