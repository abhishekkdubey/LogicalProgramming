package com.example.stack;

public class StackByArray {

    int topOfStack;
    int[] arr;

    public StackByArray(int capacity) {

        arr = new int[capacity];
        topOfStack = -1;
    }


    public void push(int val) {
        if (arr == null) {
            System.out.println("Stack is not initialized!!");
        } else {
            if (topOfStack < arr.length - 1) {
                topOfStack++;
                arr[topOfStack] = val;
                System.out.println("Value " + val + " pushed successfully!!");
            } else {
                System.out.println("Stack is full !!");
            }
        }
    }

    public int pop() {
        if (arr == null) {
            System.out.println("Stack is not initialized!!");
        } else if (topOfStack != -1) {
            topOfStack--;
            return arr[topOfStack + 1];
        } else {
            System.out.println("Stack is Empty!!");
        }
        return -1;
    }

    public int peek() {
        if (arr == null) {
            System.out.println("Stack is not initialized!!");
        } else {
            return arr[topOfStack];
        }
        return -1;
    }


    public boolean isEmpty() {
        if (topOfStack == -1) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isFull() {
        return topOfStack == arr.length - 1;
    }

    public boolean delete() {
        if (arr != null) {
            arr = null;
            topOfStack = -1;
            return true;
        } else {
            return false;
        }
    }


}
