package juneChallenge.week4

import juneChallenge.week3.TreeNode


/**
 * leetcode problem
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */

fun countNodes(root: TreeNode?): Int {


    if(root==null) return 0


    val left = getLeftCount(root?.left)
    val right = getRightCount(root?.right)

    if(left == right){
        return (1 shl left) - 1
    }else{
      return countNodes(root?.right) + countNodes(root?.left) +1
    }



}

fun getRightCount(node: TreeNode?): Int {
    if(node==null) return 0
    if(node.right == null)  return 1
    return getRightCount(node.right) + 1
}

fun getLeftCount(node: TreeNode?): Int {
    if(node==null) return 0
    if(node.left == null)  return 1
    return getRightCount(node.left) +1
}

//
//fun countNodes(root: TreeNode?): Int {
//
//    val leftDepth = leftDepth(root)
//    val rightDepth = rightDepth(root)
//
//    return if (leftDepth == rightDepth)
//        (1 shl leftDepth) - 1
//    else
//        1 + countNodes(root?.left) + countNodes(root?.right)
//
//}
//
//private fun rightDepth(root: TreeNode?): Int {
//    var root = root
//    var dep = 0
//    while (root != null) {
//        root = root.right
//        dep++
//    }
//    return dep
//}
//
//private fun leftDepth(root: TreeNode?): Int {
//    var root = root
//    var dep = 0
//    while (root != null) {
//        root = root.left
//        dep++
//    }
//    return dep
//}
//
