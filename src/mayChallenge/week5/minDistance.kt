package mayChallenge.week5

fun minDistance(word1: String, word2: String): Int {
        val n = word1.length
        val m = word2.length
        val result = Array(n + 1) { index1 ->
            IntArray(m + 1) { index2 ->
                when {
                    index1 == 0 -> index2
                    index2 == 0 -> index1
                    else -> 0
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                result[i + 1][j + 1] = if (word1[i] == word2[j]) result[i][j] else 1 + minOf(result[i][j], minOf(result[i][j + 1], result[i + 1][j]))
            }
        }
        return result[n][m] 
    }