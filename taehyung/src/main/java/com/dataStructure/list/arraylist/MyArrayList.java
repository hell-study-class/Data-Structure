package com.dataStructure.list.arraylist;

import com.dataStructure.list.MyList;
import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_SIZE = 5;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_SIZE];
        size = 0;
    }

    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
        size = 0;
    }

    private void resize() {
        int elementLength = elementData.length;
        if (size == elementLength) {
            int newLength = elementLength * 2;
            elementData = Arrays.copyOf(elementData, newLength);
        } else if (size == 0) {
            elementData = new Object[DEFAULT_SIZE];
        }
    }

    @Override
    public boolean add(E value) {
        resize();
        elementData[size++] = value;
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            add(value);
        } else {
            resize();
            for (int i = size - 1; i >= index; i--) {
                elementData[i + 1] = elementData[i];
            }
            elementData[index] = value;
            size++;
        }
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            E e = (E) elementData[size];
            for (int i = index; i < size - 1; i++) {
                elementData[i] = elementData[i + 1];
            }
            elementData[size-1] = null;
            size--;
            return e;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elementData[index] = value;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == o) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elementData = new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public String toString() {
        return "elementData=" + Arrays.toString(elementData);
    }
}
