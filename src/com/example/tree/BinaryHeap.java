package com.example.tree;

public class BinaryHeap {


    private int[] arr;
    private int sizeOfHeap;

    public BinaryHeap(int size) {
        arr = new int[size + 1];
        sizeOfHeap = 0;
    }


    public int peekTopOfHeap() {
        if (arr != null && sizeOfHeap > 0) {
            return arr[1];
        } else {
            throw new NullPointerException("BinaryHeap is null or not initialized");
        }
    }


    public int getSizeOfHeap() {
        return sizeOfHeap;
    }

    public void insert(int val) {
        if (arr == null) {
            throw new NullPointerException("BinaryHeap is null or not initialized");
        } else if (sizeOfHeap < arr.length - 1) {
            arr[sizeOfHeap + 1] = val;
            sizeOfHeap++;
            heapifyBottomToTop(sizeOfHeap);
        } else {
            throw new IndexOutOfBoundsException("BinaryHeap is full");
        }
    }

    private void heapifyBottomToTop(int index) {
        int parent= index/2;

        if (index<=1){
            return;
        }if (arr[index] < arr[parent]) {
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
        }
        heapifyBottomToTop(parent);
    }

    private void heapifyTopToBottom(int index){
        int left=  index*2;
        int right = index*2+1;
        int smallestChild;

        if (sizeOfHeap<left){
            return;
        }else if (sizeOfHeap == left){
            if (arr[index] >arr[left]){
                int temp = arr[index];
                arr[index] = arr[left];
                arr[left] = temp;
            }
            return;
        }else{
            if (arr[left]<arr[right]){
                smallestChild = left;
            }else{
                smallestChild = right;
            }

            if (arr[index]>arr[smallestChild]){
                int temp = arr[index];
                arr[index] = arr[smallestChild];
                arr[smallestChild] = temp;
            }
        }
        heapifyTopToBottom(smallestChild);
    }

    public int extractHeadOfTop() {

        if (sizeOfHeap==0){
            return -1;
        }else{
            int val = arr[1];
            arr[1] = arr[sizeOfHeap];
            sizeOfHeap--;
            heapifyTopToBottom(1);
        }
        return 0;
    }
}
