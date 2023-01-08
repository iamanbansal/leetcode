package slidingWindow

import java.util.LinkedList
import kotlin.math.max

//https://leetcode.com/problems/sliding-window-maximum/
fun main() {

    maxSlidingWindow(intArrayOf(1,-1), 1).forEach {
        println(it)
    }
}
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {

    val deque = LinkedList<Int>()
    val arr = IntArray(nums.size - k + 1)

    for (i in nums.indices) {

        if(deque.isNotEmpty() && deque.first == i-k)
            deque.removeFirst()

        while (deque.isNotEmpty() && nums[deque.last]< nums[i]) {
                deque.removeLast()
        }
        deque.addLast(i)

        if (i >= k - 1) {
            arr[i+1-k] = nums[deque.first]
        }
    }

    return arr
}