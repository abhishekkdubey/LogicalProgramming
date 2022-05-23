package com.example.algorithm.dp

import kotlin.math.max

class ZeroOneKnapsack {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val weight = intArrayOf(3, 1, 5, 2)
            val profit = intArrayOf(31, 26, 72, 17)
            println(
                ZeroOneKnapsack().knapsack(
                    Array(weight.size) { Array<Int?>(7+1) { null } },
                    profit,
                    weight,
                    7,
                    0
                )
            )
        }
    }


    fun knapsack(dp: Array<Array<Int?>>, profits: IntArray, weight: IntArray, capacity: Int, index: Int = 0): Int {

        if (capacity == 0 || index < 0 || index >= weight.size) {
            return 0
        }
        if (dp[index][capacity] == null) {

            var profit1 = 0
            if (weight[index] <= capacity) {
                profit1 = profits[index] + knapsack(dp, profits, weight, capacity - weight[index], index + 1)
            }
            val profit2 = knapsack(dp, profits, weight, capacity, index + 1)

            dp[index][capacity] = max(profit1, profit2)
        }
        return dp[index][capacity]!!
    }

/*
    fun knapsack(profit: IntArray, weight: IntArray, knapsack: Int): Int {

        val dp = Array(weight.size) { IntArray(knapsack) { 0 } }

        for (i in 1 until dp.size) {
            for (j in 1 until dp[i].size) {


                dp[i][j]
            }
        }


    }
*/
}