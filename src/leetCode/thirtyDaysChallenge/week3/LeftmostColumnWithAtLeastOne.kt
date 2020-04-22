package leetCode.thirtyDaysChallenge.week3


/*
*  LeetCode Problem

(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

    BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
    BinaryMatrix.dimensions() returns a list of 2 elements [m, n], which means the matrix is m * n.

Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.

**/


fun main() {

}

fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
    val list = binaryMatrix.dimensions()
    var index = -1
    var x = list[0] - 1
    var y = list[1] - 1

    while (x >= 0 && y >= 0) {

        if (binaryMatrix.get(x, y) == 1) {
            index = y
            y--
        } else {
            x--
        }
    }

    return index
}

class BinaryMatrix {
    private val dimension= emptyList<Int>()
    fun get(x: Int, y: Int): Int { /* get num from matrix at (x,y)*/ return 1}
    fun dimensions(): List<Int> =dimension
}