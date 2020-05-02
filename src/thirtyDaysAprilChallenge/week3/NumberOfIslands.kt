package thirtyDaysAprilChallenge.week3


/*
*  LeetCode Problem
*  https://leetcode.com/problems/number-of-islands/
*/

fun main() {
    val arr = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(numIslands(arr))
}

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty())
        return 0

    var numOfIslands = 0
    for (row in grid.indices) {
        for (col in grid[row].indices) {
            if (grid[row][col] == '1') {
                dfs(grid, row, col)
                numOfIslands++
            }
        }
    }
    return numOfIslands
}

fun dfs(grid: Array<CharArray>, row: Int, col: Int) {
    if (row < 0 || row >= grid.size || col < 0 || col >= grid[row].size || grid[row][col] == '0')
        return

    grid[row][col] = '0'
    dfs(grid, row + 1, col)
    dfs(grid, row - 1, col)
    dfs(grid, row, col + 1)
    dfs(grid, row, col - 1)
}
