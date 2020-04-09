package leetCode.thirtyDaysChallenge.week2

/*
*  LeetCode Problem
* https://leetcode.com/problems/backspace-string-compare/
*/

fun  main(){
    println(backspaceCompare("a##c","#a#c"))
}
fun backspaceCompare(S: String, T: String): Boolean {
    return getTypedText(S) == (getTypedText(T))
}

private fun getTypedText(S: String): String {
    var s = ""
    S.forEach {
        if (it == '#' && s.isNotEmpty()) {
            s = s.substring(0, s.lastIndex)
        } else if(it != '#'){
            s += it
        }
    }
    return s
}