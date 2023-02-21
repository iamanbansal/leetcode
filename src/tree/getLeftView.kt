package tree

import juneChallenge.week1.TreeNode

fun getLeftView(root: TreeNode?) {
    val list = ArrayList<Int>()
    getLeftView(root, 0, list)
}

fun getLeftView(root: TreeNode?, i: Int, list: ArrayList<Int>) {
    if (root == null) return

    if (list.size == i) {
        list.add(root.`val`)
    }

    getLeftView(root.left, i + 1, list)
    getLeftView(root.right, i + 1, list)
}