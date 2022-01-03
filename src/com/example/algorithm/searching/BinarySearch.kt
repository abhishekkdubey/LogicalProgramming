package com.example.algorithm.searching


fun main() {

    println(BinarySearch().solution(intArrayOf(1, 4, 5, 7, 9, 11, 15, 17), 7))
}

class BinarySearch {

    fun solution(arr: IntArray, key: Int): Int {
        var s = 0
        var e = arr.size - 1
        while (s <= e) {
            val m = (s + e) / 2
            if (arr[m] < key) {
                s = m + 1
            } else if (arr[m] > key) {
                e = m - 1
            } else {
                return m
            }
        }
        return -1
    }
}