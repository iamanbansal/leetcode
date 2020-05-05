package mayChallenge.week1

import kotlin.math.floor
import kotlin.math.log2

fun main() {
    println(findComplement(10))
}

/**
1. To invert the bits we can use XOR to know more on xor look here-> wikipedia
2. We need to XOR with a number containing all 1.
3. Now to find above number we have to get the nearest power of 2 and then substract 1.
for example. If num=5(101) -> then nearset powerof 2 is 8 (1000), Now substract 1 from 8 i.e 7 (111)
Now 5 XOR 7 = 2 i.e 101 XOR 111 = 010
OR
7-5 = 2  (since all bits are 1s we can normally subtract )

 */
fun findComplement(num: Int): Int {

//     calculate no. of bits
    val noOfBits = floor(log2(num.toDouble())).toInt() + 1

//    ((2.0.pow(noOfBits)) - 1).xor(num)
//    OR
    return ((1 shl noOfBits) - 1).xor(num)

}