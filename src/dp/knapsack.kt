package dp

import kotlin.math.max

fun maxProfitKnapSack(values: IntArray, weights: IntArray, n: Int, w: Int): Int {
    fun addMaxProfit(index: Int, currWeight: Int): Int {
        if (index >= values.size) return 0

        var profit = addMaxProfit(index + 1, currWeight)

        if (currWeight - weights[index] >= 0) {
            profit = max(profit, values[index] + addMaxProfit(index + 1, currWeight - weights[index]))
        }

        return profit
    }

    return addMaxProfit(0, w)
}