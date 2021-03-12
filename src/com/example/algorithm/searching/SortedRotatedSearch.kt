package com.example.algorithm.searching

object SortedRotatedSearch {


    private val arr = arrayOf(5, 6, 7, 8, 9, 10, 1, 2, 3)
    private var iteration = 0

    @JvmStatic
    fun main(args: Array<String>) {
        println("Search for 2 in Array. Which is available at index: "+searchInteger(arr, 0, arr.size, 2))
    }

    /**
     * @param arr An @Int Array
     * @param s Start Index
     * @param e End Index
     * @param key Searching integer value key
     *
     * @return An Index of key, If available. Otherwise return -1
     */
    private fun searchInteger(arr: Array<Int>, s: Int, e: Int, key: Int): Int {
        iteration++
        println("Go for Iteration $iteration with Start index: $s  End index: $e Search key: $key")

        /*If Start index is grater than end return -1 */
        if (s > e) {
            return -1
        }

        /*Find Pivot by (Start+End)/2 */
        val pivot = (s + e) / 2

        /*If Pivot index is equal to key then resultant index is pivot */
        if (key == arr[pivot]) {
            return pivot
        }
        /*If First half of Array is Sorted; Means from  started index to pivot index, Then execute below If Code*/
        if (arr[s] <= arr[pivot]) {

            /*Check, If Search key lies in the range of s..pivot then execute below if block otherwise pick second half*/
            if (key >= arr[s] && key <= arr[pivot]) {
                return searchInteger(arr, s, pivot-1, key)
            }
            return searchInteger(arr, pivot + 1, e, key)

        }

        /*If First half is not sorted, 2nd Half must be sorted and will search in second half. */
        if (key >= arr[pivot] && key < arr[e]) {
            return searchInteger(arr, pivot + 1, e, key)
        }
        return searchInteger(arr, s, pivot-1, key)
    }


}