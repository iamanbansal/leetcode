import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

/*
*
*  https://leetcode.com/problems/word-ladder/submissions/
*/


fun main() {
    val count = ladderLength("hit", "cog", arrayListOf("hot", "dot", "dog", "lot", "log", "cog"))
//    val count = ladderLength("hit", "cog", arrayListOf("hot", "dot", "dog", "lot", "log"))
    println(count)
}

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    var count = 0
    if (beginWord == endWord) return count
    val dictionary = HashSet(wordList)

    if (!dictionary.contains(endWord)) return 0

    val queue: Queue<String> = LinkedList()
    queue.add(beginWord)
    while (queue.isNotEmpty()) {
        count++
        for (q in 0 until queue.size) {
            val str = queue.remove()
            for (i in 0 until beginWord.length) {
                val builder = StringBuilder(str)
                repeat(26) {
                    builder[i] = (97 + it).toChar()
                    val temp = builder.toString()
                    if (temp == str) return@repeat
                    if (temp == endWord) return ++count
                    if (dictionary.contains(temp)) {
                        dictionary.remove(temp)
                        queue.add(temp)
                    }
                }
            }
        }

    }

    return 0
}
