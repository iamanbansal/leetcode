package mayChallenge.week5


fun main() {
    canFinish(2, Array(1){ intArrayOf(1,0)})
}

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

    val graph= Array<ArrayList<Int>>(numCourses){ ArrayList() }

    for(i in 0 until prerequisites.size){
        graph[prerequisites[i][0]].add( prerequisites[i][1])
    }

    val visited = IntArray(numCourses)

    for(i in 0 until numCourses){
       if(visited[i]==0){
           if(isCyclic(graph,visited,i))
               return false
       }
    }

    return true

}

fun isCyclic(graph: Array<java.util.ArrayList<Int>>, visited: IntArray, i: Int): Boolean {
    if (visited[i] == 2) {
        return true
    }

    visited[i]=2;

    for(j in 0 until graph[i].size){
        if(visited[graph[i][j]]!=1)
            if(isCyclic(graph,visited,graph[i][j]))
                return true;
    }
    visited[i] = 1;
    return false;
}
