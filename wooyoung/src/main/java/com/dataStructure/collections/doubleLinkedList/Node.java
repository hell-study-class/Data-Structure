package com.dataStructure.collections.doubleLinkedList;

public class Node<T> {

    private T value;
    private Node prev;
    private Node next;


    public Node() {
        this.value = null;
        this.prev = null;
        this.next = null;
    }

    public Node(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }


    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

