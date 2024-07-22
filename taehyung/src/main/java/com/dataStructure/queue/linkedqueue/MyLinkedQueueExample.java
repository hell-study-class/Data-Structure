package com.dataStructure.queue.linkedqueue;

public class MyLinkedQueueExample {
    public static void main(String[] args) {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println("queue = " + queue);

        System.out.println("peek must be 1");
        System.out.println(queue.peek());

        queue.poll();
        System.out.println("queue = " + queue);

        queue.offer(6);
        System.out.println("queue = " + queue);
    }
}
