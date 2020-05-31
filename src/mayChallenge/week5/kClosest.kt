package mayChallenge.week5

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt


/**
 * Leetcode problem
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */

/**
 * One liner
 */
fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
    return points.sortedBy { it[0] * it[0] + it[1] * it[1] }.take(K).toTypedArray()
}


/**
 * Using priority queue
 */
fun kClosest2(points: Array<IntArray>, K: Int): Array<IntArray> {

    // Create a PriorityQueue -- MinHeap

    val heap = PriorityQueue<Pair<Double, IntArray>>(
        points.size,
        compareBy { it.first }) // Comparator to take pair of point to distance

    for (point in points) {

        val distance = sqrt((point[0] * point[0]).toDouble() + (point[1] * point[1]).toDouble())
        heap.add(Pair(distance, point))
    }

    val result = ArrayList<IntArray>(K)

    for (i in 0 until K) {
        result.add(heap.poll().second)
    }
    return result.toTypedArray()
}

