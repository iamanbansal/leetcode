package juneChallenge.week1

import java.util.Arrays


fun twoCitySchedCost(costs: Array<IntArray>): Int {
    Arrays.sort(costs) { a, b -> a[0] - a[1] - (b[0] - b[1]) }

    var sum = 0
    for (i in costs.indices) {
        sum += if (i < costs.size / 2) {
            costs[i][0]
        } else {
            costs[i][1]
        }
    }
    return sum
}