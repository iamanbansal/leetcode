package mayChallenge.week3

/**
 * Leetcode problem
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */

fun countSquares(matrix: Array<IntArray>): Int {
    var sum = 0
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if ((i > 0 && j > 0) && matrix[i][j] > 0) {
                val topLeft = matrix[i - 1][j - 1]
                val left = matrix[i][j - 1]
                val top = matrix[i - 1][j]
                matrix[i][j] += minOf(topLeft,top,left)
            }
            sum += matrix[i][j]
        }
    }
    return sum
}