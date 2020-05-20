package mayChallenge.week3

import java.util.*

/**
 * Leetcode problem
 * https://leetcode.com/problems/online-stock-span/solution/
 */

class StockSpanner() {

    private val stack = Stack<Pair<Int, Int>>()
    private var index = -1
    fun next(price: Int): Int {
        index++


        while (stack.isNotEmpty() && stack.peek().second < price) {
            stack.pop()
        }
        if (stack.empty()) {
            stack.push(Pair(index, price))
            return index + 1
        }

        stack.push(Pair(index, price))
        return index - stack.peek().first
    }

}