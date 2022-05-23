package com.example.algorithm

class LargestContinuousRotatedSum {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(LargestContinuousRotatedSum().largestSum(intArrayOf(3, 9, -3, 1, -2, 11, 12)))
            LargestContinuousRotatedSum().rotateArray(intArrayOf(1, 2, 3, 4, 5, 6, 7), 2).onEach {
                print(
                    "$it "
                )
            }
            println()
            LargestContinuousRotatedSum().rotateByKTimes(intArrayOf(1, 2, 3, 4, 5, 6, 7), 2).onEach {
                print(
                    "$it "
                )
            }
        }
    }


    fun largestSum(arr: IntArray): Int {
        var max = arr[0]
        for (i in 0..arr.lastIndex) {
            val k = arr[i]
            for (j in 1..arr.lastIndex) {
                arr[j - 1] = arr[j]
            }
            arr[arr.lastIndex] = k
            max = maxOf(getMaxSum(arr), max)
        }

        return max
    }

    private fun getMaxSum(arr: IntArray): Int {
        var max = arr[0]
        var absSum = arr[0]

        var i = 1

        while (i < arr.size) {
            absSum = maxOf(arr[i] + absSum, arr[i])
            max = maxOf(max, absSum)
            i++
        }

        return max
    }


    fun rotateArray(arr: IntArray, k: Int): IntArray {
        val tempArr = IntArray(k)
        for (i in 0..arr.lastIndex) {
            if (i < k) {
                tempArr[i] = arr[i]
            } else {
                arr[i - k] = arr[i]
            }
        }

        var j = 0

        for (i in arr.size - k..arr.lastIndex) {
            arr[i] = tempArr[j++]
        }

        return arr
    }

    fun rotateByKTimes(arr: IntArray, k: Int): IntArray {
        val tempArr = IntArray(k)
        var j = 0
        for (i in 0..arr.lastIndex) {
            if (i < k) {
                tempArr[i] = arr[i]
            }

            arr[i] = if (i + k < arr.size) {
                arr[i + k]
            } else {
                tempArr[j++]
            }
        }

        return arr
    }

}