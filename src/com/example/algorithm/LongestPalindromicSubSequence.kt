package com.example.algorithm

import kotlin.math.max

class LongestPalindromicSubSequence {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(LongestPalindromicSubSequence().lcs("elrmenmet", 0, 8))
        }
    }


    fun lcs(s1: String, l: Int, r: Int): Int {

        if (l > r) {
            return 0
        }
        if (l==r){
            return 1
        }
        var c1 = 0
        if (s1[l] == s1[r]) {
            c1 = 2 + lcs(s1, l + 1, r - 1)
        }
        val c2 = lcs(s1, l + 1, r)
        val c3 = lcs(s1, l, r - 1)

        return maxOf(c1, max( c2, c3))

    }

}