package mayChallenge.week1


/**
 * Leetcode problem
 * https://leetcode.com/problems/majority-element/
 */

fun main() {
    println(majorityElement(intArrayOf(1,1,1,1,1,2,3,4,5)))
}


fun majorityElement(nums: IntArray): Int {
    var maj = nums[0]
    var count = 0

    for (i in 0 until nums.size) {
        if (nums[i] == maj)
            count++
        else {
            count--
            if(count==0){
                maj = nums[i]
                count++
            }
        }
    }

    return maj
}