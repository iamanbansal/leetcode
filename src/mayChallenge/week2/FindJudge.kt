package mayChallenge.week2

/**
 * Leetcode problem
 * https://leetcode.com/problems/find-the-town-judge/
 */

fun main() {
    println(
        findJudge2(
            4,
            arrayOf(intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(2, 4), intArrayOf(4, 3))
        )
    )
}

fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val arr = Array(n + 1) { Pair(0, 0) }

    trust.forEach {
        val a = arr[it[0]]
        arr[it[0]] = a.copy(first = a.first + 1)

        val b = arr[it[1]]
        arr[it[1]] = b.copy(second = b.second + 1)
    }

    for (i in 1..n) {
        if (arr[i].first == 0 && arr[i].second == n - 1)
            return i
    }

    return -1
}

fun findJudge2(N: Int, trust: Array<IntArray>): Int {
    val trustCounts = IntArray(N + 1)
    for (i in trust) {
        trustCounts[i[0]]--
        trustCounts[i[1]]++
    }

    for (i in 1..N) {
        if (trustCounts[i] == N - 1) return i
    }
    return -1
}