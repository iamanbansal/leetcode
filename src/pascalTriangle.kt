import jdk.jshell.execution.Util

fun main() {
    val matrix = pascalTriangle(6)
    matrix.forEach {
        it.forEach {
            print(" $it")
        }
        println()
    }
}

fun pascalTriangle(numRows: Int): List<List<Int>> {
    val rows = ArrayList<ArrayList<Int>>(numRows)

    if (numRows == 0) return rows
    rows.add(arrayListOf(1))
    for (i in 1 until numRows) {
        val col = ArrayList<Int>(i + 1)
        col.add(1)
        for (j in 1 until i) {
            col.add(rows[i - 1][j] + rows[i - 1][j - 1])
        }
        col.add(1)
        rows.add(col)
    }
    return rows
}