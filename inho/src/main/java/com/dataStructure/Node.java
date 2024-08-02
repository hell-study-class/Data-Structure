package com.dataStructure;

public class Node<E> {

    E data;
    Node<E> left;
    Node<E> right;
    Node<E> parent;
    public Node(E data){
        this.data = data;
        left = null;
        right = null;
    }
    public E getData(){
        return data;
    }

    public void setData(E data){
        this.data = data;
    }

    public Node<E> getLeft(){
        return left;
    }

    public void setLeft(Node<E> left){
        this.left = left;
    }

    public Node<E> getRight(){
        return right;
    }

    public void setRight(Node<E> right){
        this.right = right;
    }

    public boolean hasLeft(){
        return left != null;
    }

    public boolean hasRight(){
        return right != null;
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }
}
