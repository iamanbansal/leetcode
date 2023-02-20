package tree


//https://leetcode.com/problems/number-of-provinces/

fun findCircleNum(isConnected: Array<IntArray>): Int {
        // val vertices = isConnected.size
        val adj = ArrayList<ArrayList<Int>>()
        repeat(isConnected.size){
            adj.add(ArrayList())
        }
        for(i in isConnected.indices){
            for(j in isConnected.first().indices){
                if(isConnected[i][j]==1 && i!=j){
                    adj[i].add(j)
                    adj[j].add(i)
                }
            }
        }

        var count = 0
        val visit = BooleanArray(isConnected.size)

        for(i in isConnected.indices){
            if(!visit[i]){
                dfs(i, visit, adj)
                count++
            }
        }
        
        return count
    }

    private fun dfs(i:Int, visit:BooleanArray, adj: ArrayList<ArrayList<Int>>){
        visit[i] = true
        for(node in adj[i]){
            if(!visit[node]){
                dfs(node, visit, adj)
            }
        }
    }