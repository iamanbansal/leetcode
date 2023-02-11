package dp


//https://leetcode.com/problems/maximum-profit-in-job-scheduling/


fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    class Jobs(val startTime: Int, val endTime: Int, val profit: Int)

    val memo = Array<Int>(50000) { -1 }
    val arr = Array<Jobs>(startTime.size) {
        Jobs(startTime[it], endTime[it], profit[it])
    }

    arr.sortBy { it.startTime }

    //binary search for next job profit, next job start time >= curr end time
    fun findNext(arr: Array<Jobs>, i: Int, endTime: Int): Int {
        var l = i
        var r = arr.lastIndex
        var m: Int
        while (l <= r) {
            m = l + (r - l) / 2

            if (arr[m].startTime >= endTime) {
                r = m - 1
            } else {
                l = m + 1
            }
        }
        return r
    }

    fun solve(arr: Array<Jobs>, i: Int): Int {
        if (i > arr.lastIndex) return 0
        if (memo[i] != -1) return memo[i]

        val nextIndex = findNext(arr, i + 1, arr[i].endTime)
        val currMaxProfit = arr[i].profit + solve(arr, nextIndex)
        val nextMaxProfit = solve(arr, i + 1)

        memo[i] = Math.max(currMaxProfit, nextMaxProfit)
        return memo[i]
    }

    return solve(arr, 0)
}
