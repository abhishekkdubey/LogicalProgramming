package com.example.algorithm

import kotlin.math.max

/**
 * Given an array of house with their worth, A thief will enter these house and steal
 * their value in such a manner that he maximize his value. and house must not be consecutive.
 * If thief steal from one house he can't steal from adjacent house.
 *
 * Example #1:
 * houses : {6, 7, 1, 30, 8, 2, 4}
 * O/P: 41
 * Explanation: Thief must steal : {7, 30, 4}
 *
 * Example #2:
 * houses : {20, 5, 1, 13, 6, 11, 40}
 * O/P: 73
 * Explanation: Thief must steal : {20, 13, 40}
 *
 */
class HouseThief {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(HouseThief().houseThief(intArrayOf(6, 7, 1, 30, 8, 2, 4)))
            println(HouseThief().houseThiefDynamicProgramming(intArrayOf(6, 7, 1, 30, 8, 2, 4)))
            println(HouseThief().houseThief(intArrayOf(20, 5, 1, 13, 6, 11, 40)))

        }
    }

    fun houseThief(arr: IntArray, currentIndex: Int = 0): Int {

        if (currentIndex >= arr.size) {
            return 0
        }
        val select = arr[currentIndex] + houseThief(arr, currentIndex + 2)
        val skip = houseThief(arr, currentIndex + 1)

        return max(select, skip)
    }

    fun houseThiefDynamicProgramming(arr: IntArray?): Int{

        if (arr==null || arr.isEmpty()){
           return 0
        }

        var include = arr[0]
        var exclude = 0

        for (i in 1 until arr.size){
            val temp = include
            include = max(exclude+arr[i], include)
            exclude = temp
        }


        return include


    }

}