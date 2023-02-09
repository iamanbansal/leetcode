package dp


//https://leetcode.com/problems/burst-balloons/


fun maxCoins(nums: IntArray): Int {
    val list = ArrayList<Int>()
    list.add(1)
    nums.forEach {
        list.add(it)
    }
    list.add(1)

    val n = nums.size

    val memo = Array(n + 1) { IntArray(n + 1) { -1 } }

    return getPoints(1, n, list, memo)
}

fun getPoints(i: Int, j: Int, list: List<Int>, memo: Array<IntArray>): Int {
    if (i > j) return 0

    if (memo[i][j] != -1) return memo[i][j]

    var max = 0
    for (ind in i..j) {

        val coins = list[i - 1] * list[ind] * list[j + 1] +
                getPoints(i, ind - 1, list, memo) +
                getPoints(ind + 1, j, list, memo)

        max = maxOf(max, coins)
    }

    memo[i][j] = max
    return max
}
