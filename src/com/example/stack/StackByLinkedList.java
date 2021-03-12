package com.example.stack;

import linkedlist.SingleLinkedList;

public class StackByLinkedList {

    SingleLinkedList singleLinkedList;

    public StackByLinkedList() {
        singleLinkedList = new SingleLinkedList();
    }


    public void push(int val) {
        if (singleLinkedList == null) {
            System.out.println("Stack is not initialized!!");
        } else {
            singleLinkedList.insertToFirst(val);
            System.out.println("Value " + val + " pushed successfully!!");
        }
    }

    public int pop() {
        if (singleLinkedList == null) {
            System.out.println("Stack is not initialized!!");
        } else if (singleLinkedList.getHead() == null) {
            System.out.println("Stack is Empty!!");
        } else {
            int returnVal = singleLinkedList.getHead().value;
            singleLinkedList.deleteFirst();
            return returnVal;
        }
        return -1;
    }

    public int peek() {
        if (singleLinkedList == null) {
            System.out.println("Stack is not initialized!!");
        } else if (singleLinkedList.getHead() != null) {
            return singleLinkedList.getHead().value;
        }
        System.out.println("Stack is Empty!!");

        return -1;
    }


    public boolean isEmpty() {
        return singleLinkedList.getSize() == 0;
    }


    public boolean delete() {
        if (singleLinkedList != null) {
            singleLinkedList = null;
            return true;
        } else {
            return false;
        }
    }


}
