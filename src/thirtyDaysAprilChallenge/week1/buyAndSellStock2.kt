package thirtyDaysAprilChallenge.week1

import kotlin.system.measureTimeMillis


/*
*  LeetCode Problem
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/


fun main(){
    println(measureTimeMillis { maxProfit(intArrayOf(7,1,5,3,6,4))})
}

fun maxProfit(prices: IntArray): Int {
    if(prices.isEmpty()) return 0

    var l:Int?= null
    var h:Int? = null
    var profit = 0

    for (i in prices.indices) {
        if(h==null && (l==null ||  prices[i]< l)){
            l=prices[i]
        } else if(h==null || prices[i]> h){
            h=prices[i]
        }else{
            profit+=(h -l!!)
            l = prices[i]
            h=null
        }
    }
    h?.let { profit+=(h -l!!) }
    return profit
}