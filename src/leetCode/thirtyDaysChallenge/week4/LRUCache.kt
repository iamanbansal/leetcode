package leetCode.thirtyDaysChallenge.week4

import kotlin.collections.LinkedHashMap

fun main() {
    val cache = LRUCache(2 /* capacity */)

    println(cache.put(1, 1))
    println(cache.put(2, 2))
    println(cache.get(1))   // returns 1
    println(cache.put(3, 3))  // evicts key 2
    println(cache.get(2)) // returns -1 (not found)
    println(cache.put(4, 4))// evicts key 1
    println(cache.get(1)) // returns -1 (not found)
    println(cache.get(3))// returns 3
    println(cache.get(4))
}

class LRUCache(private val capacity: Int) {

    private val cacheMap = LinkedHashMap<Int, Int>(capacity)
    fun get(key: Int): Int {
        var result = -1
        if (cacheMap.containsKey(key)) {
            result = cacheMap.remove(key)!!
            cacheMap[key] = result
        }
        return result
    }

    fun put(key: Int, value: Int) {
        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key)
        } else {
            if (cacheMap.size == capacity) {
                val firstKey = cacheMap.keys.iterator().next() // this will give the first key
                cacheMap.remove(firstKey)
            }
        }
        cacheMap[key] = value
    }
}