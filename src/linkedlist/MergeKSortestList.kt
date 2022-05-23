package linkedlist

/**
 * 23. Merge k Sorted Lists
 * Hard
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [1->4->5, 1->3->4, 2->6]
 *
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 */
class MergeKSortestList {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val l = ArrayList<Int>()
            
            val n1 = ListNode(1)
            n1.next = ListNode(4)
            n1.next?.next = ListNode(5)

            val n2 = ListNode(1)
            n2.next = ListNode(3)
            n2.next?.next = ListNode(4)

            val n3 = ListNode(2)
            n3.next = ListNode(6)

            val res = MergeKSortestList().mergeLinkedList(listOf(n1, n2, n3))

            var itr = res
            while (itr != null) {
                print("${itr.`val`}, ")
                itr = itr.next

            }
        }
    }


    fun mergeLinkedList(list: List<ListNode?>): ListNode? {
        return if (list.size == 1) {
            list[0]
        } else {
            var merged: ListNode? = merge(list[0], list[1])
            for (i in 2..list.lastIndex) {
                merged = merge(merged, list[i])
            }
            merged
        }
    }


    fun merge(node1: ListNode?, node2: ListNode?): ListNode? {
        var n1 = node1
        var n2 = node2

        val result = ListNode(0)
        var current = result

        while (n1 != null && n2 != null) {

            if (n1.`val` < n2.`val`) {
                val temp = n1
                n1 = n1.next
                temp.next = null
                current.next = temp
                current = current.next!!
            } else {
                val temp = n2
                n2 = n2.next
                temp.next = null
                current.next = temp
                current = current.next!!
            }
        }


        while (n1 != null) {
            val temp = n1
            n1 = n1.next
            temp.next = null
            current.next = temp
            current = current.next!!
        }

        while (n2 != null) {
            val temp = n2
            n2 = n2.next
            temp.next = null
            current.next = temp
            current = current.next!!
        }

        return result.next
    }


}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}