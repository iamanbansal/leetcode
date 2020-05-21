package mayChallenge.week3

import mayChallenge.week1.TreeNode

/**
 * Leetcode
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
class KthSmallestElement {
    var k=0
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        this.k=k
       return find(root)
    }

    private fun find(root: TreeNode?): Int {
        if(root==null)return 0
        val left = find(root.left)
        if (left!=0) return left
        if(--k==0) return root.`val`
        return find(root.right)
    }
}