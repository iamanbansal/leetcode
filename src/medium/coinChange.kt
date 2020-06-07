package medium

import thirtyDaysAprilChallenge.week2.dia
import kotlin.math.min


/**
 * Leetcode problem
 * https://leetcode.com/problems/coin-change/
 */
fun coinChange(coins: IntArray, amount: Int): Int {

    val arr = IntArray(amount + 1){amount+1}
    arr[0]=0
    for (i in arr.indices) {
        for (coin in coins) {
            if (coin <= i) {
                arr[i]= min(arr[i],1+arr[i-coin])
            }
        }
    }

    return if(arr[amount]>amount) return -1
    else arr[amount]
}