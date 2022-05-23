package array

import java.text.DecimalFormat

/**
 * 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 *
 * Output: ["h","a","n","n","a","H"]
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
class ReverseString_344 {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            reverseString(charArrayOf('h','e','l','l','o'))
            ReverseString_344().formatDecimal("59.99")
        }

        private fun reverseString(s: CharArray) {
            var size = s.lastIndex

            for (i in 0..s.size/2){
                val temp = s[size]
                s[size--] = s[i]
                s[i] = temp
            }

            s.forEach { print("$it, ") }

        }
    }


    fun formatDecimal(value : String){
        val priceMonthlyActual = value.toDouble().div(12)
        val df = DecimalFormat("#.##")
//        df.roundingMode = RoundingMode.UP
        String.format("%.2f", priceMonthlyActual)
        val priceMonthly = String.format("%.2f", priceMonthlyActual)
        println(priceMonthly)

    }
}