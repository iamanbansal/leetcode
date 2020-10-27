package dp

import java.util.Comparator
import kotlin.math.max

//https://leetcode.com/problems/maximum-length-of-pair-chain/

fun findLongestChain(pairs: Array<IntArray>): Int {
    if (pairs.isEmpty()) return 0
    val dp = IntArray(pairs.size) { 1 }
    var maxLength = 0

    pairs.sortWith(Comparator { a, b -> a[0] - b[0] })

    for (i in 1 until pairs.size) {
        for (j in 0 until i) {
            if (pairs[i][0] > pairs[j][1] && dp[i] <= dp[j]) {
                dp[i] = dp[j] + 1
            }
            maxLength = max(maxLength, dp[i])
        }
    }
    return maxLength
}