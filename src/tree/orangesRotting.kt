package tree

//https://leetcode.com/problems/rotting-oranges/


fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return -1

        
        val rows = grid.size
        val cols= grid.first().size

        fun dfs(i:Int, j:Int, minutes:Int){
            if(i<0 || i>= rows || j<0 || j>= cols || grid[i][j] == 0 || grid[i][j] > 1 && grid[i][j] < minutes)
            return 

            grid[i][j] = minutes

            dfs(i-1,j, minutes+1)
            dfs(i+1, j, minutes+1)
            dfs(i, j-1, minutes+1)
            dfs(i, j+1, minutes+1)
        }

        for(i in 0 until rows){
            for( j in 0 until cols){
                if(grid[i][j]==2)
                    dfs(i, j, 2)
            }
        }

        var minutes = 2
        for(i in 0 until rows){
            for( j in 0 until cols){
                if(grid[i][j]==1){
                    return -1
                }else{
                    minutes = maxOf(minutes, grid[i][j])
                }
            }
        }

        return minutes - 2
    }