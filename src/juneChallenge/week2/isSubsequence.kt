package juneChallenge.week2

/**
 * leetcode problem
 * https://leetcode.com/problems/is-subsequence/
 */


fun isSubsequence(s: String, t: String): Boolean {
    if(s.length > t.length) return false;
    if(s.length == 0) return true;
    var c = 0
    for(i in 0 until t.length){
        if(t.get(i)==s.get(c)){
            c=c+1
        }
        if(c==s.length){
            return true
        }
    }
    return false
}