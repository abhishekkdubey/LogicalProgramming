package com.example.practice;

public class TestSolution {

    public static void main(String[] args) {


    }


}


class Solution {


    public static void main(String[] args) {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);
        ls.next.next.next.next.next = new ListNode(6);
        ls.next.next.next.next.next.next = new ListNode(7);
        ls.next.next.next.next.next.next.next = new ListNode(8);
        ls.next.next.next.next.next.next.next.next = new ListNode(9);
//        ListNode lsRes = new Solution().middleNode(ls);
        ListNode lsRes = new Solution().swapNodes1(ls, 7);

//        ListNode lsRes = new Solution().removeNthFromEnd(ls, 2);

        System.out.println();
        System.out.print("[");
        while (lsRes != null) {
            System.out.print(" " + lsRes.val);
            lsRes = lsRes.next;
        }
        System.out.print("]");
        System.out.println();

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

//        if (head.next == null && n == 1) {
//            return null;
//        }

        ListNode node = head;
        int size = 0;

        while (node != null) {
            node = node.next;
            size++;

        }

//        size = size - n;

        return delete(head, n);


    }

    int n = 0;

    ListNode delete(ListNode head, int target) {
        if (head.next == null) {
            n++;
            if (target == n) {
                return null;
            }
            return head;
        }

        head.next = delete(head.next, target);

        n++;
        if (n == target) {
            return head.next;
        }
        return head;
    }


    private ListNode deleteNode(ListNode head, int size) {

        if (size == 1) {
            return head.next.next;
        } else {
            return deleteNode(head.next, --size);
        }
    }


    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        size = size / 2;
        //if(size%2>0){size = (size/2) +1;} else { size = (size/2);}
        temp = head;

        while (size > 0) {
            temp = temp.next;
            size--;
        }
        return temp;
    }


    public ListNode swapNodes(ListNode head, int k) {

        int i = 0;
        ListNode reverse = null;

        ListNode root = head;

        int nodeToSwap = Integer.MIN_VALUE;

        while (root != null) {
            i++;
            ListNode next = root.next;
            root.next = reverse;
            reverse = root;
            if (i == k) {
                nodeToSwap = root.val;
            }
            root = next;
        }

        int end = i - k + 1;
        i = 0;
        root = reverse;
        ListNode result = null;

        while (root != null) {
            i++;
            ListNode next = root.next;
            root.next = result;
            result = root;
            root = next;
            if (i == k || i == end) {
                int temp = result.val;
                result.val = nodeToSwap;
                nodeToSwap = temp;
            }
        }

        return result;
    }


    public ListNode swapNodes1(ListNode head, int k) {

        ListNode n1 = head;
        ListNode n1Prev = null;

        ListNode n2 = null;
        ListNode n2Pre = null;
        int size = 0;
        while (n1 != null) {
            size++;
            if (size == k) {
                n2Pre = n1Prev;
                n2 = n1;
            }
            n1Prev = n1;
            n1 = n1.next;
        }

        size = size - k;
        n1 = head;
        n1Prev = null;
        while (size > 0) {
            size--;
            n1Prev = n1;
            n1 = n1.next;
        }

        ListNode temp = n2.next;
        n2.next = n1.next;
        n1.next = temp;
        if (n1Prev != null && n2Pre != null) {
            n1Prev.next = n2;
            n2Pre.next = n1;
        }

        if (n2Pre ==null){
            n1 = head;
            n1.next = n2Pre;
        }
        if (n1Prev == null){
            head = n2;
            n2Pre.next = n1;
        }



        return head;
    }
}
