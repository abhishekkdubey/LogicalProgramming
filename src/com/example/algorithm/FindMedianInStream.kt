package com.example.algorithm

class FindMedianInStream {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            FindMedianInStream().foundMedian(intArrayOf(1, 2, 3, 4, 5, 6)).forEach { print("$it, ") }
        }
    }

    fun foundMedian(intArray: IntArray): DoubleArray {

        val result = DoubleArray(intArray.size)
        var sumSoFar = intArray[0]
        result[0] = sumSoFar.toDouble()
        for (i in 1..intArray.lastIndex) {
            sumSoFar += intArray[i]
            result[i] = sumSoFar / (i + 1).toDouble()
        }

        return result
    }
}