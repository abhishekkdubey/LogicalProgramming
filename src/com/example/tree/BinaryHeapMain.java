package com.example.tree;

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

        heap.getSizeOfHeap();
        heap.peekTopOfHeap();
        heap.extractHeadOfTop();
    }
}
