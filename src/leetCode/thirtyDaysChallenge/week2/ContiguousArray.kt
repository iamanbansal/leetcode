package leetCode.thirtyDaysChallenge.week2

import java.util.HashMap

/*
*  LeetCode Problem
* https://leetcode.com/problems/contiguous-array/
*/

fun  main(){
println(findMaxLength(intArrayOf(0,1,0,1,1,1,0,0,0,1,0)))
}

fun findMaxLength(nums: IntArray): Int {
    var sum = 0
    var max = 0
    val map = HashMap<Int, Int>()
    map[0] = -1
    for (i in 0 until nums.size) {
        sum += if (nums[i] == 0) -1 else 1
        if (map.containsKey(sum))
            max = Math.max(max, i - map[sum]!!)
        else
            map[sum] = i
    }
    return max
}