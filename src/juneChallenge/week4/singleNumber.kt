package juneChallenge.week4

/**
 * leetcode problem
 * https://leetcode.com/problems/single-number-ii/
 */
fun main() {
    println(singleNumber(intArrayOf(-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28)))
}
fun singleNumber(nums: IntArray): Int {
    if(nums.size<3) return nums[0]
    nums.sort()
    if(nums[0]!=nums[1]) return nums[0]
    if(nums[nums.size-1]!=nums[nums.size-2]) return nums[nums.size-1]
    var i =1
    while (i < nums.size-1) {
        if(nums[i]!=nums[i-1]) return nums[i-1]
        i+=3
    }
    return nums[nums.size-1]
}