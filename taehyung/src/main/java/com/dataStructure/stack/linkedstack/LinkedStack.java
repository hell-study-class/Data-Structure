package com.dataStructure.stack.linkedstack;

import com.dataStructure.stack.Stack;

public class LinkedStack<E> implements Stack<E> {

    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }
    }

    private Node<E> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new RuntimeException("stack is empty");
        }
        return top.data;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new RuntimeException("stack is empty");
        }
        E data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    @Override
    public E push(E item) {
        top = new Node<>(item, top);
        size++;
        return item;
    }

    @Override
    public int search(Object o) {
        Node<E> node = top;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(o)) {
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }
}
