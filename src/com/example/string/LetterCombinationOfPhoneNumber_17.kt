package com.example.string

import java.util.*

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
class LetterCombinationOfPhoneNumber_17 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            LetterCombinationOfPhoneNumber_17().letterCombinations("23")
        }
    }

    fun letterCombinations(digits: String): List<String> {

        val result = LinkedList<String>()

        if (digits.isEmpty()) {
            return result
        }
        val mapping = arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "vwxyz")
        letterCombinationsHelper(digits, mapping, 0, LinkedList<Char>(), result)

        println(result)
        return result

    }


    fun letterCombinationsHelper(
        digits: String,
        mapping: Array<String>,
        index: Int,
        sb: LinkedList<Char>,
        result: LinkedList<String>
    ) {


        if (sb.size == digits.length) {
            result.add(String(sb.toCharArray()))
            return
        }

        for (c in mapping[digits[index]-'0']) {
            sb.add(c)
            letterCombinationsHelper(digits, mapping, index + 1, sb, result)
            sb.removeLast()
        }

    }

/*
    fun lengthOfLastWord(s: String): Int {
        val str = s.trim()
        val arr = str.split(' ')
        if(arr.isNullOrEmpty()){
            return str.length
        }else{
            arr[arr.size-1]
        }

    }
*/

}