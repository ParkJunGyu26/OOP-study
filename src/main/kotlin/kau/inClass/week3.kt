//package kau.inClass
//
//class Car(val name: String, var speed: Double = 0.0) {
//    var distance: Double = 0.0
//}
//
//class Track(private val cars: Array<Car?> = Array<Car?>(8) { _->null},
//            private var numCars: Int = 0) {
//
//    var time: Double = 0.0
//
//    fun addCar(c: Car) {
//        cars[numCars] = c
//        numCars++
//    }
//
//    fun timePassed(t: Double) {
//        for (i in 0 .. numCars) {
//            val c: Car? = cars[i]
//            if (c != null) {
//                c.distance += (t * c.speed)
//            }
//        }
//        time += t
//    }
//
//    fun removeCar(num: Int) {
//        cars[num] = null
//    }
//}
//
//fun main() {
//    val track = Track()
//
//    val a = Car("Alpha")
//    track.addCar(a)
//    val b = Car("Bravo", 30.0)
//    track.addCar(b)
//
//    while (true) {
//        track.timePassed(1.0)
//        a.speed += 1.0
//        if (a.distance > b.distance) {
//            println(a.name + " passed " + b.name + " at " + track.time)
//            break
//        }
//    }
//}