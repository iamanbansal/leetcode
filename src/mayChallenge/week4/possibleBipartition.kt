package mayChallenge.week4

import java.util.HashMap
import java.util.ArrayList


 class Solution {
    lateinit var graph:Array<ArrayList<Int>>
    lateinit var color: MutableMap<Int, Int>

    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        graph = Array(N + 1){ArrayList<Int>()}

        for (edge in dislikes) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }

        color = HashMap()
        for (node in 1..N)
            if (!color.containsKey(node) && !dfs(node, 0))
                return false
        return true
    }

    fun dfs(node: Int, c: Int): Boolean {
        if (color.containsKey(node))
            return color[node] == c
        color[node] = c

        for (nei in graph[node])
            if (!dfs(nei, c xor 1))
                return false
        return true
    }
}