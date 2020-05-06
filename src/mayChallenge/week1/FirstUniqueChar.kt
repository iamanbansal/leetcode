package mayChallenge.week1

import kotlin.system.measureNanoTime

/**
 * Leetcode problem
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */

fun main() {
    println(firstUniqueChar("amanbansal") )
}

fun firstUniqueChar(s: String): Int {

    val array = Array(26) { 0 }
    s.forEach {
        array[it.toInt() - 97]++
    }
    s.forEachIndexed { i, c ->
        if (array[c.toInt() - 97] == 1)
            return i
    }
    return -1
}