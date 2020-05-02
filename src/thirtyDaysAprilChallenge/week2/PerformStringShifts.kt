package thirtyDaysAprilChallenge.week2

/*
You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

    direction can be 0 (for left shift) or 1 (for right shift).
    amount is the amount by which string s is to be shifted.
    A left shift by 1 means remove the first character of s and append it to the end.
    Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.

Return the final string after all operations.
*/

fun main() {
    val s = "asdfghjkl"
    var arr = arrayOf(
        intArrayOf(1, 1), intArrayOf(0, 4), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(0, 6), intArrayOf(1, 7),
        intArrayOf(0, 2)
    )
    println(stringShift(s, arr))

}

fun stringShift(s: String, shift: Array<IntArray>): String {
    var value = 0
    shift.forEach {
        value += if (it[0] == 0) -it[1] else it[1]
    }
    val length = s.length
    value %= length
    println("value=$value")
    return if (value > 0) {
        s.substring(length - value) + s.substring(0, length - value)
    } else {
        s.substring(-value) + s.substring(0, -value)
    }
}

