package com.example.algorithm

class QuickSort {


    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            val arr = intArrayOf(3, 2, 6, 5, 9, 4, 1)
            arr.forEach { print("$it, ") }
            println()
            QuickSort().quickSort(arr, 0, arr.size-1)
            arr.forEach { print("$it, ") }
        }

    }

    fun quickSort(array: IntArray, l: Int, h: Int) {

        if (l<h) {
            val pivot = getPivot(array, l, h)
            quickSort(array, l, pivot-1)
            quickSort(array, pivot + 1, h)
        }
    }

    private fun getPivot(array: IntArray, l: Int, h: Int): Int {
        val p = array[h]
        var i = l - 1
        for (j in l..h) {
            if (array[j] <= p) {
                i++
                val temp = array[j]
                array[j] = array[i]
                array[i] = temp
            }
        }
        return i
    }
}