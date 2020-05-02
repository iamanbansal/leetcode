package thirtyDaysAprilChallenge.week2


/*
*  LeetCode Problem
* https://leetcode.com/problems/middle-of-the-linked-list/
*/
fun  main(){
    println(middleNode(null))
}
fun middleNode(head: ListNode?): ListNode? {
    var ptr1: ListNode? = head
    var ptr2: ListNode? = head
    while (ptr2?.next != null) {
        ptr1 = ptr1?.next
        ptr2 = ptr2.next?.next
    }
    return ptr1
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}