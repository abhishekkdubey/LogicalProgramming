package com.example.logical

/**
 * Given an increasing sequence a[], we need to find the K-th missing contiguous element in the increasing sequence which is not present in the sequence. If no k-th missing element is there output -1.
 *
 * Examples :
 * Input : a[] = {2, 3, 5, 9, 10};
 * k = 1;
 * Output : 4
 *
 * Explanation: Missing Element in the increasing
 * sequence are {4, 6, 7, 8}. So k-th missing element is 4
 *
 * Input : a[] = {2, 3, 5, 9, 10, 11, 12};
 * k = 4;
 * Output : 8
 * Explanation: missing element in the increasing
 * sequence are {4, 6, 7, 8}  so k-th missing element is 8
 *
 */
object KthMissingElementInSortedArray {

    val arr = arrayOf(2, 3, 5, 9, 10)

    @JvmStatic
    fun main(args: Array<String>) {

        findKthMissingElement(arr, 2)
    }

    private fun findKthMissingElement(arr: Array<Int>, k: Int) {

        var count = 0
        var diff = 0



        for (i in arr.indices-1) {

            if (arr[i] + 1 != arr[i + 1]) {

//                diff = arr[i-]
            }


        }


    }


}