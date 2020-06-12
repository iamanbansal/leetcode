package juneChallenge.week2

/**
 * leetcode problem
 * https://leetcode.com/problems/sort-colors/
 */

fun sortColors(nums: IntArray): Unit {
    var l = 0
    var m = 0
    var h = nums.size-1
    var temp = 0

    while (m <= h) {
        when (nums[m]) {
            0 -> {
                temp = nums[m]
                nums[m]=nums[l]
                nums[l]=temp
                l++
                m++
            }
            1 -> {
                m++
            }
            2 -> {
                temp = nums[m]
                nums[m]=nums[h]
                nums[h]=temp
                h--
            }
        }
    }

}