import kotlin.math.max

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

fun maxProfit(prices: IntArray): Int {

    var left = 0
    var profit = 0
    if (prices.size < 2) return 0

    for (i in 1..prices.lastIndex) {
        if (prices[left] > prices[i]) {
            left = i
        } else {
            profit = max(profit, prices[i] - prices[left])
        }
    }
    return profit
}