package medium

import java.util.*


/*
https://leetcode.com/problems/sort-characters-by-frequency/
*/

fun main() {

    println(frequencySort("amanBansal"))

}

fun frequencySort(s: String): String {

    val map = hashMapOf<Char, Int>()
    for (i in s.indices) {
        map[s[i]] = (map[s[i]] ?: 0) + 1
    }

    val pQueue = PriorityQueue<Pair<Int, Char>>(compareByDescending { it.first })
    map.forEach { (char, count) ->
        pQueue.add(count to char)
    }

    val final = StringBuilder(s.length)
    var temp: Pair<Int, Char>
    while (pQueue.isNotEmpty()) {
        temp = pQueue.remove()
        final.append("${temp.second}".repeat(temp.first))
    }

    return final.toString()
}