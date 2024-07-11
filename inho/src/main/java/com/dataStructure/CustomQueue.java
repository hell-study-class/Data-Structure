package com.dataStructure;

public interface CustomQueue<E> {
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
