package dp

import kotlin.math.max
import kotlin.math.min

//https://leetcode.com/problems/maximum-product-subarray/
fun maxProduct(nums: IntArray): Int {

    var max = nums.max()
    var currMin = 1
    var currMax = 1
    var tempMax = 1
    nums.forEach {
        if (it == 0) {
            currMin = 1
            currMax = 1
            return@forEach
        }
        tempMax = currMax * it
        currMax = max(tempMax, max(currMin * it, it))
        currMax = min(tempMax, min(currMin * it, it))

        max = max(currMax, currMin)
    }
    return max
}
