package juneChallenge.week3

import java.util.HashMap


fun longestDupSubstring(S: String): String? {
    var l = 0
    var r = S.length - 1

    while (l < r) {
        val m = l + (r - l + 1 shr 1)

        if (isDuplicatePresent(S, m)) {
            l = m
        } else {
            r = m - 1
        }
    }

    return findDuplicate(S, l)
}

private fun isDuplicatePresent(S: String, length: Int): Boolean {
    return if (length == 0) true else findDuplicate(S, length) != null

}

private fun findDuplicate(S: String, length: Int): String? {
    var hash: Long = 0
    val prime: Long = 29
    var firstEntryPower: Long = 1
    for (i in 0 until length) {
        firstEntryPower *= prime
        hash = hash * prime + (S[i] - 'a')
    }

    val map = HashMap<Long, Int>()
    map[hash] = 0

    for (i in length until S.length) {
        hash = hash * prime + (S[i] - 'a')
        hash -= firstEntryPower * (S[i - length] - 'a')

        if (map.containsKey(hash)) {
            val index = map[hash]
            return S.substring(index!!, index + length)
        }

        map[hash] = i - length + 1
    }

    return null
}