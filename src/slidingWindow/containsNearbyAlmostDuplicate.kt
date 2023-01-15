package slidingWindow

import java.util.TreeSet



//https://leetcode.com/problems/contains-duplicate-iii/
fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    val set = TreeSet<Int>()

    for (i in nums.indices) {
        val floor = set.floor(nums[i])
        if (floor != null && nums[i] - floor <= valueDiff) {
            return true
        }

        val ceil = set.ceiling(nums[i])

        if (ceil != null && ceil - nums[i] <= valueDiff) {
            return true
        }

        set.add(nums[i])
        if (set.size > indexDiff) {
            set.remove(nums[i - indexDiff])
        }
    }

    return false
}