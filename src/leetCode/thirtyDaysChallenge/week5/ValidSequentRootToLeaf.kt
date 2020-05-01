package leetCode.thirtyDaysChallenge.week5

/*
Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.

We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
*/

fun main() {
    val root = TreeNode(0)
    root.left = TreeNode(0)
    root.right = TreeNode(1)
    println(isValidSequence(root, intArrayOf(0,1)))
    println(isValidSequence(root, intArrayOf(1,1)))
}

    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
        val pos = 0
        val n = arr.size
        return isValidSequence(root, arr, n, pos)
    }

    fun isValidSequence(root: TreeNode?, arr: IntArray, size: Int, pos: Int): Boolean {
        if (root == null)
            return false
        if (pos == size)
            return false
        if (root.`val` != arr[pos])
            return false
        if (pos == size - 1 && root.left == null && root.right == null)
            return true

        val isLeft = isValidSequence(root.left, arr, size, pos + 1)
        val isRight = isValidSequence(root.right, arr, size, pos + 1)

        return isLeft || isRight
    }
