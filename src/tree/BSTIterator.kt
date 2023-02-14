package tree

import juneChallenge.week1.TreeNode
import java.util.Queue
import java.util.LinkedList

//https://leetcode.com/problems/binary-search-tree-iterator/


class BSTIterator(private val root: TreeNode) {
    private var currQueue: Queue<TreeNode> = LinkedList()
    private var nextQueue: Queue<TreeNode> = LinkedList()

    init {
        currQueue.add(root)
    }

    fun hasNext(): Boolean {
        return nextQueue.isNotEmpty()
    }

    fun next(): TreeNode {
        val next = currQueue.poll()

        if (next.right != null) nextQueue.add(next.right)
        if (next.left != null) nextQueue.add(next.left)

        if (currQueue.isEmpty()) {
            currQueue = nextQueue
            nextQueue = LinkedList()
        }

        return next
    }
}
