package com.example.algorithm


class CoinChangeProblem {


    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            val coins = intArrayOf(1, 2, 5, 10, 20, 100, 200, 500)

            println(CoinChangeProblem().minimumCoinRequired(coins, 221))

        }

    }


    fun minimumCoinRequired(coins: IntArray, value: Long): Int {

        if (value<=0){
            return 0
        }
        var coin = 0

        var amount = value

        while (true) {
            val filtered = coins.filter { it <= amount }
            val maxFromCoin= filtered[filtered.size-1]
            amount -= maxFromCoin
            coin += 1
            if (amount == 0L) {
                break
            }
        }
        return coin
    }
}