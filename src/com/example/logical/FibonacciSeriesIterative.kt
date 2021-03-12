package com.example.logical

import java.lang.IllegalArgumentException

object FibonacciSeriesIterative {

    @JvmStatic
    fun main(args: Array<String>) {

        println(System.currentTimeMillis()/1000)
        println("Value: "+getFibonacci(50))
        println(System.currentTimeMillis()/1000)

        println("Value: "+getFibonacciRecursive(50))
        println(System.currentTimeMillis()/1000)
    }


    private fun getFibonacciRecursive(num: Int): Long {
        if (num < 0) {
            throw IllegalArgumentException("Number must be positive")
        } else if (num == 1 || num == 2) {
            return 1
        } else {
            return getFibonacciRecursive(num - 1) + getFibonacciRecursive(num - 2)

        }

    }

    private fun getFibonacci(num: Int): Long {
        val arr = LongArray(num + 1)
        arr[0] = 0
        arr[1] = 1
        arr[2] = 1
        if (num < 0) {
            throw IllegalArgumentException("Number must be positive")
        } else {
            for (i in 3 until arr.size) {
                arr[i] = arr[i - 1] + arr[i - 2]
            }
        }
        return arr[num]
    }

}