package com.example.queue;

public class Queue {

    private int[] arr;

    private int startIndex;
    private int topIndex;


    public Queue(int size) {
        arr = new int[size];
        startIndex = topIndex = -1;

    }


    public boolean enQueue(int val) {
        if (topIndex < arr.length-1) {
            arr[topIndex + 1] = val;
            topIndex++;
            if (startIndex == -1) {
                startIndex++;
            }
            System.out.println(val+" inserted Successfully !!");
            return true;
        } else {
            System.out.println("Queue is full!!");
            return false;
        }
    }

    public int deQueue() {
        if (topIndex == -1) {
            throw new EmptyQueueException("Queue is empty !!");
        } else {
            int val = arr[startIndex];
            startIndex++;
            if (startIndex > topIndex) {
                startIndex = topIndex = -1;
            }
            return val;
        }
    }


    public int peek() {
        if (topIndex == -1) {
            throw new EmptyQueueException("Queue is empty !!");
        } else {
            return arr[startIndex];
        }
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }


    public boolean isFull() {
        return topIndex == arr.length-1;
    }

    public void delete(){
        arr = null;
        startIndex = topIndex = -1;
    }
}

class EmptyQueueException extends NullPointerException {

    public EmptyQueueException(String s) {
        super(s);
    }
}
