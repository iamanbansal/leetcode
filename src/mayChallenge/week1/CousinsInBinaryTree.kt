package mayChallenge.week1

/**
 * leetcode problem
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    if (root == null) {
        return false
    }
    val levelX = getLevel(root, x, y, 0)
    val levelY = getLevel(root, y, x, 0)
    return if (levelX == 0 || levelY == 0) {
        false
    } else levelX == levelY
}

fun getLevel(root: TreeNode?, target: Int, other: Int, level: Int): Int {
    if (root == null) {
        return 0
    }
    if (root.`val` == target) {
        return level
    }
    if (root.left != null && root.right != null) {
        if (root.left!!.`val` == target && root.right!!.`val` == other || root.left!!.`val` == other && root.right!!.`val` == target) {
            return 0
        }
    }

    val downLevel = getLevel(root.left, target, other, level + 1)
    return if (downLevel != 0) {
        downLevel
    } else getLevel(root.right, target, other, level + 1)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}