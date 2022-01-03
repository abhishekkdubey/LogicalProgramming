package com.example.algorithm

class LongestCommonSubSequence {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
           println( LongestCommonSubSequence().lcs("elephant", "eretpat"))
        }
    }


    fun lcs(s1: String, s2: String, i1: Int = 0, i2: Int = 0): Int {

        if (i1 == s1.length || i2 == s2.length) {
            return 0
        }
        var c1 = 0
        if (s1[i1] == s2[i2]) {
            c1 = 1 + lcs(s1, s2, i1 + 1, i2 + 1)
        }
        val c2 = lcs(s1, s2, i1 + 1, i2)
        val c3 = lcs(s1, s2, i1, i2 + 1)

        return maxOf(c1, c2, c3)

    }

}