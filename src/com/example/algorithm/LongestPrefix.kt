package com.example.algorithm

/**
 * Find Longest Common prefix from String Array ["flower", "flow", "flag"]
 * it should return "fl"
 * IN case of no match it should return as empty ""
 */
class LongestPrefix {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }


    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size <= 1) {
            return ""
        }
        var str = getLongestPrefixHelper(strs[0], strs[1])
        if (str.isNotEmpty()) {
            for (i in 2..strs.lastIndex) {
                str = getLongestPrefixHelper(str, strs[i])
                if (str.isEmpty()) {
                    return ""
                }
            }
            return str
        } else {
            return ""
        }
    }

    private fun getLongestPrefixHelper(s: String, s1: String): String {
        var i = 0
        while (i < s.length && i < s1.length) {
            if (s[i] == s1[i]) {
                i++
            } else {
                break
            }
        }
        return if (i > 0) {
            s.substring(0, i)
        } else {
            ""
        }

    }
}