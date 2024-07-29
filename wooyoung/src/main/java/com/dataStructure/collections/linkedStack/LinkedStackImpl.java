package com.dataStructure.collections.linkedStack;

public class LinkedStackImpl<T> implements LinkedStack {

    private int size = 0;

    private Node<T> bottom;

    private Node<T> top;

    public LinkedStackImpl() {
        bottom = null;
        top = null;
        size = 0;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public Object peek() {
        return top.getValue();
    }

    @Override
    public Object pop() {
        Node temp = top;
        if (size <= 0) {
            throw new IllegalArgumentException();
        } else if (size == 1) {
            bottom = null;
            top = null;

        } else if (size == 2) {
            bottom.setNext(null);
            top = bottom;
        } else {
            top = top.getPrev();
            top.setNext(null);
        }
        size--;

        return temp.getValue();
    }

    @Override
    public Object push(Object item) {
        Node newNode = new Node(item);
        if (size == 0) {
            bottom = newNode;
            top = newNode;
        } else if (size == 1) {
            bottom.setNext(newNode);
            top = newNode;
            top.setPrev(bottom);
        } else {
            Node temp = top;
            top = newNode;
            top.setPrev(temp);
        }
        size++;

        return newNode.getValue();
    }

    @Override
    public int search(Object o) {
        Node node = top;
        int index = 1;
        do {
            if (node.getValue().equals(o)) {
                return index;
            }
            index++;
            node = node.getPrev();
        } while (index < size + 1);

        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
