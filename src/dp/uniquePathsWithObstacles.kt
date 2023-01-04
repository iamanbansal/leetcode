package dp

import kotlin.math.max


//https://leetcode.com/problems/unique-paths-ii/
fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {

    val m = obstacleGrid.size
    val n = obstacleGrid.first().size

    val dp = Array(m) { IntArray(n) { -1 } }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (obstacleGrid[i][j] == 1) dp[i][j] = 0 //set zero if blocked means no way
            else if (i == 0 && j == 0) dp[i][j] = 1 //1 for starting point
            else if (i == 0) dp[i][j] = dp[i][j - 1] // pick left only when on first row
            else if (j == 0) dp[i][j] = dp[i - 1][j] // pick top only when on first column
            else dp[i][j] = dp[i - 1][j] + dp[i][j - 1] // add top and left
        }
    }
    return dp[m - 1][n - 1]
}