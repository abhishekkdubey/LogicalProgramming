package com.example.algorithm

import kotlin.math.min

class MinCostToReachLastCellIn2DArray {

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

            println(MinCostToReachLastCellIn2DArray().minCost(cost, cost.size-1, cost[0].size-1))
        }
    }

    fun minCost(arr: Array<IntArray>, row: Int, col: Int): Int {

        if (row == -1 || col == -1) {
            return Int.MAX_VALUE
        }
        if (row == 0 && col == 0) {
            return arr[row][col]
        }

        val throughPreviousRow = minCost(arr, row - 1, col)
        val throughPreviousCol = minCost(arr, row, col - 1)

        return min(throughPreviousRow, throughPreviousCol) + arr[row][col]


    }
}