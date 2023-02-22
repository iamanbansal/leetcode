package tree

import java.util.*

//https://leetcode.com/problems/01-matrix/

fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val m = mat.size
    val n = mat.first().size

    val dis = Array(m) { IntArray(n) }
    val visit = Array(m) { BooleanArray(n) }

    val queue: Queue<Pair<Pair<Int, Int>, Int>> = LinkedList()

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (mat[i][j] == 0) {
                queue.add((i to j) to 0)
            }
        }
    }

    val dir = arrayOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)


    while (queue.isNotEmpty()) {
        val front = queue.poll()
        val i = front.first.first
        val j = front.first.second
        val d = front.second

        if (!visit[i][j]) {
            dis[i][j] = d
            visit[i][j] = true

            for ((x, y) in dir) {

                if (isValid(i + x, j + y, m, n) && mat[i + x][j + y] == 1) {

                    queue.add((i + x to j + y) to d + 1)

                }


            }

        }
    }

    return dis
}

fun isValid(i: Int, j: Int, m: Int, n: Int): Boolean {
    return !(i < 0 || i >= m || j < 0 || j >= n)
}