package com.example.algorithm


fun main() {
    val arr = intArrayOf(3, 2, 6, 5, 9, 4, 1)
    arr.forEach { print("$it, ") }
    MergeSort().mergeSort(arr, 0, arr.size - 1)
    println()
    arr.forEach { print("$it, ") }
}

class MergeSort {

    fun mergeSort(arr: IntArray, s: Int, e: Int) {
        if (e > s) {
            val m = s+(e - s) / 2
            mergeSort(arr, s, m)
            mergeSort(arr, m + 1, e)
            merge(arr, s, m, e)
        }
    }

    private fun merge(arr: IntArray, s: Int, m: Int, e: Int) {

        val l1 = m - s + 1
        val l2 = e - m

        val a1 = IntArray(l1)
        val a2 = IntArray(l2)

        for (i in a1.indices)
            a1[i] = arr[s + i]

        for (j in a2.indices)
            a2[j] = arr[m + 1 + j]


        var i = 0
        var j = 0
        var k = s

        while (i < l1 && j < l2) {
            if (a1[i] < a2[j]) {
                arr[k] = a1[i]
                i++
            } else {
                arr[k] = a2[j]
                j++
            }
            k++
        }

        while (i < l1) {
            arr[k] = a1[i]
            i++
            k++
        }
        while (j < l2) {
            arr[k] = a2[j]
            j++
            k++
        }
    }


}