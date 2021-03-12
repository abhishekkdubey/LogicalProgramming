package com.example.practice

object DutchNationalFlagProblem {

    @JvmStatic
    fun main(args: Array<String>) {

    }


    fun segregate012(array: IntArray): IntArray {

        var low = 0
        var mid = 0
        var high = array.size - 1

        while (low <= high) {
            when {
                array[mid] == 0 -> {
                    val temp = array[mid]
                    array[mid] = array[low]
                    array[low] = temp
                    low++
                    mid++
                }
                array[mid] == 1 -> {
                    mid++
                }
                else -> {
                    val temp = array[mid]
                    array[mid] = array[high]
                    array[high] = temp;
                    high--
                }
            }
        }


        return array
    }

}