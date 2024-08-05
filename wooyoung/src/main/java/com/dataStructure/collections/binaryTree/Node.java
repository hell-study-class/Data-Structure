package com.dataStructure.collections.binaryTree;

public class Node implements Comparable<Node> {

    private Integer value;
    private Node left;
    private Node right;

    private Node parent;

    public Node() {
        this.value = null;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Node(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    @Override
    public int compareTo(Node node) {
        return this.value - node.value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }


    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return this.parent;
    }
}

