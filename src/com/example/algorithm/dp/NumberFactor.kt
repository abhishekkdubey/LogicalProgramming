package com.example.algorithm.dp

class NumberFactor {


    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
            println(NumberFactor().numberFactor(IntArray(5), 4))
            println(NumberFactor().numberFactor(4))


            println(NumberFactor().numberFactor(IntArray(8), 7))
            println(NumberFactor().numberFactor(7))


            println(NumberFactor().numberFactor(IntArray(9), 8))
            println(NumberFactor().numberFactor(8))
        }
    }

    val numbers = intArrayOf(1, 3, 4)


    /**
     * Top-down Approach
     */
    fun numberFactor(memoization: IntArray, n: Int): Int {

        if (n == 0 || n == 1 || n == 2) { //Can Be created respectively {}, {1}, {1, 1}
            return 1
        }
        if (n == 3) { // can be created using {3}, {1, 1, 1}
            return 2
        }

        if (memoization[n] == 0) {
            val sub1 = numberFactor(memoization, n - numbers[0])
            val sub2 = numberFactor(memoization, n - numbers[1])
            val sub3 = numberFactor(memoization, n - numbers[2])
            memoization[n] = sub1 + sub2 + sub3
        }

        return memoization[n]
    }


    /**
     * Bottom-up Approach
     */
    fun numberFactor(n: Int):Int{
        val dp = IntArray(n+1)

        dp.fill(1, 0, 3)
        dp[3] = 2

        for (i in 4 until dp.size) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4]
        }

        return dp[n]
    }

}