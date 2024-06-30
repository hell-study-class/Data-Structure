package com.dataStructure.collections.linkedList;

public class Node<T> {

    private T value;
    private Node nextNode;


    public Node() {
        this.value = null;
        this.nextNode = null;
    }

    public Node(T value) {
        this.value = value;
        this.nextNode = null;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
