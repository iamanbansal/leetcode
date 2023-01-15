package heap

import java.util.Collections
import java.util.PriorityQueue

//https://leetcode.com/problems/find-median-from-data-stream/
class MedianFinder() {

    private val large = PriorityQueue<Int>()
    private val small = PriorityQueue<Int>(Collections.reverseOrder())
    private var isEven = true

    fun addNum(num: Int) {
        if (isEven) {
            small.add(num)
            large.add(small.poll())
        } else {
            large.add(num)
            small.add(large.poll())
        }
        isEven = !isEven
    }

    fun findMedian(): Double {
        return if (isEven) {
            (large.peek() + small.peek()) / 2.0
        } else {
            large.peek() / 1.0
        }

    }
}