package juneChallenge.week1

/**
 * Leetcode problem
 * https://leetcode.com/problems/invert-binary-tree/
 */
fun invertTree(root: TreeNode?): TreeNode? {
    swap(root)
    return root
}

fun swap(root: TreeNode?) {
    if (root == null) return

    swap(root.left)
    swap(root.right)

    val temp = root.right
    root.right = root.left
    root.left = temp
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}