package dp

import kotlin.math.min

//https://leetcode.com/problems/edit-distance/
fun minDistance(word1: String, word2: String): Int {

    val dp = Array(word1.length) { IntArray(word2.length) { -1 } }

    fun calculateFurtherMinDistance(index1: Int, index2: Int): Int {

        if (index1 == word1.length && index2 == word2.length) return 0
        else if (index1 >= word1.length) return word2.length - index2
        else if (index2 >= word2.length) return word1.length - index1

        if (dp[index1][index2] != -1) return dp[index1][index2]

        if (word1[index1] == word2[index2])
            return calculateFurtherMinDistance(index1 + 1, index2 + 1)

        val replace = 1 + calculateFurtherMinDistance(index1 + 1, index2 + 1)
        val remove = 1 + calculateFurtherMinDistance(index1 + 1, index2)
        val add = 1 + calculateFurtherMinDistance(index1, index2 + 1)

        dp[index1][index2] = min(replace, min(remove, add))

        return dp[index1][index2]
    }
    return calculateFurtherMinDistance(0, 0)
}

fun minDistance2(word1: String, word2: String): Int {
    val n = word1.length
    val m = word2.length
    val dp = Array(n + 1) { IntArray(m + 1) { -1 } }

    for (i in 0..n) {
        for (j in 0..m) {
            if (i == 0) {
                dp[i][j] = j
            } else if (j == 0) {
                dp[i][j] = i
            } else if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = 1 + minOf(dp[i - 1][j - 1], minOf(dp[i - 1][j], dp[i][j - 1]))
            }
        }
    }

    return dp[n][m]
}