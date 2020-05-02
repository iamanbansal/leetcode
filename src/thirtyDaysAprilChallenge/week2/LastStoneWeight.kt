package thirtyDaysAprilChallenge.week2

import java.util.*
import kotlin.math.abs

/*
*  LeetCode Problem
* https://leetcode.com/problems/last-stone-weight/
*/

fun  main(){
    println(lastStoneWeight(intArrayOf(2,7,4,1,8,1)))
}
fun lastStoneWeight(stones: IntArray): Int {
    val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
    stones.forEach { maxHeap.add(it) }
    var stone1 = 0
    var stone2 = 0
    while (maxHeap.size > 1) {
        stone1 = maxHeap.remove()
        stone2 = maxHeap.remove()
        if (stone1 != stone2) {
            maxHeap.add(abs(stone1 - stone2))
        }
    }
    return if(maxHeap.isEmpty()) 0 else maxHeap.remove()
}