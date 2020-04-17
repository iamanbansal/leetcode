package leetCode.thirtyDaysChallenge.week3

import java.util.*
import kotlin.system.measureTimeMillis

/*
*  LeetCode Problem
* https://leetcode.com/problems/valid-parenthesis-string/
*/
fun main() {
    println(checkValidString("((())**()()(***(((**))))))") )
    println(checkValidString2("((())**()()(***(((**))))))") )
    println(checkValidString("*(()*))"))
    println(checkValidString(")*()")) //false
    println(checkValidString("(*(**)"))
    println(checkValidString("***(()")) //false
}

fun checkValidString(s: String): Boolean {
    val openStack = Stack<Int>()
    val startStack = Stack<Int>()

    s.forEachIndexed { i, c ->
        when (c) {
            '(' -> openStack.add(i)
            ')' -> {
                when {
                    openStack.isNotEmpty() -> openStack.pop()
                    startStack.isNotEmpty() -> startStack.pop()
                    else -> return false
                }
            }
            '*' -> startStack.add(i)
        }
    }

    if (openStack.size > startStack.size) {
        return false
    }
    while (openStack.isNotEmpty()) {
        when {
            startStack.isEmpty() -> return false
            startStack.peek()> openStack.peek() -> { startStack.pop(); openStack.pop()}
            else -> return false
        }
    }
    return true
}

fun checkValidString2(s: String): Boolean {
    var open = 0
    s.forEach{
        open = if(it=='(' || it=='*'){
            open+1
        } else{
            open -1
        }
        if(open<0) return false
    }
    if(open==0) return true

    var closed = 0

    for(i in s.length-1 downTo 0){
        val it = s[i]
        closed = if(it==')' || it=='*'){
            closed+1
        } else{
            closed-1
        }
        if(closed<0) return false
    }
    return true

}