package com.dataStructure.collections.linkedList;

import java.util.Collection;

public interface MyLinkedList<T> {

    boolean add(T value);


    void add(int index, T value);

    boolean addAll(Collection<? extends T> c);

    boolean addAll(int index, Collection<? extends T> c);

    void addFirst(T value);

    void addLast(T value);

    void clear();

    boolean contains(Object o);

    T get(int index);

    T getFirst();

    T getLast();

    int indexOf(Object o);

    int lastIndexOf(Object o);

    T remove();

    T remove(int index);

    boolean remove(Object o);

    int size();
}
