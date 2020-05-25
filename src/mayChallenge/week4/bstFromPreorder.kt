package mayChallenge.week4

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


fun bstFromPreOrder(preOrder: IntArray): TreeNode? {
    val size = preOrder.size

    fun buildBST(curr: TreeNode, i: Int, minValue: Int, maxValue: Int): Int {

        //boundary check
        var pos = i
        if (pos == size || preOrder[pos] < minValue || preOrder[pos] > maxValue)
            return pos

        // filling left node
        if (preOrder[pos] < curr.`val`) {
            curr.left = TreeNode(preOrder[pos])
            pos++
            pos = buildBST(curr.left!!, pos, minValue, curr.`val` - 1)
        }

        // boundary check
        if (pos == size || preOrder[pos] < minValue || preOrder[pos] > maxValue)
            return pos

        // filling right node
        curr.right = TreeNode(preOrder[pos])
        pos++
        pos = buildBST(curr.right!!, pos, curr.`val` + 1, maxValue)

        return pos
    }

    return when (size) {
        0 -> null
        1 -> TreeNode(preOrder[0])
        else -> {
            val root = TreeNode(preOrder[0])
            buildBST(root, 1, Int.MIN_VALUE, Int.MAX_VALUE)
            root
        }
    }
}

