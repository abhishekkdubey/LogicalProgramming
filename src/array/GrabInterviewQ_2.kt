package array

/**
 * Questions asked by Grab Codility test
 */
class GrabInterviewQ_2 {

    /**
     * https://stackoverflow.com/questions/29531715/pair-of-points-with-distance-divisible-by-integer
     */
    fun largestSubSetDivisible(A: IntArray, M: Int):Int {
            val result = IntArray(1) { 1 }
        largestSubSetDivisible(A, m = M, result = result)
        return result[0]
    }

    fun largestSubSetDivisible(
        A: IntArray,
        dp: IntArray = IntArray(A.size) { 0 },
        index: Int = 0,
        m: Int,
        result: IntArray = IntArray(1) { 1 }
    ) {
        if (index == A.size) {
            val count = dp.count { it == 1 }
            if (result[0] < count) {
                val ar = A.filterIndexed { index, _ -> dp[index] == 1 }
                if (divisionPair(ar, m))
                    result[0] = count
            }
            return
        }
        dp[index] = 0
        largestSubSetDivisible(A, dp, index + 1, m, result)
        dp[index] = 1
        largestSubSetDivisible(A, dp, index + 1, m, result)
    }

    fun divisionPair(array: List<Int>, m: Int): Boolean {
        for (j in 0 until array.size - 1) {
            if ((array[j] - array[j + 1]) % m != 0)
                return false
        }
        return true
    }


}