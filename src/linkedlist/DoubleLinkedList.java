package linkedlist;

import java.util.Stack;

public class DoubleLinkedList {

    private int size;
    private DLLNode head;
    private DLLNode tail;

    public DoubleLinkedList() {

    }

    public void insert(int val, int pos) {
        DLLNode node = new DLLNode(val);
        if (pos == 0 || size == 0) {
            node.next = head;
            head = node;
            if (size == 0) {
                tail = node;
            }
        } else if (pos >= size) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            DLLNode tempNode = head;
            int count = 1;
            while (count < pos) {
                tempNode = tempNode.next;
                count++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
            node.prev = tempNode;
        }
        System.out.println("Value " + val + " inserted successfully at position " + pos);
        size++;
    }

    public void traverse() {
        System.out.println("//--------Traversing Start-------------//");
        DLLNode next = head;
        while (next != null) {
            if (next.next != null) {
                System.out.print("| " + (next.prev == null ? null : next.prev.val) + " |" + next.val + "| " + next.next.val + " |" + "<->");
            } else {
                System.out.print("| " + next.prev.val + " |" + next.val + "| " + null + " |");
            }
            next = next.next;
        }
        System.out.println();
        System.out.println("//--------Traversing End-------------//");
    }

    public void reverseTraverse() {

        DLLNode node = tail;
        while (node != null) {
            System.out.print(node.val + " <->");
            node = node.prev;
        }
    }

    public void search(int val) {
        DLLNode node = head;
        int position = 0;
        while (position < size) {
            if (node.val == val) {
                System.out.println("Value " + val + " found at position:" + position);
                return;
            }
            position++;
            node= node.next;
        }
        System.out.println("Value " + val + " not found !! ");
    }


    public boolean clean() {
        if (size > 0) {
            DLLNode node = head;
            tail.next = null;
            while (node != null) {
                node.prev = null;
                node = node.next;
            }
            head = tail = null;
            return true;
        }
        return false;
    }


}
