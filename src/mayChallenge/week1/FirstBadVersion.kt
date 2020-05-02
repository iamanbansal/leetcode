package mayChallenge.week1

/*
* Leetcode problem
* https://leetcode.com/problems/first-bad-version/
*/

fun firstBadVersion(n: Int): Int {

    var result = n
    var min = 0
    var max = n
    var mid = 0

    while (min <= max) {
        mid = min + (max-min) / 2 // to overcome the TLE with (min+max)/2
        if (isBadVersion(n)) {
            result = mid
            max = mid - 1
        } else {
            min = mid + 1
        }
    }

    return result
}

fun isBadVersion(n: Int): Boolean {
    // code to check is it bad version or not

    return true
}
