package com.dataStructure.queue.linkedqueue;

import com.dataStructure.queue.MyQueue;
import java.util.Arrays;

public class MyLinkedQueue<E> implements MyQueue<E> {

    private static class Node<E> {
        private Node<E> prev;
        private E data;
        private Node<E> next;

        public Node(E data) {
            prev = null;
            this.data = data;
            next = null;
        }

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    private Node<E> front;
    private Node<E> back;

    public MyLinkedQueue() {
        this.size = 0;
        this.front = null;
        this.back = null;
    }

    @Override
    public boolean offer(E e) {
        if (back == null) {
            front = new Node<>(e);
            back = front;
        } else {
            back.next = new Node<>(back, e, null);
            back = back.next;
        }
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        E data = front.data;
        front = front.next;
        front.prev = null;
        size--;
        return data;
    }

    @Override
    public E peek() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    @Override
    public String toString() {
        Object[] objects = new Object[size];
        Node<E> node = front;
        for (int i = 0; i < size; i++) {
            objects[i] = node.data;
            node = node.next;
        }
        return Arrays.toString(objects);
    }
}
