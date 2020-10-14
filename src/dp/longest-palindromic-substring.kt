package dp

//https://leetcode.com/problems/longest-palindromic-substring/

fun main() {
    println(longestPalindrome("abbabbabc"))
    println(longestPalindrome("b"))
    println(longestPalindrome("abcda"))
    println(longestPalindrome("aaaabbaa"))
}

fun longestPalindrome(s: String): String {
    if (s.isBlank()) return ""
    if (s.length==1) return s
    if (s.length==2) return if (s[0]== s[1])  s else s[0].toString()

    val dp = Array(s.length) { IntArray(s.length) }
    var start = 0
    var length = 1
    for (i in 0 until dp.size) {
        dp[i][i] = 1
        if (i < dp.size - 1 && s[i] == s[i + 1]) {
            dp[i][i + 1] = 1
            start = i
            length = 2
        }

    }
    for (k in 2 until dp.size) {
        var j=k
        for (i in 0 until dp.size-k ){
            if (s[i] == s[j] && dp[i + 1][j - 1] == 1) {
                dp[i][j] = 1

                if(j - i + 1 > length) {
                    start = i
                    length = j - i + 1
                }
            }
            j++
        }
    }

    return s.substring(start, start+length)
}
