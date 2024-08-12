package com.dataStructure;

public interface CustomTree<E> {

    boolean add(E value);

    E remove(Object o) ;

    int size() ;

    boolean isEmpty();

    boolean contains(Object o);

    void clear();

}
