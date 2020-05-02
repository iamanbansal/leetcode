package thirtyDaysAprilChallenge.week1


/*
*  LeetCode Problem
* https://leetcode.com/problems/happy-number/
*/


fun main(){
    println(isHappy(7))
}

fun isHappy(n: Int): Boolean {
    var num = n
    var sum = 0
    var rem = 0
    var quo = 0
    while (true) {
        do {
            rem = num % 10
            quo = num / 10
            sum += (rem * rem)
            num = quo
        } while (quo != 0)
        num = sum
        sum = 0
        if (num<10){
            return num == 1 || num==7
        }
    }
}