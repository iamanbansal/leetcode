package dp


// link https://leetcode.com/problems/partition-equal-subset-sum/

fun main() {
    println(canPartition(intArrayOf(1, 5, 11, 5)))
    println(canPartition(intArrayOf(1, 2, 5)))
}

fun canPartition(nums: IntArray): Boolean {
    var sum = nums.sum()
    if (sum % 2 != 0) return false
    sum /= 2
    val dp = Array(sum + 1) { false }
    dp[0] = true
    for (i in nums) {
        // we will go from right to left to avoid counting same element twice
        var j = sum
        while (j >= i) {
            dp[j] = dp[j] or dp[j - i]
            j--
        }
        //goal is to find the combination for sum  if dp[sum] == true then we can return true here also
    }
    return dp.last()
}