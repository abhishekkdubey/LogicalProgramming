package com.example.algorithm.dp

/**
 * 1359. Count All Valid Pickup and Delivery Options
 *
 * Given n orders, each order consist in pickup and delivery services.
 *
 * Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
 *
 * Example 2:
 *
 * Input: n = 2
 * Output: 6
 * Explanation: All possible orders:
 * (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
 * This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
 *
 * Example 3:
 *
 * Input: n = 3
 *
 * Output: 90
 *
 * Constraints:
 *
 * 1 <= n <= 500
 */
class CountAllValidPickupAndDelivery_1359 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }

    /**
     * Solution build upon formula to calculate the valid possible valid order count
     *
     * Based on example given, we get to know that for 1, there is only 1 possible order
     *
     * For 2 order it's 6 possibility because for placing 2nd order if I place P2 at initial
     *
     *      {P2}, __ , [P1], __, [D2], __ // 3 possibility to place {D2} indicated by __
     *      [P1], {P2}, __, [D2], __      // 2 possibility to place {D2} indicated by __
     *      [P1], [D2], {P2}, __      // 1 possibility to place {D2} indicated by __
     *
     *      So, total possible placement are 3+2+1 = 6
     *      And Total possible valid with PickUp Delivery with 1  = 1
     *
     *      So, Total delivery with 2  = 1 * 6 = 6
     *
     * Now, Let's check for 3 order,
     * As we know for 2 order there are 6 valid PickUp and Delivery
     * Let's put 3rd PickUp delivery in 2 order combination taking one of the valid combination of 2
     *
     * If we place P3 in start of the 2's order valid combination, there are 5 possible place to add D3
     *
     *      {P3}, __ , [P1],__, [P2] __, [D1], __, [D2], __ // 5 possibility to place {D3} indicated by __
     *      [P1],{P3}, __, [P2] __, [D1], __, [D2], __      // 4 possibility to place {D3} indicated by __
     *      [P1],[P2],{P3}, __, [D1], __, [D2], __          // 3 possibility to place {D3} indicated by __
     *      [P1],[P2],[D1],{P3}, __, [D2], __               // 2 possibility to place {D3} indicated by __
     *      [P1],[P2],[D1],[D2], {P3}, __                   // 1 possibility to place {D3} indicated by __
     *
     *      So, total possible placement are 5+4+3+2+1 = 15
     *      And Total possible valid with PickUp Delivery with 2  = 6
     *
     *      So, Total delivery with 3  = 6 * 15 = 90

     * Now, we have seen one pattern that, to calculate the possible placement for number nth delivery  and multiply with (n-1) valid combination
     *
     * To Calculate the possibility we need to find the number k  = 2*n-1  then k * (k+1)/2
     *
     * E.g. For 3,  2*3-1 = 5 and then 5 * (5+1)/2 = 15
     *
     * once possibility calculated get previous value for 2 order is 6
     * now multiply this  6*15 = 90 is the answer
     *
     */
    fun countOrders(n: Int): Int {

        val dp = LongArray(501)


        val mod = Math.pow(10.0, 9.0)+7

        dp[1] = 1
        dp[2] = 6

        for (i in 3..n) {
            val k = 2 * i - 1
            val possibility = k * (k + 1) / 2
            val res = possibility * dp[i - 1]
            dp[i] = (res % mod).toLong()
        }

        return dp[n].toInt()
    }

    
}