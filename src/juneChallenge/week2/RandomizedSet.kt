package juneChallenge.week2

import kotlin.random.Random

class RandomizedSet() {
    /** Initialize your data structure here. */
    private var list: ArrayList<Int> = ArrayList()
    private var mp: MutableMap<Int, Int> = HashMap()
    private val random = Random.Default

    /**
     * leetcode problem
     * https://leetcode.com/problems/insert-delete-getrandom-o1/
     */

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(v: Int): Boolean {
        if (mp.containsKey(v)) return false
        mp[v] = list.size
        list.add(v)
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(v: Int): Boolean {
        if (!mp.containsKey(v)) return false
        val pos = mp[v]
        list[pos!!] = list[list.lastIndex]
        list.removeAt(list.lastIndex)
        mp.remove(v)
        if (pos < list.size)
            mp[list[pos]] = pos
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        return list[random.nextInt(list.size)]
    }
}