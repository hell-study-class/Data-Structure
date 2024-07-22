package com.dataStructure;

public class LinkedListQueue<E> implements CustomQueueBasic<E> {

    class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean offer(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public E poll() {
        if (head == null) {
            return null;
        }
        Node<E> temp = head;
        E result = temp.data;

        head = temp.next;

        temp.next = null;
        temp.data = null;
        size--;
        return result;
    }

    @Override
    public E peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> temp = head;
        while (temp != null) {
            sb.append(temp.data);
            sb.append(", ");
            temp=temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return size;
    }
}