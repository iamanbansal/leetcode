package leetCode.thirtyDaysChallenge.week5

import kotlin.math.max

/*
*  LeetCode Problem
*  https://leetcode.com/problems/binary-tree-maximum-path-sum/
*/


var maxSum = Int.MIN_VALUE
fun main() {
    val root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)
    println(maxPathSum(root))
}

fun maxPathSum(root: TreeNode?): Int {
    determineMaxPath(root)
    return maxSum
}

fun determineMaxPath(root: TreeNode?): Int {
    if (root == null) return 0

    val left = determineMaxPath(root.left)
    val right = determineMaxPath(root.right)

    //max of  right+root , left+root, root, left+right+root
    val childMax = max(max(left, right) + root.`val`, root.`val`)
    val nodeMax = max(childMax, root.`val` + left + right)

    maxSum = max(maxSum, nodeMax)
    return childMax
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}