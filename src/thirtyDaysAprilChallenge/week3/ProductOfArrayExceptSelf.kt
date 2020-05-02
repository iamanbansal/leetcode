package thirtyDaysAprilChallenge.week3

/*
*  LeetCode Problem
* https://leetcode.com/problems/product-of-array-except-self/
*/
fun main() {
    println(productExceptSelf(intArrayOf(1,2,3,4)).asList())
}

/*
* Approach 1
* This approach will work but leetcode want us to do it without division
*/
//fun productExceptSelf(nums: IntArray): IntArray {
//    var mul=1
//    nums.forEach {
//        mul*=it
//    }
//    for (i in nums.indices) {
//        nums[i]=mul/nums[i]
//    }
//
//    return nums
//}


/*
* Approach 2
*/

fun productExceptSelf(nums: IntArray):IntArray {
    val answer = IntArray(nums.size)
//    product of left items of i
    answer[0] = 1
    for (i in 1 until nums.size) {
        answer[i] = nums[i - 1] * answer[i - 1]
    }

//    product of right items of i
    var right = 1
    for (i in nums.size - 1 downTo 0) {
        answer[i] = answer[i] * right
        right *= nums[i]
    }
    return answer
}