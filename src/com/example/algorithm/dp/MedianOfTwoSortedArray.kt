package com.example.algorithm.dp

class MedianOfTwoSortedArray {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(MedianOfTwoSortedArray().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
            println(MedianOfTwoSortedArray().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
            println(MedianOfTwoSortedArray().findMedianSortedArrays(intArrayOf(), intArrayOf()))
            println(MedianOfTwoSortedArray().findMedianSortedArrays(intArrayOf(1, 2, 4, 5), intArrayOf(3, 6, 8, 9, 11, 13, 14, 16, 18)))
            println(MedianOfTwoSortedArray().findMedianSortedArrays(intArrayOf(), intArrayOf()))
        }
    }


    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        val totalSize = nums1.size + nums2.size

        var totalValueCount: Int
        var startIndex: Int
        if (totalSize % 2 == 0) {
            totalValueCount = 2
            startIndex =
                (totalSize / 2) - 1
        } else {
            totalValueCount = 1
            startIndex = totalSize / 2
        }
        val tempValueCount = totalValueCount
        var k = 0
        var i = 0
        var j = 0
        var median = 0.0
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] < nums2[j]) {
                if (k == startIndex) {
                    median += nums1[i]
                    totalValueCount--
                    startIndex++
                }
                i++
            } else {
                if (k == startIndex) {
                    median += nums2[j]
                    totalValueCount--
                    startIndex++
                }
                j++
            }
            k++
            if (totalValueCount == 0) {
                return median / tempValueCount.toDouble()
            }
        }


        while (i < nums1.size) {
            if (k == startIndex) {
                median += nums1[i]
                totalValueCount--
                startIndex++
            }
            i++
            k++
            if (totalValueCount == 0) {
                return median / tempValueCount.toDouble()
            }
        }

        while (j < nums2.size) {
            if (k == startIndex) {
                median += nums2[j]
                totalValueCount--
                startIndex++
            }
            j++
            k++
            if (totalValueCount == 0) {
                return median / tempValueCount.toDouble()
            }
        }

        return 0.0

    }
}