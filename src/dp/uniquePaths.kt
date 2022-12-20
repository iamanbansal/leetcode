package dp

//https://leetcode.com/problems/unique-paths/
fun main() {
    println(uniquePaths(3, 7))
}

fun uniquePaths(m: Int, n: Int): Int {

    val dp = Array<IntArray>(m) { IntArray(n) { -1 } }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (i == 0 || j == 0) {
                dp[i][j] = 1
                continue
            }
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }
    return dp[m - 1][n - 1]

}

fun uniquePaths2(m: Int, n: Int): Int {

    val dp = Array<IntArray>(m) { IntArray(n) { -1 } }

    fun walk(i: Int, j: Int): Int {
        if (i == m - 1 && j == n - 1) return 1
        if (i >= m || j >= n) return 0

        if (dp[i][j] != -1) return dp[i][j]

        dp[i][j] = walk(i + 1, j) + walk(i, j + 1)
        return dp[i][j]
    }
    return walk(0, 0)

}

