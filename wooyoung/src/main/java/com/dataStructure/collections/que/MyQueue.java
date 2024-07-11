package com.dataStructure.collections.que;

public interface MyQueue<E> {

    void resize(int newSize);

    boolean offer(E e);

    E poll();

    E remove();

    E peek();

    int size();

    boolean isEmpty();

    boolean contains(E value);

    void clear();

    Object[] toArray();

    Object clone();

    void sort();

}