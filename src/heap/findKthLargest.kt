package heap

import java.util.PriorityQueue

//https://leetcode.com/problems/kth-largest-element-in-an-array/
fun main() {
    println(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    val heap = PriorityQueue<Int> { l, r -> l - r }
    for (i in nums.indices) {

        if (i <= k - 1) {
            heap.add(nums[i])
        } else if (nums[i] > heap.peek()) {
            heap.remove()
            heap.add(nums[i])
        }
    }

    return heap.peek()
}