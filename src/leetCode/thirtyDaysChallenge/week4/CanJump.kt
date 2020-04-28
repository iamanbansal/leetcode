package leetCode.thirtyDaysChallenge.week4

import kotlin.math.max
import kotlin.system.measureNanoTime


/*
* Leetcode problem
* https://leetcode.com/problems/jump-game/
*/

fun main() {
    println(measureNanoTime { canJump(intArrayOf(3,2,1,0,4)) })
    println(measureNanoTime { canJump2(intArrayOf(3,2,1,0,4)) })
}
fun canJump(nums: IntArray): Boolean {
    var reachable= 0
    for(i in nums.indices){
        if(reachable<i)
            return false
        reachable = max(reachable, i+nums[i])
    }
    return true
}

fun canJump2(nums: IntArray):Boolean{
    var last = nums.size-1
    for(i in nums.size-1..0){
        if(nums[i]+i>=last)
            last=i
    }
    return last==0
}