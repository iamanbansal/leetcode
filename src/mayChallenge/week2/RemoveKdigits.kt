package mayChallenge.week2

import java.util.*
import kotlin.system.measureTimeMillis

/**
 * leetcode problem
 * https://leetcode.com/problems/remove-k-digits/
 */
fun main() {
    println("my solution time :"+ measureTimeMillis { removeKdigits("1432219", 3) })
    println("leetcode solution time :"+measureTimeMillis { removeKdigits2("1432219", 3) })
}

// My soulution using stack
fun removeKdigits(num: String, k: Int): String {
    val stack = Stack<Char>()
    var count = k

    for (c in num) {
        while (stack.isNotEmpty() && count > 0 && stack.peek() > c) {
            stack.pop(); count -= 1
        }

        if (stack.isEmpty() || c != '0')
            stack.push(c)
    }

    while (count > 0 && stack.isNotEmpty()) {
        stack.pop(); count -= 1
    }

    if (stack.empty())
        return "0"

    var result = ""
    while (stack.isNotEmpty())
        result = stack.pop() + result

    return result
}

// Solution using list (Most optimised kotlin submission acc. to leetcode)
fun removeKdigits2(num: String, k: Int): String {
    var toDelete: Int = k
    val stack: MutableList<Char> = mutableListOf()
    num.forEach { char ->
        if (stack.isNotEmpty()) {
            while (toDelete > 0 && stack.isNotEmpty() && char < stack.last()) {
                stack.removeAt(stack.lastIndex)
                toDelete--
            }
        }
        stack.add(char)
    }
    while (toDelete > 0 && stack.isNotEmpty()) {
        stack.removeAt(stack.lastIndex)
        toDelete--
    }
    while (stack.isNotEmpty() && stack[0] == '0') {
        stack.removeAt(0)
    }
    return if (stack.isEmpty()) "0" else stack.joinToString("")
}

