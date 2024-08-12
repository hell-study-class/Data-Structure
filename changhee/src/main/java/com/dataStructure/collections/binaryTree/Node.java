package com.dataStructure.collections.binaryTree;

public class Node<E>{
    E value;
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    Node(E value){
        this(value, null);
    }

    Node(E value, Node<E> parent){
        this.value = value;
        this.parent = parent;
        left = null;
        right = null;
    }


}
