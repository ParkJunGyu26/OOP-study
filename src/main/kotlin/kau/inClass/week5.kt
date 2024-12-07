package kau.inClass

// Track에서 Car에 대해 게터 및 세터를 마음대로 하는중
// 시간 지난 것을 Car에게 공유하면 자동적으로 distance 수정
class Car(val name: String, var speed: Double = 0.0) {
    var distance = 0.0

    var time: Double = 0.0
        set(changedTime) {
            if (changedTime-time < 0) throw IllegalArgumentException("시간은 거꾸로 갈 수 없습니다.")
            distance += (changedTime-time) * speed
            field = changedTime
        }
}

class Track {
    private val cars = Array<Car?>(8) {_ -> null}
    private var numCars = 0
    var time = 0.0
        set(changedTime) {
            for (i in 0 until numCars) {
                cars[i]?.time = changedTime
            }
            field = changedTime
        }

    fun addCar(c: Car) {
        cars[numCars] = c;
        numCars += 1;
    }

    fun timePassed(t: Double) {
        for (i in 0 until numCars) {
            cars[i]?.time = t
        }
//        for( i in 0 until numCars ) {
//            val c = cars[i];
//            if( c != null ) {
//                c.distance += t * c.speed;
//            }
//        }
        time += t;
    }

    fun removeCar(num: Int) {
        cars[num] = null;
    }
}

fun main() {
    val track = Track();

    val a = Car("Alpha");
    track.addCar(a);

    val b = Car("Bravo", 30.0);
    track.addCar(b);

    while( a.distance <= b.distance ) {
        track.time += 1.0
        a.speed += 1.0
        if( a.distance > b.distance ) {
            println("${a.name} passed ${b.name} at ${track.time}");
            break;
        }
    }
}
