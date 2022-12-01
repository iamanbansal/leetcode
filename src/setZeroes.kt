fun setZeroes(matrix: Array<IntArray>): Unit {
    if (matrix.isEmpty()) return
    val rows = IntArray(matrix.size)
    val cols = IntArray(matrix.first().size)

    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == 0) {
                rows[i] = 1
                cols[j] = 1
            }
        }
    }
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (rows[i] == 1) {
                matrix[i][j] = 0
            }
            if (cols[j] == 1) {
                matrix[i][j] = 0
            }
        }
    }
}

fun main() {
    println(5 / 2)
}