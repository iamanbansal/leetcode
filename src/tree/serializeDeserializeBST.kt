package tree

import juneChallenge.week1.TreeNode
import java.util.*


//https://leetcode.com/problems/serialize-and-deserialize-bst/

class Codec {
    private val SEP = ","

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {

        if (root == null) {
            return ""
        }

        val queue: Queue<TreeNode> = LinkedList()
        val stringBuilder = StringBuilder()

        queue.add(root)
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            stringBuilder.append(temp.`val`)
            stringBuilder.append(SEP)

            if (temp.`val` != -1) {
                if (temp.right != null) queue.add(temp.right)
                else queue.add(TreeNode(-1))

                if (temp.left != null) queue.add(temp.left)
                else queue.add(TreeNode(-1))
            }
        }
        print(stringBuilder.toString())
        return stringBuilder.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isBlank()) return null

        val list = data.split(SEP)

        var index = 1

        val root = TreeNode(list.first().toInt())
        var cur = root

        val queue: Queue<TreeNode> = LinkedList()

        while (index < list.size - 1) {

            var temp = list[index].toInt()
            if (temp != -1) {
                cur.right = TreeNode(temp)
                queue.add(cur.right)
            }
            index++
            temp = list[index].toInt()
            if (temp != -1) {
                cur.left = TreeNode(temp)
                queue.add(cur.left)
            }
            index++

            if (queue.isNotEmpty())
                cur = queue.poll()
        }
        return root
    }
}