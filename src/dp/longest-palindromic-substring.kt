package dp

//https://leetcode.com/problems/longest-palindromic-substring/

fun main() {
    println(longestPalindrome("abbabbabc"))
    println(longestPalindrome("b"))
    println(longestPalindrome("abcda"))
    println(longestPalindrome("aaaabbaa"))
}

fun longestPalindrome(s: String): String {
    val dp = Array(s.length) { IntArray(s.length) }
    var maxLength = 1
    for (i in dp.indices) {
        dp[i][i] = 1
    }

    var start = 0
    for (i in 0 until dp.lastIndex) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = 1
            start = i
            maxLength = 2
        }
    }

    for (k in 3..dp.size) {
        for (i in 0..dp.size - k) {
            val j = i + k - 1
            if (dp[i + 1][j - 1] == 1 && s[i] == s[j]) {
                dp[i][j] = 1
                start = i
                maxLength = k
            }
        }
    }

    return s.substring(start, start + maxLength)
}
