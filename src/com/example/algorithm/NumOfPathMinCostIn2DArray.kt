package com.example.algorithm

class NumOfPathMinCostIn2DArray {


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val cost = arrayOf(
                intArrayOf(4, 7, 1, 6),
                intArrayOf(5, 7, 3, 9),
                intArrayOf(3, 1, 1, 2),
                intArrayOf(7, 1, 6, 3)
            )
            println(NumOfPathMinCostIn2DArray().minCostIn2DArray(cost, cost.size - 1, cost[0].size - 1, 25))
    
        }
    }


    fun minCostIn2DArray(costs: Array<IntArray>, row: Int, col: Int, cost: Int): Int {

        if (cost < 0) {
            return 0
        }

        if (row == 0 && col == 0) {
            return if (costs[0][0] - cost == 0) return 1 else 0
        }

        if (row == 0) {
            return minCostIn2DArray(costs, 0, col - 1, costs[row][col])
        }
        if (col == 0) {
            return minCostIn2DArray(costs, row - 1, 0, costs[row][col])
        }

        val numberOfPathFromPrevCol = minCostIn2DArray(costs, row, col - 1, cost - costs[row][col])
        val numberOfPathFromPrevRow = minCostIn2DArray(costs, row - 1, col, cost - costs[row][col])

        return numberOfPathFromPrevRow + numberOfPathFromPrevCol

    }
}