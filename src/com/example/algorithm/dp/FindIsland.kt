package com.example.algorithm.dp

class FindIsland {


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val arr = arrayOf(  intArrayOf(1,1,1,1,0),
                intArrayOf(1,1,0,1,0),
                intArrayOf(1,1,0,0,0),
                intArrayOf(0,0,0,0,0))


            val arr2 = arrayOf(
                intArrayOf(1,1,0,0,0),
                intArrayOf(1,1,0,0,0),
                intArrayOf(0,0,1,0,0),
                intArrayOf(0,0,0,1,1)
            )
            println(FindIsland().findIslandCount(arr))
            println(FindIsland().findIslandCount(arr2))



            val arr2_1 = arrayOf(
                intArrayOf(1,1,0,0,0),
                intArrayOf(1,1,0,0,0),
                intArrayOf(0,0,1,0,0),
                intArrayOf(0,0,0,1,1)
            )

            val arr3 = arrayOf(  intArrayOf(1,1,1,1,0),
                intArrayOf(1,1,0,1,0),
                intArrayOf(1,1,0,0,0),
                intArrayOf(0,0,0,0,0))


            val arr4 = arrayOf(
                intArrayOf(1,1,0,0,0),
                intArrayOf(1,1,0,0,0),
                intArrayOf(0,0,0,0,0),
                intArrayOf(0,0,0,1,1)
            )
            println(FindIsland().findIslandCountWhereDiagonalConsideredConnected(arr2_1))
            println(FindIsland().findIslandCountWhereDiagonalConsideredConnected(arr3))
            println(FindIsland().findIslandCountWhereDiagonalConsideredConnected(arr4))

        }
    }


    fun findIslandCount(arr: Array<IntArray>): Int {
        var island = 0
        for (i in 0..arr.lastIndex) {
            for (j in 0..arr[i].lastIndex) {
                if (arr[i][j] == 1) {
                    dfs(arr, i, j)
                    island++
                }
            }
        }
        return island
    }


    private fun dfs(arr: Array<IntArray>, i: Int, j: Int) {
            if (i<arr.lastIndex && arr[i + 1][j] == 1) {
                arr[i + 1][j] = 0
                dfs(arr, i + 1, j)
            }

            if (j<arr[i].lastIndex && arr[i][j + 1] == 1) {
                arr[i][j + 1] = 0
                dfs(arr, i, j + 1)
            }
    }


    fun findIslandCountWhereDiagonalConsideredConnected(arr: Array<IntArray>): Int {
        var island = 0
        for (i in 0..arr.lastIndex) {
            for (j in 0..arr[i].lastIndex) {
                if (arr[i][j] == 1) {
                    dfsIncludeDiagonal(arr, i, j)
                    island++
                }
            }
        }
        return island
    }

    private fun dfsIncludeDiagonal(arr: Array<IntArray>, i: Int, j: Int) {
        if (i<arr.lastIndex && arr[i + 1][j] == 1) {
            arr[i + 1][j] = 0
            dfsIncludeDiagonal(arr, i + 1, j)
        }

        if (j<arr[i].lastIndex && arr[i][j + 1] == 1) {
            arr[i][j + 1] = 0
            dfsIncludeDiagonal(arr, i, j + 1)
        }

        if (j<arr[i].lastIndex && i<arr.lastIndex && arr[i+1][j + 1] == 1) {
            arr[i+1][j + 1] = 0
            dfsIncludeDiagonal(arr, i+1, j + 1)
        }
    }


}