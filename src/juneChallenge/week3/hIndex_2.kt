package juneChallenge.week3

fun hIndex(citations: IntArray): Int {
    val len = citations.size
    var lo = 0
    var hi = len - 1
    while (lo <= hi) {
        val med = (hi + lo) / 2
        if (citations[med] == len - med) {
            return len - med
        } else if (citations[med] < len - med) {
            lo = med + 1
        } else {
            hi = med - 1
        }
    }
    return len - lo
}