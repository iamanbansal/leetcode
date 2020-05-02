package thirtyDaysAprilChallenge.week1


/*
*  LeetCode Problem
* https://leetcode.com/problems/maximum-subarray/
*/


fun main(){
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}

fun maxSubArray(nums: IntArray): Int {
    var curr  = nums[0]
    var global = nums[0]
    for(i in 1 until nums.size){
        curr = Math.max(nums[i], curr+nums[i])
        if(curr>global){
            global=curr
        }
    }

    return global
}