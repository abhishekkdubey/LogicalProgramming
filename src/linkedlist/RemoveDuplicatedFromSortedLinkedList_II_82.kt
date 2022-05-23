package linkedlist

class RemoveDuplicatedFromSortedLinkedList_II_82 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            val head = ListNode(1)
            head.next = ListNode(2)
            head.next?.next = ListNode(3)
            head.next?.next?.next = ListNode(3)
            head.next?.next?.next?.next = ListNode(4)
            head.next?.next?.next?.next?.next = ListNode(4)
            head.next?.next?.next?.next?.next?.next = ListNode(5)
            RemoveDuplicatedFromSortedLinkedList_II_82().deleteDuplicates(head)

            val head1 = ListNode(1)
            head1.next = ListNode(1)
            head1.next?.next = ListNode(1)
            head1.next?.next?.next = ListNode(1)
            RemoveDuplicatedFromSortedLinkedList_II_82().deleteDuplicates(head1)

        }
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {

        val fakeNode = ListNode(0)
        fakeNode.next = head
        var curr = head
        var prev: ListNode? = fakeNode
        while (curr != null) {

            while (curr?.next != null && curr.`val` == curr.next?.`val`) {
                curr = curr.next
            }

            if (prev?.next == curr) {
                prev = prev?.next
            } else {
                prev?.next = curr?.next
            }
            curr = curr?.next
        }
        return fakeNode.next
    }


    fun solution(n: Int): Int {
        var n = n
        val d = IntArray(30)
        var l = 0
        var p: Int
        while (n > 0) {
            d[l] = n % 2
            n /= 2
            l++
        }
        p = 1
        while (p < 1 + l) {
            var i: Int
            var ok = true
            i = 0
            while (i < l - p) {
                if (d[i] != d[i + p]) {
                    ok = false
                    break
                }
                ++i
            }
            if (ok) {
                return p
            }
            ++p
        }
        return -1
    }


}