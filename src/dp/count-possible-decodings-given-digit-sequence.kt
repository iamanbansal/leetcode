package dp

//https://leetcode.com/problems/decode-ways/


fun main() {
    println(numDecodings("12"))
}

fun numDecodings(s: String): Int {
    val dp = Array(s.length + 1) { 0 }
    dp[0] = 1
    dp[1] = 1
    if(s[0]=='0')   //for base condition "01123" should return 0
        return 0

    for (i in 2 until dp.size) {
        if (s[i - 1] > '0')
            dp[i] = dp[i - 1];
        if (s[i - 2] == '1' || (s[i - 2] == '2' && s[i-1] < '7')) {
            dp[i]+=dp[i-2]
        }
    }
    return dp.last()
}