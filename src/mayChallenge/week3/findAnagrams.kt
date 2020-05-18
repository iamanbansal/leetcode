package mayChallenge.week3

fun main() {
    print(findAnagrams("cbaebabacd","abc"))
}

fun findAnagrams(s: String, p: String): List<Int> {
    val list = mutableListOf<Int>()
    val window = p.length
    val size = s.length
    if (size < window) return list

    val pHash = getMap(p)
    var start = 0
    var end = 0
    var diff = pHash.size
    while (start < size) {
        val c = s[start++]
        if (pHash.containsKey(c)) {
            if (pHash[c]!! - 1 == 0) diff--
            pHash[c] = pHash[c]!! - 1
        }
        if (start > window) {
            val d = s[end++]
            if (pHash.containsKey(d)) {
                if (pHash[d]!! == 0) diff++
                pHash[d] = pHash[d]!! + 1
            }
        }
        if (diff == 0) list.add(end)
    }

    return list
}

fun getMap(str: String): HashMap<Char, Int> {
    val map = HashMap<Char, Int>()
    str.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    return map
}