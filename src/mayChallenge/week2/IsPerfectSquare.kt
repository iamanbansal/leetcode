package mayChallenge.week2


/**
 * Leetcode problem
 * https://leetcode.com/problems/valid-perfect-square/
 */

fun main() {
    println(isPerfectSquare(49))
}

fun isPerfectSquare(num: Int): Boolean {
    var max = num/2
    var min = 1
    var mid = 0
    var res =  0
    while (min <= max) {
        mid = min + (max-min)/2
        res= (mid*mid)
        if (res==num) return true
        else if (res>num) max=mid-1
        else min = mid+1
    }

    return false
}

fun isPerfectSquare2(num: Int): Boolean {
    var res = num.toLong()
    while(res*res>num){
        res = (res + num/res)/2
    }

    return res*res==num.toLong()
}
