package array

import java.net.URL
import java.util.*

/**
 * Max Element for Given Window
 *
 * You will be given an array arr as [2, 3, 5, 7, 1, 4, 6] and window size k = 2 then
 * print an output as [3, 5, 7, 7, 4, 6]
 * Explanation :  window size is 2 then will compare every window of 2 and add output of largest in the window
 *
 * [2, 3]  => 3
 * [3, 5] => 5
 * [5, 7] => 7
 * [7, 1] => 7
 * [1, 4] => 4
 * [4, 6] => 6
 * O/P: [3, 5, 7, 7, 4, 6]
 */
class MaxElementForGivenWindow {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            MaxElementForGivenWindow().maxElementInWindowK(intArrayOf(2, 3, 5, 7, 1, 4, 6), 2)
                .forEach { print("$it, ") }
            println()
            MaxElementForGivenWindow().maxElementInWindowK2(intArrayOf(2, 3, 5, 7, 1, 4, 6), 2)
                .forEach { print("$it, ") }
        }
    }

    fun maxElementInWindowK(arr: IntArray, k: Int): IntArray {
        val op = IntArray(arr.size - k + 1)

        for (i in 0..arr.size - k) {
            var max = arr[i]
            for (j in 1 until k) {
                if (max < arr[i + j]) {
                    max = arr[i + j]
                }
            }
            op[i] = max
        }
        return op
    }

    fun maxElementInWindowK2(arr: IntArray, k: Int): IntArray {

        //Store the resul in this array
        val op = IntArray(arr.size - k + 1)

        //Deque help us to add remove element from backward and forward
        val deque = LinkedList<Int>()

        //Index value helping for inserting the result in array
        var t = 0

        //Loop through the array element
        for (i in 0..arr.lastIndex) {

            //Check if peek is out of range. If yes remove it.
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll()
            }

            //Remove from last in case last element in dequeue is less than
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast()
            }

            deque.offer(i)

            if (i > k - 1) {
                op[t++] = arr[deque.peek()]
            }
        }
        return op
    }


    fun missing(arr: IntArray): Int {

        var diff = arr[0] - 1
        var s = 0
        var e = arr.lastIndex

        while (s <= e) {
            val m = e + s / 2

            if (arr[m] == m + 1 + diff) {
                s = m
            } else {
                e = m
            }
        }

        return s + 1 + diff
    }
}