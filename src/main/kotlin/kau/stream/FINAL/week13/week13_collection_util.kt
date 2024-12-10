package kau.stream.FINAL.week13

/*
< 컬렉션 생성법 >
- listOf() : 내부적으로 배열 사용
- mutableListOf() : 내부적으로 ArrayList 사용
- arrayListOf()

- setOf()
- mutableSetOf() : 내부적으로 LinkedHashSet 사용
- hashSetOf()
- linkedSetOf()
- sortedSetOf()

- mapOf() : Pair 들을 인자로 받음
- mutableMapOf() : 내부적으로 LinkedHashMap 사용
- hashMapOf()
- linkedMapOf()
- sortedMapOf()

< Sequence > cf) Iterable : 이미 만들어진 값을 순서대로 보여주는 객체
- 요청하면 값을 뒤늦게 나열하는 객체
- 쓰레드처럼 병렬 처리함
- 크롤링 등 빅데이터 처리에 사용됨

< Collection 간 변환 >
- list 를 Set 으로
- array 를 SortedSet 으로

< iterator() 와 for 문 >
- map 의 경우에는 key 와 value 형태인 Map.Entry 라는 객체가 나옴
- 구조 분해를 통해서 (key, value) 로 for 문에서 간편하게 사용 가능
    - forEach { it -> ~~~ }
    - forEachIndexed { key, value -> ~~~ }

< 유틸리티1 >
- isEmpty() : 비었냐
- size : 자료구조 해당 크기
- contains(n) : n 이 포함되어있냐?
- containsAll(여러 개) : 여러 개가 포함되어있냐?
- add(All) == + : 추가해라
- remove(All) == - : 겹치는 건 제거해라(차집합)
- retain(All) : 겹치는 건 남겨라(교집합)
- clear()

< 유틸리티2 > - 인덱스로 장난
- 조회 : get(index), list[index], list.indexOf(value), lastIndexOf(value)
    - 만약 조회할 때 인덱스가 사이즈보다 초과되면 에러 발생할 수 있으므로 getOrNull
    - 해당 value 가 자료구조에 존재하지 않는다면 -1을 출력
    - indexOf 는 왼쪽에서 시작해서 만나는 value 의 index
    - lastIndexOf 는 오른쪽에서 시작해서 만나는 value 의 index
- 추가 : set(index, value), add(index, value)
- 삭제 : removeAt(index)

< Map 의 유틸리티 >
- get : key 해당하는 value 를 내뱉음
- getOrDefault(100, "?") : 해당하는 key(100) 가 없다면, ?를 출력
- containsKey(key) : key 존재여부
- containsValue(value) : 비싼 연산 -> 일일이 키를 다 뒤져 보는 거임
- map.keys : key 는 Set 으로 반환 ( 왜냐하면, 겹치는 key 는 존재하지 않기 때문 )
- map.values : value 는 Collection 으로 반환 ( 왜냐하면, value 는 겹칠 수 있기 때문 )
- map.entries : Map.Entry 형태로 반환 ex) [1=I, 5=V, 10=X, 50=L]

< MutableMap 의 유틸리티 >
- map.put(100, "C") -> 추가
- map[500] = "D" -> 직접 추가
- map.remove(key) -> 해당 키를 가지는 엔트리(key, value) 삭제
- map.putAll(mapOf(1 to "I")) -> 여러 element 를 삽입
- map += 50 to "L" -> Pair 형태로 맵에 삽입
- map += mapOf(2 to "II", 3 to "III") -> Pair 형태로 2 개 이상 삽입
- map -= 100 : 100 이라는 key 의 Entry 를 제거
- map -= listOf(2, 3) : key 가 2와 3에 해당하는 엔트리를 모두 삭제

< Collection 원소 접근 >
- list.first() : 만약에 없을 경우에는 NoSuchElementException 에러 발생
- list.last()
- list.firstOrNull() : 만약에 없을 경우에는 null

- list.first { 조건문 } ex) listOf(1, 2, 3)
    - list.first { it > 2 } = 3
- list.lastOrNull { 조건문 }
    - list.lastOrNull { it < 0 } -> null

ex) val s = sortedSetOf(1, 2, 3)
- s.elementAt(2) -> 두 번째 인덱스에 해당하는 값
- s.elementAtOrNull(-1) -> -1번째 인덱스는 당연히 없으니 Null
- s.elementAtOrElse(100) { 1 } -> 람다함수. 100번째 인덱스가 없다면 1로 반환해라

list 및 set 조건문
ex) val l = listOf(1, 2, 3, 4)
    - l.all { it < 10 } -> true
    - l.all { it % 2 == 0 } -> false
    - l.none { it > 5 } -> true ( 5 넘는 게 아무것도 없으니 true )
    - l.any { it < 0 } -> false ( 음수가 없기 때문에 false )
    - l.any { it % 2 == 0 } -> true ( 짝수가 하나라도 있기 때문에 true )
    - l.count { it % 2 == } -> 2 ( 짝수의 개수 )
    - l.joinToString() -> 1, 2, 3, 4 로 문자열로 출력
    - l.joinToString(separator = "") -> 1234 로 문자열 출력(구분자 없이)
    - l.joinToString(limit = 2) -> 1, 2, ... -> 2개만 표현하고 나머진 ...
    - l.joinToString(separator = "|", prefix = "[", postfix = "]") -> [1|2|3|4] 커스텀해서 출력

ex) val m = mapOf(1 to "I", 5 to "V", 10 to "X")
    - m.all { it.key == 1 || it.key % 5 == 0 } -> true
    - m.none { it.key % 2 == 0 } -> false ( 키 모두 홀수임 )
    - m.any { it.key == 1 } -> true ( 키 중에 1이라는 것이 존재함 )
    - m.count { it.key == 1 } -> 1 ( 키가 1인 개수 )

reduce 메서드 -> 숫자 누적 처리(집계처리)
val arr = intArrayOf(1, 2, 3, 4, 5)
arr.reduce { acc, n -> acc * n } -> 120이 나온다.
    - acc 에 누적이되고, n은 각 인덱스에 해당하는 값들을 의미함
        - acc = 1, n = 2 -> acc = 2
        - acc = 2, n = 3 -> acc = 6
        - acc = 6, n = 4 -> acc = 24
        - acc = 24, n = 5 -> acc = 120

fold 메서드 -> 문자열 누적 처리(집계처리)
arr.fold("") { acc, n -> acc + ('a' + n - 1)} -> abcde 로 출력
    - 초기값을 "" 빈 문자열로 할당
        - acc = "", n = 1 -> acc += ('a' + 1 - 1) -> a
        - acc = a, n = 2 -> acc += ('a' + 2 - 1 ) -> ab
        - acc = ab, n = 3 -> acc += ('a' + 3 - 1) -> abc
        - acc = abc, n = 4 -> acc += ('a' + 4 - 1) -> abcd
        - acc = abcd, n = 5 -> acc += ('a' + 5 - 1) -> abcde

val list = listOf('a', 'b', 'c', 'd', 'e')
list.foldIndexed("") { idx, acc, n -> acc + idx.toString() + n } -> 0a1b2c3d4e
    - idx : 0, acc = "", n = 'a' -> acc += '0' + 'a' -> 0a
    - idx : 1, acc = "0a", n = 'b' -> acc += '1' + 'b' -> 0a1b

< Collection, Map 걸러내기 > - 다른 객체에 전달 가능
val s = setOf("red", "green", "blue", "green")
s.filter {it.length > 3} -> 길이가 3보다 큰 blue, green 이 필터링 됨

val map = mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50)
map.filter {it.value > 5} // -> value 가 5보다 큰 10, 50 이 필터링 됨

val arrList = ArrayList<String>()
s.filterTo(arrList) { it.length > 3 } -> 길이가 3보다 큰 것들을 (to) arrList에 삽입해라

setOf("red", "green", "blue").map {it.length} -> [3, 5, 4] List 객체가 나온다

listOf(1, 2, 3, 4).map { it * it } -> [1, 4, 9, 16] List 객체가 나온다.

byteArrayOf(10, 20, 30).map { it.toString(16) } -> [a, 14, 1e] List 객체(16진수)

arrayOf("1", "red", "2").mapNotNull { it.toIntOrNull() } -> [1, 2] List 객체(숫자로 변환이 안되면 null로 되고, 그것은 필터링됨)

arrayOf("1", null, "2").filterNotNull() -> [1, 2] null이 아닌 것들만

val map = mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50)
map.map { "${it.key} ${it.value}" } -> [I 1, V 5, X 10, L 50] List 로 변환
map.mapKeys { it.key.lowercase() } -> {i=1, v=5, x=10, l=50} map 그대로지만, 키를 소문자로 변환
map.mapValues {it.value.toString(16)} -> {I=1, V=5, X=a, L=32} map 그대로지만, value 를 16진수로 변환

listOf(listOf(1, 2), setOf(3, 4), listOf(5)).flatten() -> [1, 2, 3, 4, 5] : 2차원을 1차원으로 바꿔줌

< 하위 Collection != 서브 리스트>
val arr = arrayOf(0, 1, 4, 9, 16, 25)
val arr2 = arr.slice(2..4) -> [4, 9, 16] : 서브 리스트와는 다르게 다른 객체다. 서로 메모리 주소를 공유x
arr[3] = 0 : arr2 와는 아무 상관없음
val arr3 = arr.sliceArray(2 .. 4) -> [4, 0, 16]
arr3.joinToString() -> arr3을 출력해줌

< 정렬 및 순서 >
val arr = intArrayOf(5, 8, 1, 4, 2)
val sorted = arr.sorted() -> sorted 배열에는 정렬이 된 arr을 할당해주지만, arr은 정렬되지 않은 상태임
-> arr : [5, 8, 1, 4, 2]
-> sorted : [1, 2, 4, 5, 8]

arr.sort() -> 이렇게 해야 arr 가 정렬이 된다. (자체 정렬)
-> arr [ 1, 2, 4, 5, 8]

val arr = intArrayOf(5, 8, 1, 4, 2)
val arr2 = arr.reversed() -> sorted 처럼, arr을 뒤집은 것을 arr2에 할당(arr에는 아무런 변화x)
-> arr: [5, 8, 1, 4, 2]
-> arr2 : [2, 4, 1, 8, 5]

arr.reverse() -> 이렇게 해야 arr 가 뒤집어진다. (자체 역행)

arr.sort() -> 다시 arr를 자체 정렬
arr.shuffle() -> arr를 뒤섞어줌
-> arr : [ 4, 5 ~~~ ]


 */

fun main() {
//    val u1 = listOf(1, 2, 3)
//    println(u1)
//    u1.add(4) -> mutable 아니라서 안됨

//    val u2 = mutableListOf(1, 2, 3)
//    u2.add(4)
//    println(u2)

//    val u3 = mapOf(1 to "I", 5 to "V", 10 to "X", Pair(50, "L")) // Pair 로 객체를 만듦
//    println(u3)
//    u3[30] = "H" -> mutable 아니라서 안됨

//    val u4 = mutableMapOf(1 to "I", 5 to "V")
//    u4[10] = "H"
//    println(u4)
//    u4.remove(5)
//    println(u4)

    // 쓰레드처럼 프로그램이 병렬적으로 처리하는?! null이 되면 중단하는 그런 느낌인거나
    // 크롤링 하는 프로그램에서 많이 사용됨 -> 의미있는 데이터가 나올 때마다 yield 하는..
    // 빅데이터 처리에 많이 사용됨
//    val seq = sequence {
//        yield(0)
//        yieldAll(listOf(1, 2, 3))
//        yieldAll(intArrayOf(4, 5, 6).iterator())
//        yieldAll(generateSequence(10) {if (it < 50) it * 3 else null})
//    }
//    var idx = 0
//    for (elem in seq) {
//        println("$idx: $elem")
//        idx++
//    }

    // list 를 Set 으로
//    val a = listOf(1, 2, 3, 2, 3).toSet() // 중복은 무시
//    println(a)

    // array 를 sortedSet 으로
//    val b = arrayOf("red", "green", "blue").toSortedSet() // 안의 elem 들이 사전순으로 정렬됨
//    println(b)

    // map 을 list 로
//    val c = mapOf(1 to "One", 2 to "Two", 3 to "Three").toList() // 맵 안에는 Pair 형태로 되어있음. 이거를 리스트로 변환
//    println(c)

    // 뒤늦게 만드는 sequence
//    val d = sequenceOf(1 to "one", 2 to "two", 3 to "three").toMap() // 시퀀스도 뒤늦게 만들긴 하지만, 직접 만들 수도 있음
//    println(d)

//    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
//    for (elem in map) // 여기에서 elem 은 Map.Entry 객체가 된다
//        println(elem)

//    for ((key, value) in map) // Entry 를 구조분해를 이용해서 사용 가능
//        println("$key -> $value")

//    map.forEach{ println("${it.key} -> ${it.value}") }
//    map.forEach{ (k, v) -> println("$k -> $v") }

//    val arr = intArrayOf(1, 2, 3)
//    arr.forEachIndexed {idx, value -> println("$idx : $value") }

//    val list = listOf(1, 2, 3)
//    println(list.isEmpty())
//    println(list.size)
//    println(list.contains(4))
//    println(2 in list)
//    println(list.containsAll(listOf(1, 2)))

//    val l2 = list + 4
//    println(l2)
//    println(list)

//    val l3 = list - setOf(2, 5)
//    println(l3)

//    val l4 = arrayListOf(1, 2, 3)
//    l4.add(4)
//    println(l4)

//    l4.remove(3)
//    println(l4)

//    l4.addAll(setOf(5, 6)) // l4 에 5, 6 을 추가해
//    println(l4)
//    l4.removeAll(listOf(1, 2)) // l4 에서 1, 2 중에 있다면 그건 빼
//    println(l4)
//    l4.retainAll(listOf(5, 6, 7)) // l4 에서 5, 6, 7 중에 있는 것만 남겨라
//    println(l4)
//    l4 += 4 // l4 에서 맨 끝에 4를 추가해
//    println(l4)
//    l4 -= 6 // 차집합 (l4 에서 6이 있다면 빼)
//    println(l4)
//    l4 += setOf(8, 9) // l4 에 8, 9 추가해
//    println(l4)
//    l4 -= listOf(7, 8) // l4 에 7, 8이 있다면 그건 지워
//    println(l4)
//    l4.clear() // 완전히 비움
//    println(l4)

//    val l5 = listOf(1, 4, 6, 2, 4, 1, 7)
//    println(l5.get(3))
//    println(l5[3])
//    println(l5[10]) -> 에러 발생(사이즈 보다 크니깐)
//    println(l5.getOrNull(3)) // 만약 해당 인덱스가 존재하지 않으면 null 반환

//    println(l5.indexOf(5)) // '5'라는 숫자가 인덱스 몇 번이니? -> 없으면 -1
//    println(l5.indexOf(4)) // '4'라는 숫자가 인덱스 몇 번이니? -> 제일 처음 만나는 곳 : 1
//    println(l5.lastIndexOf(4)) // '4'라는 숫자가 인덱스 몇 번이니? -> 뒤에서 만나는 곳 : 4

//    val l6 = arrayListOf(1, 4, 6, 2, 4, 1, 7)
//    l6.set(3,0) // 3 번째 인덱스의 값을 0으로 설정
//    l6[2] = 99 // 2 번째 인덱스의 값을 99로 설정
//    println(l6)

//    l6.add(3, 1000) // 3번째 인덱스에 1000을 추가하겠다. 그 이후 값들은 뒤로 밀어라
//    println(l6)

    // subList 는 서로 연동되어있다. 즉, 주소값을 공유하고 있어서 둘 중 하나를 바꾸면 둘 다 바뀜을 확인할 수 있다.
//    val segment = l6.subList(2, 5) // l6 에서 2번째 인덱스 값부터 4번째까지 포함시킨다. (substring) 같은듯
//    println(segment)
//    println(l6)
//    segment[1] = -1000
//    println(segment)
//    println(l6)
//    l6.removeAt(0)
//    println(l6)

    val map = mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50)
    println( map.filter {it.value > 5} )// -> value 가 5보다 큰 10, 50 이 필터링 됨
}