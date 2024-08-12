package com.dataStructure.collections.binarySearchTree;

public interface CustomBinarySearchTree<E> {
    boolean add(E value);

    E remove(Object o) ;

    int size() ;

    boolean isEmpty();

    boolean contains(Object o);

    void clear();

    void preorder();

    void inorder();

    void postorder();
}
