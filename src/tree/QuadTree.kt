package tree

//https://leetcode.com/problems/construct-quad-tree/


class Node(var `val`: Boolean, var isLeaf: Boolean) {
    var topLeft: Node? = null
    var topRight: Node? = null
    var bottomLeft: Node? = null
    var bottomRight: Node? = null
}

fun construct(grid: Array<IntArray>): Node? {
    return getQuadTree(grid, 0, 0, grid.size)
}

fun getQuadTree(grid: Array<IntArray>, i: Int, j: Int, length: Int): Node {

    if (length == 1) {
        return Node(grid[i][j] == 1, true)
    }

    val node = Node(false, false)
    val len = length / 2
    val topLeft = getQuadTree(grid, i, j, len)
    val topRight = getQuadTree(grid, i, j + len, len)
    val bottomLeft = getQuadTree(grid, i + len, j, len)
    val bottomRight = getQuadTree(grid, i + len, j + len, len)

    if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
        topLeft.`val` == topRight.`val` && topRight.`val` == bottomLeft.`val` && bottomLeft.`val` == bottomRight.`val`
    ) {
        node.isLeaf = true
        node.`val` = topLeft.`val`
    } else {
        node.topLeft = topLeft
        node.topRight = topRight
        node.bottomLeft = bottomLeft
        node.bottomRight = bottomRight
    }

    return node
}
