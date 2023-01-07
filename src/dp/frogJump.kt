package dp

import kotlin.math.max


fun main() {
    println(canCross(intArrayOf(0, 1, 3, 5, 6, 8, 12, 17)))
}

fun canCross(stones: IntArray): Boolean {
    val map = HashMap<Int, HashSet<Int>>()
    stones.forEach {
        map[it] = HashSet()
    }

    map[0]?.add(0)

    var set: Set<Int>
    for (stone in stones) {
        set = map[stone]!!
        for (k in set) {
            if (k > 0) map[stone + k]?.add(k)
            if (k - 1 > 0) map[stone + k - 1]?.add(k - 1)
            map[stone + k + 1]?.add(k + 1)

        }

        if (map[stones.last()]!!.isNotEmpty())
            return true
    }

    return false
}