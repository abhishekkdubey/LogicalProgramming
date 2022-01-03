package com.example.algorithm

import kotlin.math.max

class ZeroOneKnapsackProblem {


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(ZeroOneKnapsackProblem().knapsackProblem(intArrayOf(31, 26, 72, 17), intArrayOf(3, 1, 5, 2), 7))
        }
    }

    private fun knapsackProblem(profit: IntArray, weight: IntArray, knapsackCapacity: Int, index: Int = 0): Int {

        if (knapsackCapacity <= 0 || index < 0 || index >= profit.size){
            return 0
        }

        var profit1 = 0

        if (weight[index]<=knapsackCapacity){
            profit1  = profit[index]+knapsackProblem(profit, weight, knapsackCapacity-weight[index], index+1)
        }
        val profit2 = knapsackProblem(profit, weight, knapsackCapacity, index+1)

        return max(profit1, profit2)

    }
}