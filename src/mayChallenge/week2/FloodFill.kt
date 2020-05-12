package mayChallenge.week2

import kotlin.system.measureTimeMillis

/**
 * Leetcode problem
 * https://leetcode.com/problems/flood-fill/
 */

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    if (image[sr][sc] == newColor)
        return image

    val srcColor = image[sr][sc]
    val rows = image.size
    val cols =image[sc].size

    fun dfs(sr: Int, sc: Int) {
        if (sr < 0 || sc < 0 || sr >= rows || sc >= cols) //defending boundary calls
            return
        if (image[sr][sc] != srcColor)
            return
        image[sr][sc] = newColor

        dfs(sr - 1, sc) // left
        dfs(sr + 1, sc)// right
        dfs(sr, sc - 1)// down
        dfs(sr, sc + 1) // up
    }

    dfs(sr,sc)
    return image
}

