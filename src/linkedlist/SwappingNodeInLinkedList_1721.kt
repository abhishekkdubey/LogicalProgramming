package linkedlist

/**
 * 1721. Swapping Nodes in a Linked List
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 *
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */
class SwappingNodeInLinkedList_1721 {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val node = SwappingNodeInLinkedList_1721().swapNodes(getlinkedList2(), 7)
            var root = node
            println()
            while (root != null) {
                print("${root.`val`},  ")
                root = root.next
            }
            println()
        }

        fun getlinkedList1(): ListNode? {
            val listNode = ListNode(1)
            listNode.next = ListNode(2)
            listNode.next?.next = ListNode(3)
            listNode.next?.next?.next = ListNode(4)
            listNode.next?.next?.next?.next = ListNode(5)
            return listNode

        }
        fun getlinkedList2(): ListNode? {
            val listNode = ListNode(7)
            listNode.next = ListNode(9)
            listNode.next?.next = ListNode(6)
            listNode.next?.next?.next = ListNode(6)
            listNode.next?.next?.next?.next = ListNode(7)
            listNode.next?.next?.next?.next?.next = ListNode(8)
            listNode.next?.next?.next?.next?.next?.next = ListNode(3)
            listNode.next?.next?.next?.next?.next?.next?.next = ListNode(0)
            listNode.next?.next?.next?.next?.next?.next?.next?.next = ListNode(9)
            listNode.next?.next?.next?.next?.next?.next?.next?.next?.next = ListNode(5)

            return listNode

        }
    }



    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        var count1 = 0
        var count2 = 0
        var leftKthNode: ListNode? = null

        var node1: ListNode? = head
        var node2: ListNode? = head

        while (node2 != null) {
            if (count1 == k - 1) {
                leftKthNode = node1
            }
            node1 = node1?.next
            count1++
            if (node2.next != null) {
                node2 = node2.next?.next
                count2 += 2
            } else {
                count2++
                node2 = null
            }
        }
        val listSize = count2

        println(listSize)

        var rightKthPosition = listSize - k

        node2 = if (count1 <= rightKthPosition) {
            rightKthPosition -= count1
            node1
        } else if (k <= rightKthPosition) {
            rightKthPosition -= k
            leftKthNode
        } else {
            head
        }

        while (rightKthPosition > 0) {
            node2 = node2?.next
            rightKthPosition--
        }
        if (leftKthNode==null){
            while (count1<k-1){
                node1 = node1?.next
                count1++
            }
            leftKthNode = node1
        }
        //Now node2 become right Kth node, So swap node2 value with leftKthNode and return the head
        val temp = node2?.`val`
        node2?.`val` = leftKthNode?.`val`!!
        leftKthNode.`val` = temp!!
        return head

    }
}