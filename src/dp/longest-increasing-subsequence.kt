package dp

//https://leetcode.com/problems/longest-increasing-subsequence/

fun main() {
    print(lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
    print(lengthOfLIS(intArrayOf(5,8,7,1,9)))
    print(lengthOfLIS(intArrayOf(3,4,2,5,2,6,8,22,8,2,6,7,2,5,8,2,4,5,6,2,4,6,7,3,3,3,4556,66,6,7)))
}
fun lengthOfLIS(nums: IntArray): Int {
    if(nums.isEmpty()) return 0
    if(nums.size==1) return 1

    val arr = IntArray(nums.size)
    arr[0] = 1
    var max=1
    for (i in 1 until arr.size) {

        for (j in 0 until i){
            if (nums[i] > nums[j] && arr[j] >= arr[i]) {
                arr[i] = arr[j]+1
                if(arr[i]>max) max = arr[i]
            }
        }
        if(arr[i]==0) arr[i]=1
    }
    return max
}