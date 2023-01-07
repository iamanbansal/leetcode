import juneChallenge.week1.TreeNode
import kotlin.math.abs
import kotlin.math.max

//https://leetcode.com/problems/balanced-binary-tree/description/
fun isBalanced(root: TreeNode?): Boolean {

    fun traverse(root: TreeNode?): Int {
        if (root == null) return 0

        val left = traverse(root.left)
        val right = traverse(root.right)

        if (left == Int.MAX_VALUE || right == Int.MAX_VALUE)
            return Int.MAX_VALUE

        if (abs(left - right) >= 1)
            return Int.MAX_VALUE

        return 1 + max(left, right)
    }

    return traverse(root) != Int.MAX_VALUE
}