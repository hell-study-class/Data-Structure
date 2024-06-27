package com.dataStructure;

public interface CustomList<T> {
    boolean add(T value);
    void add(int index, T value);
    boolean remove(Object o);
    T remove(int index);
    T get(int index);
    void set(int index, T value);
    boolean contains(Object o);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    int size();
    boolean isEmpty();
    public void clear();
}
