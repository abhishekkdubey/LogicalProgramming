package com.example.practice;

public class SingleLinkedList {


    public static void main(String[] args) {
        Node node1 = new Node(6);
        node1.next = new Node(5);
        node1.next.next = new Node(9);
        node1.next.next.next = new Node(2);
        node1.next.next.next.next = new Node(1);

        traverse(soring(node1));
//        Node node2 = new Node(11);
//        node2.next = new Node(7);
//        node2.next.next = new Node(4);
//        soring(node1);
//        traverse(merge(node1, node2));
//        Node node3 = new Node(11);
//        node3.next = new Node(12);
//        node3.next.next = new Node(13);
//        node3.next.next.next = new Node(14);

//        traverse(reverse(node3));


    }

    private static Node merge(Node node1, Node node2) {

        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        } else {
            Node tempNode = node1;
            while (true) {
                if (tempNode.next != null) {
                    tempNode = tempNode.next;
                } else {
                    tempNode.next = node2;
                    break;
                }
            }
            return node1;
        }
    }


    private static void traverse(Node node) {
        Node tempNode = node;
        while (tempNode != null) {
            System.out.print(tempNode.value + "->");
            tempNode = tempNode.next;
        }
        System.out.println();
    }


    public static Node reverse(Node node) {
        Node current = node;
        Node reverse = null;
        while (current != null) {
            Node next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;

        }
        return reverse;
    }

    private static Node soring(Node node) {

        Node sorted = null;
        Node tempNode = node;
        while (tempNode != null) {
            Node next = tempNode.next;
            if (sorted == null || sorted.value >= tempNode.value) {
                tempNode.next = sorted;
                sorted = tempNode;
            } else {
                Node head = sorted;
                while (head.next != null && head.next.value < tempNode.value) {
                    head = head.next;
                }
                tempNode.next = head.next;
                head.next = tempNode;
            }
            tempNode = next;
        }

        return sorted;

    }


}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}