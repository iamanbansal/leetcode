package mayChallenge.week3

import kotlin.math.max
import kotlin.math.min

/**
 * Leetcode problem
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */

fun main() {
    println(maxSubarraySumCircular(intArrayOf(5, -3, -2, 4, 1)))
    println(maxSubarraySumCircular(intArrayOf(5, 3, 2, 4, 1)))
    println(maxSubarraySumCircular(intArrayOf(1, -2, 3, -2)))
    println(maxSubarraySumCircular(intArrayOf(-3, -4, -2, -6)))
}

fun maxSubarraySumCircular(arr: IntArray): Int {

    if (arr.size == 1) return arr[0]
    var maxSum = Int.MIN_VALUE
    var max = arr[0]
    var minSum = Int.MAX_VALUE
    var min = arr[0]
    var sum = arr[0]

    for (i in 1 until arr.size) {
        sum += arr[i]

        max =arr[i] + max(max, 0)
        maxSum = max(max, maxSum)

        min = arr[i] + min(min, 0)
        minSum = min(min, minSum)
    }
    return if (sum == minSum) maxSum
    else max(maxSum, sum - minSum)
}
