package com.example

/**
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */
class ZigZagConversion {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(ZigZagConversion().zigZagCoversion("PAYPALISHIRING", 3))
            println(ZigZagConversion().zigZagCoversion("AB", 2))
        }
    }


    fun zigZagCoversion(input: String, numRows: Int): String {

        val arr = Array(numRows) { StringBuilder("") }

        var k = 0
        var goReverse = false
        for (i in 0..input.lastIndex) {
            arr[k].append(input[i])

            if (goReverse){
                k--
            }else{
                k++
            }
            if (k == arr.size) {
                goReverse = true
                k-=2
            }
            if (k==0) {
                goReverse = false
            }
        }
        return arr.run {
            val res = StringBuilder()
            arr.forEach { res.append(it) }
            res.toString()
        }

    }
}