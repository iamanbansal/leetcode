package dp

import kotlin.math.max


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//explanation: https://www.youtube.com/watch?v=4wNXkhAky3s&list=PLEJXowNB4kPzhcTNLaBgtddxRAgOnhu68


fun main() {
    print(maxProfit(intArrayOf(1,2,3,0,2)))
}


fun maxProfit(prices: IntArray): Int {
    if(prices.isEmpty())return 0
    val dp = Array(3) { IntArray(prices.size) }
    dp[0][0] = 0
    dp[1][0] = -prices[0]
    dp[2][0] = 0

    for (j in 1 until prices.size) {
        //no stock
        dp[0][j] = max(dp[0][j - 1], dp[2][j - 1])

        // in hand
        dp[1][j] = max(dp[1][j - 1], dp[0][j - 1] - prices[j])

        //sold out
        dp[2][j] = max(dp[0][j - 1], dp[1][j - 1] + prices[j])
    }

    return max(dp[0].last(), dp[2].last())
}