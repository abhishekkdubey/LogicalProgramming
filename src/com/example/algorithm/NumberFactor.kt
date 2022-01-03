/**
 * For Given positive number n, count to number of ways to express n as sum of 1, 3, and  4
 *
 * Example:
 * n=4
 * Number of Ways: 4
 * Explanation:Following are the way to express four numbers: {4},{3,1},{1,3},{1,1,1,1}
 *
 * Example:
 * n = 5
 * Number of ways : 6
 * Explanation : Following are the ways to express five number : {1, 4}, {4, 1},{3, 1, 1},{1, 3, 1},{1, 1, 3},{1, 1, 1, 1, 1}
 *
 */
class NumberFactor {


    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            println(NumberFactor().numberFactor(4))
            println(NumberFactor().numberFactor(5))
            println(NumberFactor().numberFactor(9))
        }
    }

    val arr = intArrayOf(1, 3, 4)

    fun numberFactor(n: Int): Int {
        return if (n < 0) {
            0
        } else if (n == 0 || n == 1 || n == 2) { // For n=0, 1, 2 the way to create respectively {}, {1},{1, 1}
            1
        } else if (n == 3) { //For n =3 we can create {1, 1, 1} and {3}
            2
        } else {
            val s1 = numberFactor(n - arr[0])
            val s2 = numberFactor(n - arr[1])
            val s3 = numberFactor(n - arr[2])
            s1 + s2 + s3
        }
    }

}