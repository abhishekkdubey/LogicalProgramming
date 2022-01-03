package com.example.algorithm.dp

import kotlin.math.max

class HouseThief {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println( HouseThief().houseThief(IntArray(9).also { it.fill(0) }, intArrayOf(6, 7, 1, 30, 8, 2, 4)))
            println( HouseThief().houseThief(intArrayOf(6, 7, 1, 30, 8, 2, 4)))
        }
    }



    /**
     * Top-Down Approach
     */
    fun houseThief(dp: IntArray, wealth: IntArray, index: Int = 0): Int {

        if (index >= wealth.size) {
            return 0
        }

        if (dp[index] == 0) {
            val current = wealth[index] + houseThief(dp, wealth, index + 2)
            val skip = houseThief(dp, wealth, index + 1)
            dp[index] = max(current, skip)
        }

        return dp[index]

    }


    /**
     * Bottom-up approach
     */
    fun houseThief(wealth: IntArray): Int {
        val dp = IntArray(wealth.size + 2)
        for (i in wealth.size - 1 downTo 0) {
            dp[i] = max(wealth[i] + dp[i + 2], dp[i + 1])
        }
        return dp[0]
    }

}