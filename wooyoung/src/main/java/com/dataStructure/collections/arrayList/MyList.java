package com.dataStructure.collections.arrayList;

import java.io.Serializable;

public interface MyList<T> extends Serializable {

    static final long serialVersionUID = 1L;

    boolean add(T value);

    void add(int index, T value);

    boolean remove(T value);

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
