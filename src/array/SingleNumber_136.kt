package array

class SingleNumber_136 {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(SingleNumber_136().singleNumber(intArrayOf(4,1,2,1,2)))
            println(SingleNumber_136().singleNumber(intArrayOf(2,2,1)))
            println(SingleNumber_136().singleNumber(intArrayOf(1)))
        }
    }

    fun singleNumber(nums: IntArray): Int{
        val set= mutableSetOf<Int>()
        for (n in nums){
            if (set.contains(n)){
                set.remove(n)
            }else{
                set.add(n)
            }
        }
        return set.iterator().next()
    }
}