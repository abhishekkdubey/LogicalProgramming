package com.example.algorithm.dp

/**
 * Convert one string to another by what alteration include: Delete, Insert, replace
 */
class EditDistance {

    //TODO: Correct this solution. Still not working
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(EditDistance().editDistance("table", "able"))
            println(EditDistance().editDistance("table", "tbres"))
            println(EditDistance().editDistance(Array(6) { Array(5) { null } }, "table", "able"))
            println(EditDistance().editDistance(Array(6) { Array(6) { null } }, "table", "tbres"))
        }
    }



    fun editDistance(dp: Array<Array<Int?>>, s1: String, s2: String, i1: Int = 0, i2: Int = 0): Int {

        if (dp[i1][i2] == null) {
            if (i1 == s1.length) {
                dp[i1][i2] = s2.length - i2
            } else if (i2 == s2.length) {
                dp[i1][i2] = s1.length - i1
            } else if (s1[i1] == s2[i2]) {
                dp[i1][i2] = editDistance(dp, s1, s2, i1 + 1, i2 + 1)
            } else {
                val c1 =  editDistance(dp, s1, s2, i1 + 1, i2)
                val c2 =  editDistance(dp, s1, s2, i1 + 1, i2 + 1)
                val c3 =  editDistance(dp, s1, s2, i1, i2 + 1)

                dp[i1][i2] = 1 + minOf(c1, c2, c3)
            }
        }
        return dp[i1][i2]!!
    }


    fun editDistance(s1: String, s2: String): Int {
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }
        for (i in s1.indices) {
            dp[i][0] = i
        }
        for (j in s1.indices) {
            dp[0][j] = j
        }

        for (i in 1..s1.length) {
            for (j in 1..s2.length) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = 1 + minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
                }
            }
        }

        return dp[s1.length][s2.length]
    }
}