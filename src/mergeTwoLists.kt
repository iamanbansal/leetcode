import mayChallenge.week3.ListNode


//https://leetcode.com/problems/merge-two-sorted-lists/
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var ptr = list1
    var ptr2 = list2
    val preHead = ListNode(-1)
    var curr: ListNode? = preHead

    while (ptr != null && ptr2 != null) {
        if (ptr.`val` <= ptr2.`val`) {
            curr?.next = ptr
            ptr = ptr.next
        } else {
            curr?.next = ptr2
            ptr2 = ptr2.next
        }

        curr = curr?.next
    }

    curr?.next = ptr ?: ptr2

    return preHead.next
}