package leetCode.thirtyDaysChallenge.week4
import kotlin.math.max


/*
*  LeetCode Problem
*  https://leetcode.com/problems/longest-common-subsequence/
*/

fun main() {
    println(longestCommonSubsequence("abcdgh","aedfhr"))
}

fun longestCommonSubsequence(str1: String, str2: String): Int {
//     m*n matrix
    val dp = Array(str1.length+ 1) { IntArray(str2.length + 1) }
    for (i in 0..str1.length) {
        for (j in 0..str2.length) {
//            set first and column values to 0
            if (i == 0 || j == 0)
                dp[i][j] = 0
            else if (str1[i - 1] == str2[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1
            else
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        }
    }
    return dp[str1.length][str2.length]
}