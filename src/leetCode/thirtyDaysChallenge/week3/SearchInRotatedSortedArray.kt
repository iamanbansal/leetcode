package leetCode.thirtyDaysChallenge.week3

/*
*  LeetCode Problem
*  https://leetcode.com/problems/search-in-rotated-sorted-array/
*/

fun main() {
    println(search(intArrayOf(2, 3, 4, 5, 6, 8, 0, 1), 5))
    println(search(intArrayOf(4,5,6,7,0,1,2), 4))
}

fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var mid = 0

    while (left <= right) {
        mid = (left + right) / 2

        if (nums[mid] == target)
            return mid
        else if (nums[mid] >= nums[left]) {
            if (target <= nums[mid] && target >= nums[left])
                right = mid - 1
            else
                left = mid + 1

        } else {
            if (target >= nums[mid] && target <= nums[right])
                left = mid + 1
            else
                right = mid - 1
        }
    }

    return -1
}