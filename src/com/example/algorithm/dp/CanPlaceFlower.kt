package com.example.algorithm.dp


class CanPlaceFlower {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(CanPlaceFlower().canPlaceFlower(intArrayOf(1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0), 2))
        }
    }

    fun canPlaceFlower(intArray: IntArray, n: Int): Boolean {

        val map = mutableListOf<Int>()
        var p = n

        var i = 0

        while (i < intArray.size) {
            if (intArray[i] == 1) {
                i += 2
                map.toIntArray()
            } else {
                if (i== intArray.lastIndex || intArray[i + 1] == 0) {
                    i += 2
                    p--
                }else{
                    i++
                }
            }

        }
        if (p <= 0) {
            return true
        }
        return false
    }


    fun max_xor(arr: IntArray, n: Int): Int {
        var maxx = 0
        var mask = 0
        val se = HashSet<Int>()
        for (i in 30 downTo 0) {

            // set the i'th bit in mask
            // like 100000, 110000, 111000..
            mask = mask or (1 shl i)
            for (j in 0 until n) {

                // Just keep the prefix till
                // i'th bit neglecting all
                // the bit's after i'th bit
                se.add(arr[j] and mask)
            }
            val newMaxx = maxx or (1 shl i)
            for (prefix in se) {

                // find two pair in set
                // such that a^b = newMaxx
                // which is the highest
                // possible bit can be obtained
                if (se.contains(newMaxx xor prefix)) {
                    maxx = newMaxx
                    break
                }
            }

            // clear the set for next
            // iteration
            se.clear()
        }
        return maxx
    }
}