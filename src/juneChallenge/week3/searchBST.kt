package juneChallenge.week3

/**
 * leetcode problem
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
fun searchBST(root: TreeNode?, v: Int): TreeNode? {

    if (root == null)return null

    var curr = root
    while (curr != null) {
        if(curr.`val` == v) return  curr

        curr = if(curr.`val`>v)
            curr.right
        else
            curr.left
    }

    return null
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}