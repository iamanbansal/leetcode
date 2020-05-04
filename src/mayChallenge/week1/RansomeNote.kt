package mayChallenge.week1

/**
 * Leetcode problem
 * https://leetcode.com/problems/ransom-note/
 */

fun main() {
    println(canConstruct("qazwsxedc","qwertyasdfgzxcvyuioplkjhgmnbv"))
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val magazineMap = HashMap<Char, Int>()
    magazine.forEach {
        magazineMap[it] = magazineMap.getOrDefault(it, 0) + 1
    }

    ransomNote.forEach {
        if (magazineMap[it] == null || magazineMap[it] == 0) {
            return false
        } else {
            magazineMap[it] = magazineMap[it]!! - 1
        }
    }
    return true
}


//Using array
fun canConstruct2(ransomNote: String, magazine: String): Boolean {
    val chars = IntArray(26) { 0 }

    for (i in magazine.indices) {
        chars[magazine[i] - 'a']++
    }

    for (i in ransomNote.indices) {
        if (--chars[ransomNote[i] - 'a'] < 0) {
            return false
        }
    }

    return true
}