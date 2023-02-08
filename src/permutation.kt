//https://leetcode.com/problems/permutations/description/

fun permute(nums: IntArray): List<List<Int>> {

    val result = ArrayList<List<Int>>()
    val ds = ArrayList<Int>()
    val numTracker = BooleanArray(nums.size)

    getPermutations(nums, ds, numTracker, result)
    return result
}

fun getPermutations(
    nums: IntArray,
    ds: java.util.ArrayList<Int>,
    numTracker: BooleanArray,
    result: ArrayList<List<Int>>
) {

    if (ds.size == nums.size) {
        result.add(ArrayList(ds))
        return
    }

    for (i in nums.indices) {
        if (numTracker[i].not()) {
            numTracker[i] = true
            ds.add(nums[i])
            getPermutations(nums, ds, numTracker, result)
            ds.removeAt(ds.size-1)
            numTracker[i] = false
        }
    }

}