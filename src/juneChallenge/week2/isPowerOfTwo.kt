package juneChallenge.week2

/**
 * leetcode problem
 * https://leetcode.com/problems/power-of-two/
 */

fun isPowerOfTwo(n: Int): Boolean {
    return if(n <=0)
        false;
    else
        (( n and (n-1) ) == 0)
}