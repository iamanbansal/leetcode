package leetCode.thirtyDaysChallenge.week1


/*
*  LeetCode Problem
* https://leetcode.com/problems/group-anagrams/
*/


fun main(){
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = hashMapOf<HashMap<Char, Int>, ArrayList<String>>()
    strs.forEach {
        val num = getMap(it)

        if (map.containsKey(num)) {
            map[num]?.add(it)
        }else{
            map[num]=arrayListOf(it)
        }
    }
    return map.values.toList()
}

fun getMap(str: String):HashMap<Char, Int>{
    val map = HashMap<Char, Int>()
    str.forEach {
        if(map.containsKey(it))
            map[it] = map[it]!!.plus(1)
        else
            map[it] = 1
    }
    return map
}