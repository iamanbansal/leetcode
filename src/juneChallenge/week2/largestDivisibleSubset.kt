package juneChallenge.week2

/**
 * leetcode problem
 * https://leetcode.com/problems/largest-divisible-subset/
 */
fun largestDivisibleSubset(nums: IntArray): List<Int> {
        
        if(nums.size==0 || nums.size==1) return nums.toList()
		//Stores the length of longest sunset till index i
        val dp: IntArray = IntArray(nums.size){1}
		//Elements in longest subset
        val result: ArrayList<Int> = arrayListOf()
		//length of longest subset so far
        var max: Int = Int.MIN_VALUE
        nums.sort()
        
		//Create dp array
        for(i: Int in 0..nums.size-1) {
            for(j: Int in 0..i-1) {
                if(nums[i]%nums[j]==0 && dp[i] < dp[j]+1) dp[i]=dp[j] + 1
                max = Math.max(max, dp[i])
            }
        }
        
		//Iterate over dp and keep adding the required elements to result list
        var temp = nums.size-1
        while(max > 0) {
            when {
                result.isEmpty() -> if(dp[temp] == max) {
                    result.add(nums[temp])
                    max--
                }
                else -> {
                    if(dp[temp] == max && result.last()%nums[temp]==0) {
                        result.add(nums[temp])
                        max--
                    }
                }
            }
            temp--
        } 
        return result.reversed()
    }