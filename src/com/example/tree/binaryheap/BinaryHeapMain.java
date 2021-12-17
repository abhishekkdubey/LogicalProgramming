package com.example.tree.binaryheap;

public class BinaryHeapMain {

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(16);
        heap.insert(5);
        heap.insert(17);
        heap.insert(8);
        heap.insert(25);
        heap.insert(19);
        heap.insert(36);
        heap.insert(40);
        heap.levelOrderTraversal();

        System.out.println(heap.getSizeOfHeap());
        System.out.println(heap.peekTopOfHeap());
        System.out.println(heap.extractHeadOfTop());
        System.out.println(heap.peekTopOfHeap());
        heap.levelOrderTraversal();
        heap.insert(2);
        heap.levelOrderTraversal();
        System.out.println(heap.peekTopOfHeap());
    }
}
