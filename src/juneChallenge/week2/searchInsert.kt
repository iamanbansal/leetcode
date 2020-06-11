package juneChallenge.week2

/**
 * leetcode problem
 * https://leetcode.com/problems/search-insert-position/
 */

fun searchInsert(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return 0
    var left = 0
    var right = nums.size - 1
    var mid = 0
    while (left <= right) {
        mid = left + (right - left) / 2
        when {
            nums[mid] == target -> return mid
            nums[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return left
}