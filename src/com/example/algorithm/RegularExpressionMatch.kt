package com.example.algorithm

class RegularExpressionMatch {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(RegularExpressionMatch().isMatch("aabcdeept", "a*.*e*.."))
            println(RegularExpressionMatch().isMatch("aabcdeept", "a*.*e*."))
            println(RegularExpressionMatch().isMatch("aa","a"))

        }
    }

    fun isMatch(s: String, p: String): Boolean {


        val dp = Array(p.length + 1) { BooleanArray(s.length + 1) { false } }

        dp[0][0] = true

        for (i in 0..dp.lastIndex) {
            for (j in 0..dp[i].lastIndex) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true
                } else if (i == 0) {
                    dp[i][j] = false
                } else if (j == 0) {
                    if (p[i - 1] == '*' && i - 2 >= 0) {
                        dp[i][j] = dp[i - 2][j]
                    }
                } else {
                    val pc = p[i - 1]
                    val sc = s[j - 1]

                    if (pc == '*') {
                        dp[i][j] = dp[i - 2][j]

                        val pslc = p[i - 2]
                        if (pslc == '.' || pslc == sc) {
                            dp[i][j] = dp[i - 2][j] || dp[i][j - 1]
                        }
                    } else if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1]
                    } else if (pc == sc) {
                        dp[i][j] = dp[i - 1][j - 1]
                    } else {
                        dp[i][j] = false
                    }
                }
            }
        }
        return dp[p.length][s.length]
    }
}