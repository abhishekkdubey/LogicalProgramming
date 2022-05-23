package com.example.algorithm

import java.util.*

/**
 * 84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.



Example 1:
https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:
https://assets.leetcode.com/uploads/2021/01/04/histogram-1.jpg

Input: heights = [2,4]
Output: 4


Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 */
class LargestRectangleHistorgam_84 {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

//            println(LargestRectangleHistorgam().largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
            /*println(*/LargestRectangleHistorgam_84().largestRectangleAreaByStack(intArrayOf(2, 1, 5, 6, 2, 3, 1))/*)*/
        }
    }


    /**
     * Brute-Force Approach
     */
    fun largestRectangleArea(arr: IntArray): Int {

        //Hold left boundary of every items
        var left: Int
        //Hold right boundary of every items
        var rigth: Int
        //Hold the maaximum calculated Area
        var maxArea = arr[0]
        //Iterate trhough the array
        for (i in 0..arr.lastIndex) {
            /**
             * Every index position will be starting left right boundary
             */
            left = i
            rigth = i
            //Find left Boundary where left must be greater than equal to 0
            while (left - 1 > 0) {
                //If left is greater than or equal to current then move to left.
                if (arr[left - 1] >= arr[i]) {
                    left--
                } else {
                    //If left is not greater than equal to current then break current loop
                    break
                }
            }
            //Find Right Boundary where right must be less array size
            while (rigth < arr.lastIndex) {
                //If Right is greater than or equal to current then move to right.
                if (arr[rigth + 1] >= arr[i]) {
                    rigth++
                } else {
                    //If right is not greater than equal to current then break current loop
                    break
                }
            }

            /**
             * Now we have left right boundary for the current index.
             * It's time to calculate the area. Formula for the area is
             * current value * (Right-Left+1).
             * eg: left = 1, right= 3 then total width will be 3 for that
             *  3-1+1
             *
             */
            val area = arr[i] * (rigth - left + 1)

            //If calculated area is greater that current maxArea, Replace
            if (area > maxArea) {
                maxArea = area
            }
        }
        return maxArea
    }


    /**
     * Optimal Solution
     */

    fun largestRectangleAreaByStack(arr: IntArray): Int {

        /**
         * Approach here is to find the left & Right boundary for all the indexes
         * then calculate the area for every index while comparing which one is greater then retun that area
         */

        val leftBoundary = IntArray(arr.size)
        val rightBoundary = IntArray(arr.size)


        //This Stack we'll use to store the index value
        val stack = Stack<Int>()

        /**
         * Now Here we are calculating left boundary of the every index
         */
        for (i in 0..arr.lastIndex) {
            //If Stack is Empty or current index in increasing value then simply insert the index into stack
            if (stack.isEmpty() || arr[stack.peek()] < arr[i]) {
                leftBoundary[i] = i
            } else {
                //If current value is drecreasing then,
                // Pop one by one where arr[stack.pop()] is greater then or equal to current index value
                while (stack.isNotEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop()
                }
                //In case Stack become empty in that case we need to assigning the left boundary is 0
                if (stack.isEmpty()) {
                    leftBoundary[i] = 0
                } else {
                    //Insert left boundary as a stack peek value plus 1. Because that will be your next boundary
                    leftBoundary[i] = stack.peek() + 1
                }
            }
            //Insert the current index into the stack
            stack.push(i)
        }
        println()
        print("[")

        leftBoundary.forEach { print("${it}, ") }
        print("]")

        stack.empty()

        for (i in arr.lastIndex downTo 0) {
            if (stack.isEmpty() || arr[stack.peek()] < arr[i]) {
                rightBoundary[i] = i
            } else {
                while (stack.isNotEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop()
                }

                if (stack.isEmpty()) {
                    rightBoundary[i] = arr.lastIndex
                } else {
                    rightBoundary[i] = stack.peek() - 1
                }
            }
            stack.push(i)
        }

        println()
        print("[")
        rightBoundary.forEach { print("${it}, ") }
        print("]")

        var maxArea = 0
        for (i in 0..arr.lastIndex) {
            val area = arr[i] * (rightBoundary[i] - leftBoundary[i] + 1)
            if (maxArea < area) {
                maxArea = area
            }
        }
        println()
        println("Result is : $maxArea")
        return maxArea
    }
}