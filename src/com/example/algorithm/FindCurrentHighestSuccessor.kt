package com.example.algorithm

import java.util.*

class FindCurrentHighestSuccessor {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            FindCurrentHighestSuccessor().replaceHighestValueSuccessorAndReplace(
                intArrayOf(
                    5,
                    4,
                    9,
                    8,
                    7,
                    6,
                    11,
                    4,
                    3,
                    1
                )
            ).forEach { print(" $it") }
        }
    }

    fun replaceHighestValueSuccessorAndReplace(arr: IntArray): IntArray {

        if (arr.isEmpty()) {
            return arr
        }
        val stack = Stack<Int>()

        var k = 0
        stack.push(arr[0])
        for (i in 1..arr.lastIndex) {
            if (stack.isNotEmpty() && arr[i] > stack.peek()) {
                for (j in  k ..k+stack.lastIndex ) {
                    arr[k] = arr[i]
                    k++
                }
                k =i
                stack.clear()
            }

            stack.push(arr[i])

            if (i == arr.lastIndex && stack.isNotEmpty()) {
                for (j in  k ..k+stack.lastIndex ) {
                    arr[k] = arr[i]
                    k++
                }
                k =i
                stack.clear()
            }
        }
        return arr
    }
}