package com.example.stack;

public class StackMain {
    public static void main(String[] args) {

        System.out.println("/----------Stack By Array------------/");
        System.out.println("Creating a stack of size 5...");
        StackByArray stack = new StackByArray(5);


        String st1 = "FB";
        String st2 = "Ea";
        System.out.println("HashCode st1 :"+st1.hashCode()+" st2: "+st2.hashCode());
        System.out.println("Pushing 6 values in the Stack...");
        for(int i=0; i<=5; i++) {
            stack.push(i*10);
        }


        System.out.println("Peeking value from stack");
        System.out.println(stack.peek());


        System.out.println("Poping 6 values from the Stack...");
        for(int i=0; i<=5; i++) {
            System.out.println(stack.pop());
        }


        System.out.println("Deleting the Stack...");
        System.out.println(stack.delete());
        System.out.println("/----------Stack By Array------------/");

        System.out.println("/----------Stack By LinkedList------------/");
        System.out.println("Creating a stack of size 5...");
        StackByLinkedList stackLL = new StackByLinkedList();


        System.out.println("Pushing 6 values in the Stack...");
        for(int i=0; i<=5; i++) {
            stackLL.push(i*10);
        }


        System.out.println("Peeking value from stack");
        System.out.println(stackLL.peek());


        System.out.println("Poping 6 values from the Stack...");
        for(int i=0; i<=5; i++) {
            System.out.println(stackLL.pop());
        }


        System.out.println("Deleting the Stack...");
        System.out.println(stackLL.delete());
        System.out.println("/----------Stack By LinkedList------------/");

    }
}
