package mayChallenge.week4

import kotlin.math.max
import kotlin.math.min


/**
 * Leetcode problem
 * https://leetcode.com/problems/interval-list-intersections/
 */
fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var i = 0
    var j = 0

    while (i < A.size && j < B.size) {
        if (A[i][1] >= B[j][0] && A[i][0] <= B[j][1]) { // check for intersection

            // start and end point
            result.add(intArrayOf(max(A[i][0], B[j][0]), min(A[i][1], B[j][1])))
        }

        // increment the one with lowest endpoint
        if (A[i][1] < B[j][1])
            i++
        else
            j++
    }
    return result.toTypedArray()
}