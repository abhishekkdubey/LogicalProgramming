package com.example.algorithm.dp

class TwoSum {

    companion object
    {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(18%10)
//            println(10/10)
//            TwoSum().twoSum(intArrayOf(3, 2, 4), 6).forEach { print(" $it") }

            val n1= ListNode(2)
            n1.next = ListNode(4)
            n1.next!!.next = ListNode(3)


            val n2= ListNode(5)
            n2.next = ListNode(6)
            n2.next!!.next = ListNode(4)



//            TwoSum().addTwoNumbers(n1, n2)


            val n3= ListNode(9)
            n3.next = ListNode(9)
            n3.next!!.next = ListNode(9)
            n3.next!!.next!!.next = ListNode(9)
            n3.next!!.next!!.next!!.next = ListNode(9)
            n3.next!!.next!!.next!!.next!!.next = ListNode(9)
            n3.next!!.next!!.next!!.next!!.next!!.next = ListNode(9)


            val n4= ListNode(9)
            n4.next = ListNode(9)
            n4.next!!.next = ListNode(9)
            n4.next!!.next!!.next = ListNode(9)
            TwoSum().addTwoNumbers(n3, n4)

        }
    }


    fun twoSum(nums: IntArray, target: Int): IntArray {

        val list=  mutableMapOf<Int, Int>()
        var i =0
        while(i<nums.size){

            if(list.contains(nums[i])){
                return intArrayOf(list[nums[i]] ?:0, i)
            }else{
                list.put(target-nums[i], i)
            }
            i++
        }
        return intArrayOf()
    }


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        if(l1==null){
            return l2
        }
        if(l2==null){
            return l1
        }

        var tempL1 = l1.next
        var tempL2 = l2.next

        var sum = l1.`val`+l2.`val`
        var reminder = 0

        val result = if(sum>9){
            reminder = sum/10
            ListNode(sum%10)
        }else{
            ListNode(sum)
        }

        var tempResult = result

        while(tempL1!=null && tempL2!=null){

            sum = tempL1.`val`+tempL2.`val`+reminder
            tempResult.next = if(sum>9){
                reminder = sum/10
                ListNode(sum%10)
            }else{
                reminder = 0
                ListNode(sum)
            }
            tempResult = tempResult.next!!
            tempL1= tempL1.next
            tempL2= tempL2.next

        }

        while(tempL1!=null){
            sum = tempL1.`val`+reminder
            tempResult.next = if(sum>9){
                reminder = sum/10
                ListNode(sum%10)
            }else{
                reminder = 0
                ListNode(sum)
            }

            tempL1= tempL1.next
            tempResult = tempResult.next!!

        }
        while(tempL2!=null){
            sum = tempL2.`val`+reminder
            tempResult.next = if(sum>9){
                reminder = sum/10
                ListNode(sum%10)
            }else{
                reminder = 0
                ListNode(sum)
            }
            tempL2= tempL2.next
            tempResult = tempResult.next!!

        }


        if(reminder>0){
            tempResult.next = ListNode(reminder)
        }

        return result
    }

}


class ListNode(var `val`: Int) {
        var next: ListNode? = null
}