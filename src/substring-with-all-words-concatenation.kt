fun main() {

    val list = findSubstring("barfoothefoobarman", arrayOf("foo","bar"))
//    val list = findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","good"))

    print(list)
}

fun findSubstring(s: String, words: Array<String>): List<Int> {
    val count = hashMapOf<String, Int>()
    words.forEach {
        count[it] = count.getOrDefault(it, 0) + 1
    }

    val itemLength = words.first().length

    val temp = hashMapOf<String, Int>()

    val list = arrayListOf<Int>()
    for (i in 0..(s.length - (count.size * itemLength))) {
        temp.putAll(count)
        var sCount = 0
        for (j in i..(s.length - itemLength) step itemLength) {

            val key = s.substring(j, j + itemLength)
            var value = temp[key]
            if (value != null && value != 0) {
                sCount++
                temp.put(key, value - 1)

                if (sCount == words.size) {
                    list.add(i)
                }
            } else
                break
        }
        temp.clear()
    }

    return list
}