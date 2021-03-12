package com.example.queue;

public class QueueCircularArray {

    private int[] arr;
    private int start, top;

    public QueueCircularArray(int size) {
        arr = new int[size];
        start = top = -1;
    }


    public boolean enQueue(int val) {
        if (isFull()) {
            System.out.println("Queue is full !!");
            return false;
        } else {
            if (top + 1 == arr.length) {
                top = 0;
            } else {
                top++;
            }
            if (start == -1) {
                start++;
            }

            arr[top] = val;
            System.out.println(val + " inserted Successfully !!");
            return true;
        }
    }


    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!!");
            return -1;
        } else {
            int temp = arr[start];
            if (start == top) {
                start = top = -1;
            } else if (start + 1 == arr.length) {
                start = 0;
            } else {
                start++;
            }
            return temp;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!!");
            return -1;
        } else {
            return arr[start];
        }
    }


    public boolean isEmpty() {
        return start == -1;
    }

    public boolean isFull() {
        if (top + 1 == start) {
            return true;
        } else return start == 0 && top + 1 == arr.length;
    }
}
