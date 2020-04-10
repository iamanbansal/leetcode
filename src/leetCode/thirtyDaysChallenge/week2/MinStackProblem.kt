package leetCode.thirtyDaysChallenge.week2

import java.util.*
import kotlin.math.min

/*
*  LeetCode Problem
*  https://leetcode.com/problems/min-stack/
*/
fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.top())
    println(minStack.getMin())
}


class MinStack {
    private val stack = Stack<Array<Int>>()
    fun push(x: Int) {
        if(stack.isEmpty()){
            stack.push(arrayOf(x,x))
            return
        }
        val minNum = min(x, stack.peek()[1])
        stack.push(arrayOf(x, minNum))
    }
    fun pop() {
        stack.pop()
    }
    fun top(): Int {
        return stack.peek()[0]
    }
    fun getMin() = stack.peek()[1]
}
