package mayChallenge.week1

fun main() {
    println(numJewelsInStones("aA","aAAbbbb"))
    println(numJewelsInStones("acDd","ACdDaEdeCI"))
}


fun numJewelsInStones(J: String, S: String): Int {
    val set = HashSet<Char>()//hashmap can also be used
    J.forEach { set.add(it) }
    var count = 0
    S.forEach { if(set.contains(it)) count++ }
    return count
}