package leetCode.thirtyDaysChallenge.week1

/*
*  LeetCode Problem
* https://leetcode.com/problems/single-number/
*/

fun main(){
    println(singleNumber(arrayOf(2,7,3,6,2,4,6,7,3)))
}

fun singleNumber(arr: Array<Int>): Int {
    for(i in 1 until arr.size){
        arr[0] = arr[0].xor(arr[i])
    }
    return arr[0]
}