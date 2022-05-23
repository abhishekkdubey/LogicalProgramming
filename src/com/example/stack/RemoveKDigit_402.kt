package com.example.stack

import java.util.*

/**
 * 402. Remove K Digits
 *
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 *
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 * Constraints:
 *
 * 1 <= k <= num.length <= 105
 * num consists of only digits.
 * num does not have any leading zeros except for the zero itself.
 */
class RemoveKDigit_402 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(RemoveKDigit_402().removeKDigit("1432219", 6))
//            println(RemoveKDigit_402().removeKDigit("10200", 1))
//            println(RemoveKDigit_402().removeKDigit("10", 2))
//            println(RemoveKDigit_402().removeKDigit("111111", 3))
//            println(RemoveKDigit_402().removeKDigit("00000", 3))
//            println(RemoveKDigit_402().removeKDigit("10001", 2))
//            println(RemoveKDigit_402().removeKDigit("100001", 2))
        }
    }

    fun removeKDigit(num: String, k: Int): String {

        if (k > num.length) {
            return "0"
        }

        if (k == 0) {
            return num
        }

        val stack = Stack<Char>()
        var n = k

        for (c in num) {

            while (stack.isNotEmpty() && stack.peek() > c && n > 0) {
                stack.pop()
                n--
            }


            if (stack.isNotEmpty() || c != '0') {
                stack.push(c)
            }
        }

        while (n > 0 && stack.isNotEmpty()) {
            stack.pop()
            n--
        }

        if (stack.isEmpty()) {
            return "0"
        }

        return String(stack.toCharArray())
    }
}