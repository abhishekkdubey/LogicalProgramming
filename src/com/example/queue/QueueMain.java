package com.example.queue;

public class QueueMain {

    public static void main(String[] args) {

        Queue queue = new Queue(10);
        System.out.println("isEmpty(): "+queue.isEmpty());
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        queue.enQueue(60);
        queue.enQueue(70);
        queue.enQueue(80);
        queue.enQueue(90);
        System.out.println("isEmpty(): "+queue.isEmpty());
        System.out.println("isFull(): "+queue.isFull());


        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.peek());

        queue.enQueue(111);
        System.out.println("isFull(): "+queue.isFull());
        queue.enQueue(222);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        System.out.println("isEmpty(): "+queue.isEmpty());
        System.out.println("isFull(): "+queue.isFull());
        System.out.println(queue.deQueue());


    }
}
