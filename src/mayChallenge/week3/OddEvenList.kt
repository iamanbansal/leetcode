package mayChallenge.week3

import kotlin.system.measureNanoTime

fun main() {
    val arr = intArrayOf(1,2,3,5,3,6,7,2,8,4,5,6,3,4,5,4,3,5,8,9,3,4,5,7,3,3,6,565,3,43,4,5)
    var head: ListNode? = null
    var temp: ListNode? = null

    arr.forEachIndexed { index, i ->
        if (index == 0) {
            head = ListNode(i)
            temp = head
            return@forEachIndexed
        }

        temp?.next = ListNode(i)
        temp = temp?.next
    }

   println(measureNanoTime { oddEvenList(head) })

    while (temp != null) {
        print("${temp!!.`val`}, ")
        temp = temp!!.next
    }
}

fun oddEvenList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var odd = head
    var even = head.next
    val evenHead = head.next

    while (even?.next != null) {
        odd?.next = even.next
        odd = odd?.next

        even.next = odd?.next
        even = even.next
    }

    odd?.next = evenHead
    return head
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}