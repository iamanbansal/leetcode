package thirtyDaysAprilChallenge.week3

import kotlin.math.min

/*
*  LeetCode Problem
*  https://leetcode.com/problems/minimum-path-sum/
*/

fun main() {
    val arr = arrayOf(
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 1),
        intArrayOf(4, 2, 1)
    )
    println(minPathSum(arr))
}

fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.isEmpty())
        return 0

    for (row in 0 until grid.size) {
        for (col in 0 until grid[row].size) {
            if (row == 0 && col == 0) //skip top left cell
                continue
            when {
                row-1 < 0 -> grid[row][col] = grid[row][col] + grid[row][col-1]  // cases for element in top row
                col-1 <0 -> grid[row][col] = grid[row][col] + grid[row - 1][col] // cases for element in left row
                else -> grid[row][col] = grid[row][col] + min(grid[row - 1][col], grid[row][col-1])
            }
        }
    }
    return grid[grid.lastIndex][grid[0].lastIndex]
}

