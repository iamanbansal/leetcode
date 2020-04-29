package leetCode.thirtyDaysChallenge.week4

import java.util.HashMap
import java.util.LinkedList
import java.util.Queue


/*
You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

    FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
    int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
    void add(int value) insert value to the queue.

* */
fun main() {
    val firstUnique = FirstUnique(intArrayOf(7,7,7,7,7,7))

    println(firstUnique.add(7))
    println(firstUnique.showFirstUnique())   // returns -1
    println(firstUnique.add(7))
    println(firstUnique.add(3))
    println(firstUnique.add(3))
    println(firstUnique.add(7))
    println(firstUnique.add(17))
    println(firstUnique.showFirstUnique()) //17
}

class FirstUnique(nums: IntArray) {
    private var queue: Queue<Int> = LinkedList()
    private var map: HashMap<Int, Int> = HashMap()

    init {
        nums.forEach { add(it) }
    }

    fun showFirstUnique(): Int {
        if (queue.isEmpty()) return -1 //if the queue is empty
        while (!queue.isEmpty()) {
            if (map.getOrDefault(queue.peek(), 0) > 1)
                queue.remove() // if the count of the first element is greater than 1 then remove from queue
            else
                return queue.peek() // else return the element
        }
        return -1 // if every element in the queue is repeated
    }

    fun add(key: Int) {
        if (map.containsKey(key))
            map[key] = map.getOrDefault(key, 0) + 1 // if the element exists increment the count in map alone
        else {
            queue.add(key) //if the element is not present then add it to the queue
            map[key] = 1 // add this element in the map and the count is 1
        }
    }
}