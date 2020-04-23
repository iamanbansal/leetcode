package leetCode.thirtyDaysChallenge.week4

/*
*  LeetCode Problem
*  https://leetcode.com/problems/subarray-sum-equals-k/
*/

fun main() {

    println(subarraySum(intArrayOf(1, 1, 1), 2))
}

fun subarraySum(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>()
    var count = 0
    var currSum = 0

    nums.forEachIndexed { index, value ->
        currSum += value
        if (currSum == k) count++

        count += map.getOrDefault(currSum - k, 0)

        map[currSum] = map.getOrDefault(currSum, 0) + 1
    }

    return count
}