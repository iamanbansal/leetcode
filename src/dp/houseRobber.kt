package dp

import kotlin.math.max

fun houseRobber(array: IntArray): Int {

    val arrWithFirstElement = IntArray(array.size)
    val arrWithLastElement = IntArray(array.size)

    array.forEachIndexed { index, i ->

        if (index != 0) arrWithLastElement [index] = i
        if (index != array.lastIndex) arrWithLastElement [index] = i
    }

    return max(maxOfNonAdjacentSum(arrWithFirstElement), maxOfNonAdjacentSum(arrWithLastElement))
}

fun maxOfNonAdjacentSum(num: IntArray): Int {

    var prev = num.first()
    var prev2 = 0
    var pick: Int
    var notPick: Int

    for (i in 1..num.lastIndex) {
        pick = num[i]

        if (i > 1) pick += prev2

        notPick = prev

        val cur = max(pick, notPick)
        prev2 = prev
        prev = cur
    }
    return prev
}