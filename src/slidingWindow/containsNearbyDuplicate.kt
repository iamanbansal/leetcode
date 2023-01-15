package slidingWindow

//https://leetcode.com/problems/contains-duplicate-ii/
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val set = HashSet<Int>()

    for (index in nums.indices) {

        if (index > k) set.remove(nums[index - k - 1])

        if (!set.add(nums[index])) return true

    }

    return false
}
