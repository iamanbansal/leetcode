package leetCode.thirtyDaysChallenge.week4

import kotlin.math.min


/*
* Leetcode problem
* https://leetcode.com/problems/maximal-square/
*/

fun main() {

//   val matrix= arrayOf(
//       charArrayOf('1','0','1','0','0'),
//       charArrayOf('1','0','1','1','1'),
//       charArrayOf('1','1','1','1','1'),
//       charArrayOf('1','0','0','1','0'))
//

//    val matrix = arrayOf(
//        charArrayOf('0','0'),
//        charArrayOf('0','1')
//    )

    val matrix = arrayOf(
        charArrayOf('0', '1')
    )
    println(maximalSquare(matrix))
}

fun maximalSquare(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty())
        return 0

    var largest = 0
    //     m*n matrix
    val dp = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[i].size) {
            if (i == 0 || j == 0) {
                if (matrix[i][j] == '1')
                    dp[i][j] = 1
            } else if (matrix[i][j] == '1') {
                dp[i][j] = 1 + min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1]))
            }
            if (dp[i][j] > largest) {
                largest = dp[i][j]
            }
        }
    }
    return largest * largest
}
