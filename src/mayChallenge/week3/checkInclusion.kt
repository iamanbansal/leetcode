package mayChallenge.week3


/**
 * Leetcode problem
 * https://leetcode.com/problems/permutation-in-string/
 */

fun main() {
    println(checkInclusion("ab", "eidboaoo"))
}

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s2.length < s1.length) return false
    val s1Hash = Array(26) { 0 }
    val s2Hash = Array(26) { 0 }
    var start = 0
    var end = 0
    val s1Len = s1.length
    val s2Len = s2.length

    while (end < s1Len) {
        s1Hash[s1[end] - 'a']++
        s2Hash[s2[end++] - 'a']++
    }
    while (end <=s2Len) {
        if (s1Hash.contentEquals(s2Hash)) return true
        if(end<s2Len){
            s2Hash[s2[end] - 'a']++
            s2Hash[s2[start] - 'a']--
        }
        end++
        start++
    }
    return false
}


/**
 * This will give TLE
 */
fun checkInclusion2(s1: String, s2: String): Boolean {
    if (s2.length < s1.length) return false

    val s1Map = getCharFrequencyMap(s1)
    val s2Map = getCharFrequencyMap(s2)

    var result = true
    s1Map.keys.forEach {
        if (s1Map[it] != s2Map[it]) {
            result = false
            return@forEach
        }
    }
    return result
}

fun getCharFrequencyMap(str: String): HashMap<Char, Int> {
    val map = HashMap<Char, Int>()
    str.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    return map
}