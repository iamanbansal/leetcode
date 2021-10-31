package medium

/*
https://leetcode.com/problems/divide-two-integers/
 */

fun divide(dividend: Long, divisor: Long): Long {
    var dividend = dividend
    var divisor = divisor
    val sign = if ((dividend < 0) xor
        (divisor < 0)
    ) -1 else 1.toLong()

    dividend = Math.abs(dividend)
    divisor = Math.abs(divisor)

    var quotient: Long = 0
    var temp: Long = 0

    for (i in 31 downTo 0) {
        if (temp + (divisor shl i) <= dividend) {
            temp += divisor shl i
            quotient = quotient or (1L shl i)
        }
    }

    if (sign == -1L) quotient = -quotient
    return quotient
}


fun main() {
    val a = 10
    val b = 3
    println(divide(a.toLong(), b.toLong()))
    val a1 = 43
    val b1 = -8
    println(divide(a1.toLong(), b1.toLong()))
}