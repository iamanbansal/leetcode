package dp

import kotlin.math.max
import kotlin.math.min


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/


fun main() {
    print(maxProfit3(intArrayOf(2, 3, 4, 2, 1, 2,3, 2, 4)))
    print(maxProfit3(intArrayOf(1,2,3,4,5)))
}


fun maxProfit3(prices: IntArray): Int {
    if (prices.isEmpty()) return 0
    val leftMaxProfit = getLeftMaxProfit(prices)
    val rightMaxProfit = getRightMaxProfit(prices)
    var profit = max(leftMaxProfit.last(),rightMaxProfit[0])
    for (i in 0 until prices.size - 1) {
        profit = max(profit, leftMaxProfit[i] + rightMaxProfit[i + 1])
    }
    return profit
}

fun getRightMaxProfit(prices: IntArray): IntArray {
    val arr = IntArray(prices.size)
    var max = prices.last()

    for (i in prices.size - 2 downTo 0) {
        arr[i] = max(arr[i + 1], max - prices[i])
        max = max(max, prices[i])
    }

    return arr
}

fun getLeftMaxProfit(prices: IntArray): IntArray {
    val arr = IntArray(prices.size)
    var min = prices[0]
    for (i in 1 until prices.size) {
        arr[i] = max(arr[i - 1], prices[i] - min)
        min = min(min, prices[i])
    }
    return arr
}