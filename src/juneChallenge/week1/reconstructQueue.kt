package juneChallenge.week1

import java.util.ArrayList
import java.util.Arrays

/**
 * leetcode problem
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */

fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    Arrays.sort(people) { a, b -> if (a[0] != b[0]) b[0] - a[0] else a[1] - b[1] }

    val result = ArrayList<IntArray>(people.size)
    for (person in people)
        result.add(person[1], person)
    return result.toTypedArray()

}