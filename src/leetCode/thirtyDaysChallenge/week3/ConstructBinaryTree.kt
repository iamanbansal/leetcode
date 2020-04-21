package leetCode.thirtyDaysChallenge.week3

/*
*  LeetCode Problem
*  https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
*/

fun main() {

    val root = bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12))
    println(root?.`val`)
}

fun bstFromPreorder(preorder: IntArray): TreeNode? {
    val size = preorder.size

    return when (size) {
        0 -> null
        1 -> TreeNode(preorder[0])
        else -> {
            val root = TreeNode(preorder[0])
            buildBST(preorder, root, size, 1, Int.MIN_VALUE, Int.MAX_VALUE)
            root
        }
    }
}

fun buildBST(preorder: IntArray, curr: TreeNode, size: Int, i: Int, minValue: Int, maxValue: Int): Int {

    var pos = i
    if (pos == size || preorder[pos] < minValue || preorder[pos] > maxValue)
        return pos

    if (preorder[pos] < curr.`val`) {
        curr.left = TreeNode(preorder[pos])
        pos++
        pos = buildBST(preorder, curr.left!!, size, pos, minValue, curr.`val` - 1)
    }

    if (pos == size || preorder[pos] < minValue || preorder[pos] > maxValue)
        return pos


    curr.right = TreeNode(preorder[pos])
    pos++
    pos = buildBST(preorder, curr.right!!, size, pos, curr.`val` + 1, maxValue)

    return pos
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}