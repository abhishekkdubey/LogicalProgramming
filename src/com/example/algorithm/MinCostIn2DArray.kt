package com.example.algorithm

import kotlin.math.min

class MinCostIn2DArray {


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val cost = arrayOf(
                intArrayOf(4, 7, 8, 6, 4),
                intArrayOf(6, 7, 3, 9, 2),
                intArrayOf(3, 8, 1, 2, 4),
                intArrayOf(7, 1, 7, 3, 7),
                intArrayOf(2, 9, 8, 9, 3)
            )
            println(MinCostIn2DArray().minCostIn2DArray(cost, cost.size-1, cost[0].size-1))

        }
    }


    fun minCostIn2DArray(cost: Array<IntArray>, row: Int, col: Int): Int {

        if (row == -1 || col == -1) {
            return Int.MAX_VALUE
        }
        if (row == 0 && col == 0) {
            return cost[0][0]
        }

        val c1 = minCostIn2DArray(cost, row, col - 1)
        val c2 = minCostIn2DArray(cost, row - 1, col)

        val min = min(c1, c2)

        return cost[row][col] + min

    }
}