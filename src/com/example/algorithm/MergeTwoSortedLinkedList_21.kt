package com.example.algorithm

import linkedlist.ListNode

/**
 * 21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */
class MergeTwoSortedLinkedList_21 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val n1 = ListNode(1)
            n1.next = ListNode(3)
            n1.next?.next = ListNode(4)


            val n2 = ListNode(1)
            n2.next = ListNode(2)
            n2.next?.next = ListNode(4)
            val res = MergeTwoSortedLinkedList_21().mergeTwoLists(n1, n2)
            var resLoc = res
            while (resLoc != null) {
                print("${resLoc.`val`}, ")
                resLoc = resLoc.next
            }
        }
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        if (list1 == null) {
            return list2
        }
        if (list2 == null) {
            return list1
        }

        val resultNode = ListNode(0)
        var node: ListNode? = resultNode
        var l1 = list1
        var l2 = list2
        while (l1 != null && l2 != null) {
            if (l1.`val` > l2.`val`) {
                node?.next = l2
                l2 = l2.next
            } else {
                node?.next = l1
                l1 = l1.next
            }
            node = node?.next
        }

        while (l1 != null) {
            node?.next = l1
            l1 = l1.next
            node = node?.next
        }

        while (l2 != null) {
            node?.next = l2
            l2 = l2.next
            node = node?.next
        }

        return resultNode.next

    }
}