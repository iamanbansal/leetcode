package thirtyDaysAprilChallenge.week2

import kotlin.math.max

/*
*  LeetCode Problem
* https://leetcode.com/problems/diameter-of-binary-tree/
*/


fun main() {
    print(diameterOfBinaryTree(null))
}

var dia = 0
fun diameterOfBinaryTree(root: TreeNode?): Int {
    getDepth(root)
    return dia
}

fun getDepth(node: TreeNode?): Int {
    if (node == null) return 0
    val leftRootDepth = getDepth(node.left)
    val rightRootDepth = getDepth(node.right)
    dia = max(dia, leftRootDepth + rightRootDepth + 1)
    return max(leftRootDepth, rightRootDepth) + 1
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}