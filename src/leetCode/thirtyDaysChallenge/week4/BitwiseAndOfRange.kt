package leetCode.thirtyDaysChallenge.week4


/*
*  LeetCode Problem
*  https://leetcode.com/problems/bitwise-and-of-numbers-range/
*/


fun main() {
    println(rangeBitwiseAnd(17, 19))
}

fun rangeBitwiseAnd(m: Int, n: Int): Int {
    var result = n
    while (m < result) {
        result -= (result and -result)
    }
    return result
}