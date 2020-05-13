package mayChallenge.week2

/**
 * Leetcode problem
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */


fun singleNonDuplicate(nums: IntArray): Int {
    var max = nums.size-1
    var min = 0
    var mid  = 0

    if(max==0)
        return nums[0]
    else if(nums[0]!=nums[1])
        return nums[0]
    else if (nums[max]!=nums[max-1])
        return nums[max]

    while (min <= max) {
        mid = min + (max-min)/2
        if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1])
            return nums[mid]

        if(((mid % 2)==0 && nums[mid]==nums[mid+1])
            || ((mid%2)==1 && nums[mid]==nums[mid-1]))

            min = mid+1

        else
            max= mid-1
    }
    return -1
}



fun singleNonDuplicate2(nums: IntArray): Int {
    var low = 0
    var high = nums.size - 1
    while(low < high){
        var mid = low + (high - low)/2
        if(mid % 2 == 1) mid--

        if(nums[mid] == nums[mid + 1]){
            low = mid + 2
        }else high = mid
    }

    return nums[high]
}