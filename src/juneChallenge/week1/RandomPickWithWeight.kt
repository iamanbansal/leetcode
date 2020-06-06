package juneChallenge.week1

import kotlin.random.Random

/**
 * Leetcode problem
 * https://leetcode.com/problems/random-pick-with-weight/submissions/
 */

class RandomPickWithWeight(private val w: IntArray) {

    private var sum = 0
    private val random = Random.Default
    private val v = IntArray(w.size)

    init {
        for (i in 0 until w.size) {
            sum += w[i]
            v[i] = sum
        }
    }

    fun pickIndex(): Int {
        val r = random.nextInt(sum)
        var left = 0
        var right = v.size - 1
        var mid = 0

        while (left <= right) {
            mid = left + (right - left) / 2
            if (r >= v[mid]) {
                left = mid + 1
            } else right = mid - 1
        }
        return left
    }
}