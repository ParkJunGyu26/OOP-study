package kau.live

import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException

fun main() {
    try {
        val reader = BufferedReader(FileReader("students.txt"))
        try {
            val size = reader.readLine().toInt()

            for  (i in 0 until size) {
                val name = reader.readLine()
                val point = reader.readLine().toInt()

                val message = when (point) {
                    in 90 .. 100 -> "A"
                    in 80 until 90 -> "B"
                    in 70 until  80 -> "C"
                    in 60 until  70 -> "D"
                    else -> "F"
                }
                println("$name has grade $message")
            }
        } catch (e: IOException) {
            println("IOException")
        }
        reader.close()
    } catch (e: FileNotFoundException) {
        println("FileNotFoundException")
    }


}