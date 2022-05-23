package com.example.algorithm

import java.util.*


//fun main() {
//    println(`42TrappingRainWater`().trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
//    println(`42TrappingRainWater`().trappingRainWater(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
//    println(`42TrappingRainWater`().trappingRainWater2Pointer(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
//    println(`42TrappingRainWater`().trappingRainWaterStack(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
//}

class TrappingRainWater_42 {
    fun trap(arr: IntArray): Int {
        // N^2 Approach
        var ans = 0
        val n = arr.size
        for (i in 0 until n) {
            var left = Int.MIN_VALUE
            var right = Int.MIN_VALUE
            for (j in i downTo 0) {
                left = maxOf(left, arr[j])
            }
            for (j in i until n) {
                right = maxOf(right, arr[j])
            }
            ans += minOf(left, right) - arr[i]
        }
        return ans

    }


    // DP of N Approach
    fun trappingRainWater(height: IntArray): Int {
        var ans = 0
        val n = height.size

        val left = IntArray(n)
        val right = IntArray(n)
        left[0] = height[0]
        for (j in 1 until n) {
            left[j] = Math.max(height[j], left[j - 1])
        }
        right[n - 1] = height[n - 1]
        for (j in n - 2 downTo 0) {
            right[j] = Math.max(height[j], right[j + 1])
        }
        for (i in 0 until n) {
            ans += Math.min(left[i], right[i]) - height[i]
        }
        return ans

    }

    fun trappingRainWaterStack(arr: IntArray): Int {
        // N of Stack Approach
        var ans = 0
        val n = arr.size
        val st = Stack<Int>()
        for (i in 0 until n) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                val h = arr[st.peek()]
                st.pop()
                if (st.isEmpty()) break
                val w = i - st.peek() - 1
                    val hi = Math.min(arr[st.peek()], arr[i]) - h
                ans += (hi * w)
            }
            st.push(i)
        }
        return ans

    }

    fun trappingRainWater2Pointer(arr: IntArray): Int {
        // 2 Pointer of N Approach
        var ans = 0
        var left = 0
        var right = arr.size - 1
        var leftMax = 0
        var rightMax = 0
        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax)
                    leftMax = arr[left]
                else
                    ans += (leftMax - arr[left])
                left++
            } else {
                if (arr[right] >= rightMax)
                    rightMax = arr[right]
                else
                    ans += (rightMax - arr[right])
                right--
            }
        }
        return ans
    }

    fun trap21(height: IntArray): Int {

        var result =0

        val stack = Stack<Int>()

        for(i in 0..height.lastIndex){
            while(!stack.isEmpty() && height[i]>height[stack.peek()]){

                val h = height[stack.peek()]
                stack.pop()
                if(stack.isEmpty()) break
                val width = i-stack.peek()-1
                val finalHeight = Math.min(height[stack.peek()], height[i]) - h
                result+=(finalHeight * width)
            }


            stack.add(i)
        }

        return result
    }


    fun getMaxArea(hist: IntArray,  n: Int): Int
    {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        val s =  Stack<Int>()

        var max_area = 0 // Initialize max area
        var tp= -1  // To store top of stack
                var area_with_top = -1 // To store area with top bar as the smallest bar

                // Run through all bars of given histogram
                var i = 0
        while (i < n) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++)

            // If this bar is lower than top of stack, then calculate area of rectangle
            // with stack top as the smallest (or minimum height) bar. 'i' is
            // 'right index' for the top and element before top in stack is 'left index'
            else {
                tp = s.peek()  // store the top index
                s.pop()  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * if (s.empty())  i else i-s.peek()-1

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.empty()) {
            tp = s.peek()
            s.pop()
            area_with_top = hist[tp] * if (s.empty())  i else i-s.peek()-1

            if (max_area < area_with_top)
                max_area = area_with_top
        }

        return max_area

    }
}

fun main() {
    println(TrappingRainWater_42().getMaxArea(intArrayOf(2, 1, 5, 6, 2, 3), 5))
}