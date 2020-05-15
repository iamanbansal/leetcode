package mayChallenge.week2

data class TrieNode(val links : MutableMap<Char, TrieNode>, var isWord: Boolean = false)

class Trie() {
    private val rootTrieNode = TrieNode(HashMap(), false)

    fun insert(word: String) {
        var currentTrieNode = rootTrieNode
        for (letter in word) {
            currentTrieNode = if (currentTrieNode.links.containsKey(letter)) {
                currentTrieNode.links.get(letter)!!
            } else {
                val newTrieNode = TrieNode(HashMap(), false)
                currentTrieNode.links.put(letter, newTrieNode)
                newTrieNode
            }
        }
        currentTrieNode.isWord = true
    }

    fun search(word: String): Boolean {
        var currentTrieNode = rootTrieNode
        var isWordFound = true
        for (letter in word) {
            if (currentTrieNode.links.containsKey(letter)) {
                currentTrieNode = currentTrieNode.links[letter]!!
            } else {
                isWordFound = false
                break
            }
        }
        return isWordFound && currentTrieNode.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var currentTrieNode = rootTrieNode
        var isWordWithPrefixInTrie = true
        for (letter in prefix) {
            if (currentTrieNode.links.containsKey(letter)) {
                currentTrieNode = currentTrieNode.links[letter]!!
            } else {
                isWordWithPrefixInTrie = false
                break
            }
        }
        return isWordWithPrefixInTrie
    }
}