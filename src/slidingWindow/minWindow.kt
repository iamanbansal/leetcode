package slidingWindow

//https://leetcode.com/problems/minimum-window-substring/submissions/873623055/

fun main() {
    print(minWindow(s = "ADOBECODEBANC", t = "ABC"))
}

fun minWindow(s: String, t: String): String {

    val tCharCounts = HashMap<Char, Int>()

    t.forEach {
        tCharCounts[it] = tCharCounts.getOrDefault(it, 0) + 1
    }

    var tCount = 0
    var left = 0
    var ans = Int.MAX_VALUE
    var start = 0

    for (right in s.indices) {

        //still finding the char
        if (tCharCounts.getOrDefault(s[right], 0) > 0) {
            tCount++
        }

        //found it decrement it
        if (tCharCounts.containsKey(s[right])) {
            tCharCounts[s[right]] = tCharCounts.getOrDefault(s[right], 0) - 1
        }

        if (tCount == t.length) {

//            move left to right ignore all non required char and searchable element with negative count means it already
//            current substring. Move till searchable element with count 0 then break without incrementing left, further
//            code will do that

            while (left < right) {
                if (tCharCounts.containsKey(s[left])) {
                    if (tCharCounts.getOrDefault(s[left], 0) < 0)
                        tCharCounts[s[left]] = tCharCounts.getOrDefault(s[left], 0) + 1
                    else
                        break
                }
                left++
            }

//            set min substring length
            if (ans > (right - left)) {
                start = left
                ans = right - left + 1
            }

            //now start searching left most char(searchable chat) in substring, make it searchable by adding 1, decrement
            // count, move left to next
            if (tCharCounts.containsKey(s[left])) {
                tCharCounts[s[left]] = tCharCounts.getOrDefault(s[left], 0) + 1
            }
            left++
            tCount--

        }
    }

    return if (ans == Int.MAX_VALUE) "" else s.substring(start, start + ans)

}


