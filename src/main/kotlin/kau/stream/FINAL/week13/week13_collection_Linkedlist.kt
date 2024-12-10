package kau.stream.FINAL.week13
import java.util.*

/*
< collection - LinkedList >
- 맨 끝에 삽입 삭제가 좋음 -> Queue, Stack 에 많이 쓰임
- 하지만, 방문할 때는 O(N) 사용
    - 중간에 있는 인덱스를 방문하려면, 처음부터 해당 인덱스까지 시간이 소요됨
- java util 패키지
- 생성법 : LinkedList<T>()
 */

fun main() {
    val llist = LinkedList<Int>()
    llist.add(1)
    llist.addFirst(3)
    llist.add(2)
    println(llist)

    llist.removeLast()
    llist.removeFirst()
    println(llist)

    println(llist[0])
}