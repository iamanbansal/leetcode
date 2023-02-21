package tree

import juneChallenge.week1.TreeNode
import java.util.*

fun getBottomView(root: TreeNode?): List<Int> {
    if (root == null) return arrayListOf()

    val queue: Queue<Pair<TreeNode, Int>> = LinkedList() //value and vertical
    val map = TreeMap<Int, Int>() //vertical-> bottom view value

    queue.add(root to 0)

    var curr: Pair<TreeNode, Int>
    while (queue.isNotEmpty()) {
        curr = queue.poll()
        map[curr.second] = curr.first.`val`

        curr?.first?.left?.let {
            queue.add(it to curr.second - 1)
        }

        curr?.first?.right?.let {
            queue.add(it to curr.second + 1)
        }


    }

    return map.values.toList()
}