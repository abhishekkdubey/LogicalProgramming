package com.example.algorithm.dp

class Fibonacci {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Bottom-up Approach")
            val s1= System.currentTimeMillis()
            println(Fibonacci().fib(LongArray(56), 55))
            println(System.currentTimeMillis()-s1)

            println("Top-down Approach")
            val s2= System.currentTimeMillis()
            println(Fibonacci().fib(55))
            println(System.currentTimeMillis()-s2)

        }
    }


    /**
     * Top-Down Approach
     */
    fun fib(memoization: LongArray, n: Int): Long {

        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }

        if (memoization[n] == 0L) {
            memoization[n] = fib(memoization, n - 1) + fib(memoization, n - 2)
        }

        return memoization[n]
    }


    /**
     * Bottom-up Approach
     */
    fun fib(n: Int): Long {
        if (n < 0) {
            throw IllegalArgumentException("Number n must be positive integer")
        }
        val table = LongArray(n + 1)
        table[0] = 0
        table[1] = 1

        for (i in 2 until table.size) {
            table[i] = table[i - 2] + table[i - 1]
        }

        return table[n]
    }
}