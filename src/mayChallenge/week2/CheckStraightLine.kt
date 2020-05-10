package mayChallenge.week2


/**
 * Leetcode problem
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */

fun checkStraightLine(coordinates: Array<IntArray>): Boolean {

    if(coordinates.size<=2)return true
    val deltaX= coordinates[1][0]-coordinates[0][0]
    val deltaY= coordinates[1][1]-coordinates[0][1]
    var curDeltaX=0
    var curDeltaY=0
    for (i in 2 until coordinates.size) {

        curDeltaX=coordinates[i][0] - coordinates[i - 1][0]
        curDeltaY=coordinates[i][1] - coordinates[i - 1][1]

        if(curDeltaX==0 && curDeltaY==0) continue

        if(curDeltaX*deltaY != curDeltaY*deltaX)
            return false
    }

    return true
}