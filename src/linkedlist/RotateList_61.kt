package linkedlist

/**
 * 61. Rotate List
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Example 2:
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 *
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
class RotateList_61 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val nx = ListNode(1)
            nx.next = ListNode(2)
            nx.next?.next = ListNode(3)
            nx.next?.next?.next = ListNode(4)
            nx.next?.next?.next?.next = ListNode(5)
            nx.next?.next?.next?.next?.next = ListNode(6)
            nx.next?.next?.next?.next?.next?.next = ListNode(7)
            nx.next?.next?.next?.next?.next?.next?.next = ListNode(8)

            val n2 = ListNode(1)
            n2.next = ListNode(2)
            n2.next?.next = ListNode(3)
            n2.next?.next?.next = ListNode(4)
            n2.next?.next?.next?.next = ListNode(5)
            n2.next?.next?.next?.next?.next = ListNode(6)
            n2.next?.next?.next?.next?.next?.next = ListNode(7)
            n2.next?.next?.next?.next?.next?.next?.next = ListNode(8)
            val resNode1 = RotateList_61().rotateRight(nx, 13)
            var rNode1 = resNode1
            println()
            print("[")
            while (rNode1 != null) {
                print("${rNode1.`val`}, ")
                rNode1 = rNode1.next
            }
            print("]")
            println()

            val resNode = RotateList_61().rotateRight1(n2, 13)
            var rNode = resNode
            println()
            print("[")
            while (rNode != null) {
                print("${rNode.`val`}, ")
                rNode = rNode.next
            }
            print("]")
            println()
        }
    }

    fun rotateRight(head: ListNode?, k: Int): ListNode? {

        if (head?.next == null || k == 0) {
            return head
        }

        var size = 0
        var node = head
        var prev: ListNode? = null
        while (node != null) {
            size++
            prev = node
            node = node.next
        }

        if (k % size == 0) {
            return head
        }


        val rotation = if (k > size) {
            k % size
        } else {
            k
        }
        var r = size-rotation

        var rNode: ListNode? = head

        while (r > 1) {
            rNode = rNode?.next
            r--
        }

        val rHead = rNode?.next
        rNode?.next = null
        prev?.next = head

        return rHead


    }

    fun rotateRight1(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) return head
        val dummy = ListNode(0)
        dummy.next = head
        var fast: ListNode? = dummy
        var slow: ListNode? = dummy
        var i = 0
        while (fast?.next != null) {
            //Get the total length
            fast = fast.next
            i++
        }
        for (j in i - k % i downTo 1)  //Get the i-n%i th node
            slow = slow?.next
        fast?.next = dummy.next //Do the rotation
        dummy.next = slow?.next
        slow?.next = null
        return dummy.next
    }
}