package mayChallenge.week4

fun frequencySort(s: String): String {
    return s
        .split("").asSequence()
        .filter { it != "" }
        .groupingBy { it }
        .eachCount()
        .toList()
        .sortedBy { it.second }
        .reversed().joinToString("") {
            var t = ""
            for (i in 0 until it.second) {
                t += it.first
            }
            t
        }
}