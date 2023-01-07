import juneChallenge.week1.TreeNode

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

    if (root == null || root.`val` == p?.`val` || root.`val` == q?.`val`) return root

    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    return if (left == null) right
    else if (right == null) left
    else root

}