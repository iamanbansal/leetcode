fun main() {
    val arr = intArrayOf(5, 4, 7, 8, 6, 4, 3)
    nextPermutation(arr)
    arr.forEach {
        print(it)
    }
}

fun nextPermutation(nums: IntArray): Unit {

    for (i in nums.lastIndex - 1 downTo 0) {
        //check greater next element
        for (j in i + 1..nums.lastIndex) {
            if (nums[j] > nums[i]) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                return
            }
        }

        val temp = nums[i]
        for (j in i until nums.lastIndex) {
            nums[j] = nums[j + 1]
        }
        nums[nums.lastIndex] = temp
    }
}
