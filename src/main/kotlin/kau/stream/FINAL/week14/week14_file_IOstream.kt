package kau.stream.FINAL.week14

import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.io.FileWriter
import java.io.FilterInputStream
import javax.annotation.processing.Filer

/*
< I/O 클래스 >
- InputStream : Byte 단위로 입력 읽어옴
    - FileInputStream : 파일을 Byte 단위로 읽어오기 위한 클래스
- OutputStream : Byte 단위로 출력
    - FileOutputStream : 파일을 Byte 단위로 출력하기 위한 클래스
- Reader : 문자 단위로 입력 읽어옴
    - FileRead : 파일을 문자 단위로 읽기 위한 클래스
- Writer : 문자 단위로 출력
    - FileWriter : 파일을 문자 단위로 출력하기 위한 클래스

 */

fun main() {
    // 문자열 단위로 저장
//    val writer = FileWriter("data.txt")
//
//    try {
//        writer.write("A")
//        writer.write("가")
//    } finally {
//        writer.close()
//    }

    // 문자열 단위로 읽기
//    val reader = FileReader("data.txt")
//    try {
//        val first = reader.read().toChar() // A
//        val second = reader.read().toChar() // 가
//
//        println("$first $second")
//
//        val third = reader.read()
//        println("$third") // -1 이 출력되면 읽을 것이 없다는 의미임
//    } finally {
//        reader.close()
//    }

    // 바이트 단위로 읽기
//    val inputStream = FileInputStream("data.txt")
//    try {
//        var idx = 0
//        while (true) {
//            val b = inputStream.read() // Int 를 반환해줌
//            if (b < 0) break
//            println("$idx: $b")
//            idx++
//        }
//    } finally {
//        inputStream.close()
//    }

    // 전통적인 위의 방식은 close 를 계속 써줘야 된다.
    // 하지만, use 를 사용한다면 it 을 사용하면서 close 를 사용하지 않아도 된다.
//    FileInputStream("data.txt").use {
//        var idx = 0
//        while (true) {
//            val b = it.read()
//            if (b < 0) break
//            println("$idx : ${b.toChar()} : ${b}")
//            idx++
//        }
//    }

//    FileWriter("data.txt").use { it.write("One\ntwo\nThree") }
//    FileReader("data.txt").buffered().use { println(it.readLine()) } // 줄(라인) 단위로 -> 굳이 알 필요는 없음
//    FileReader("data.txt").use { println(it.readText()) }

    // readLines() 는 각각을 한 줄씩 리스트에 담음. 그리고 이걸 출력만 해주면 됨
    // 그리고, close 필요없음
//    println( FileReader("data.txt").readLines())
//    FileReader("data.txt").readLines().forEachIndexed { idx, line -> println("$idx: $line") }

    FileReader("data.txt").useLines { it.forEachIndexed {idx, line -> println("$idx: $line") } }
    FileReader("data.txt").forEachLine { println("$it") }
}