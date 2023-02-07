//https://leetcode.com/problems/roman-to-integer/

fun romanToInt(s: String): Int {
    var result = 0
    var i = 0

    while (i < s.length-1) {
        val cur = getValue(s[i])
        val next = getValue(s[i+1])
        if(next>cur) {
            result -= cur
        }else{
            result += cur
        }
        i++
    }

    return result + getValue(s.last())
}

fun getValue(c:Char):Int{
    return  when(c){
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else-> 0
    }
}
