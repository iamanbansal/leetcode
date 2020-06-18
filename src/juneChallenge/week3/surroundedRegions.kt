package juneChallenge.week3

/**
 * leetcode problem
 * https://leetcode.com/problems/surrounded-regions
 */

fun main() {
    val arr = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'X')
    )

    surroundedRegions(arr)
    val row = arr.size
    val col = arr[0].size
    for (i in 0 until row) {
        for (j in 0 until col) {
            print(arr[i][j])
        }
        println()
    }

}

fun surroundedRegions(board: Array<CharArray>): Unit {
    if (board.isEmpty()) return

    val row = board.size
    val col = board[0].size

    fun dfs(i: Int, j: Int) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O')
            return

        board[i][j] = '1'

        dfs(i + 1, j) //down
        dfs(i - 1, j) // up
        dfs(i, j + 1)  //left
        dfs(i, j - 1) //right
    }

    for (i in 0 until row) {
        if (board[i][0] == 'O') dfs(i, 0)
        if (board[i][col - 1] == 'O') dfs(i, col - 1)
    }

    for (i in 0 until col) {
        if (board[0][i] == 'O') dfs(0, i)
        if (board[row - 1][i] == 'O') dfs(row - 1, i)
    }

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (board[i][j] == 'O') board[i][j] = 'X'
            else if (board[i][j] == '1') board[i][j] = 'O'
        }
    }

}