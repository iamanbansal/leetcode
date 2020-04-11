package leetCode.thirtyDaysChallenge.week1


/*
*  LeetCode Problem
* https://leetcode.com/problems/move-zeroes/
*/


fun main(){
    println(moveZeroes(intArrayOf(0,1,0,3,4,5,7,0,3,0,12)))
}

fun moveZeroes(nums: IntArray) {
    var count=0
    nums.forEach {
        if(it!=0){
            nums[count++]=it
        }
    }
    while (count < nums.size) nums[count++] = 0
    println(nums.contentToString())
}