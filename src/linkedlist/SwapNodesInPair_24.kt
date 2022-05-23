package linkedlist

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 *
 * Output: [2,1,4,3]
 *
 * Example 2:
 *
 * Input: head = []
 *
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1]
 *
 * Output: [1]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
class SwapNodesInPair_24 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val n1 = ListNode(1)
            n1.next = ListNode(2)
            n1.next?.next = ListNode(3)
            n1.next?.next?.next = ListNode(4)

            SwapNodesInPair_24().swapPairs(n1)
        }
    }

    fun swapPairs(head: ListNode?): ListNode? {

        val root = ListNode(0)
        root.next = head
        var node: ListNode? = root

        while (node?.next != null) {

            val tempNode1 = node.next
            val tempNode2 = tempNode1?.next
            tempNode1?.next = tempNode2?.next
            tempNode2?.next = tempNode1
            node.next = tempNode2
            node = tempNode1
        }

        return root.next
    }
}