package tree

import juneChallenge.week1.TreeNode
import java.util.*


//https://leetcode.com/problems/binary-tree-right-side-view/
fun rightView(root: TreeNode?): List<Int> {
    val queue: Queue<TreeNode> = LinkedList()
    val list = arrayListOf<Int>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val temp = queue.poll()
            if(temp!=null){
                if (i == size) {
                    list.add(temp.`val`)
                }
                if (temp.left != null) queue.add(temp.left)
                if (temp.right != null) queue.add(temp.right)
            }
        }
    }

    return list
}