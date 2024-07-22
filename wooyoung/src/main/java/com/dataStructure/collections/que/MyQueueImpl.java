package com.dataStructure.collections.que;

public class MyQueueImpl<T> implements MyQueue {

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private final static int DEFAULT_SIZE = 10;

    private Object[] elementData;

    private int first;
    private int last;
    private int size;

    MyQueueImpl() {
        elementData = new Object[DEFAULT_SIZE];
        first = -1;
        last = -1;
        size = 0;
    }

    @Override
    public void resize(int newSize) {

    }

    @Override
    public boolean offer(Object value) {
        if (size == elementData.length) {
            Object[] tmp = new Object[elementData.length * 2];
            for (int i = 0; i < elementData.length; i++) {
                tmp[i] = elementData[i];
            }
            elementData = tmp;
        }
        if (first == -1 && last == -1) {
            elementData[0] = value;
            size++;
            first = 0;
            last = 0;
        } else {
            last++;
            elementData[last] = value;
            size++;
        }
        return true;
    }

    @Override
    public Object poll() {
        if (size / 2 > elementData.length) {
            Object[] tmp = new Object[elementData.length / 2];
            for (int i = 0; i < elementData.length; i++) {
                tmp[i] = elementData[i];
            }
            elementData = tmp;
        }
        Object pollValue = elementData[first];
        if (size == 0) {
            throw new IllegalArgumentException("큐에 데이터가 존재하지 않습니다.");
        }
        if (size == 1) {
            elementData[first] = null;
            first--;
            size--;
            return pollValue;
        }
        for (int i = first + 1; i <= last; i++) {
            elementData[i - 1] = elementData[i];
        }
        size--;
        last--;
        return pollValue;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            throw new IllegalArgumentException("큐에 데이터가 존재하지 않습니다.");
        }
        Object peekValue = elementData[last];
        elementData[last] = null;

        last--;
        size--;

        return peekValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public void clear() {
        elementData = EMPTY_ELEMENTDATA;
        first = -1;
        last = -1;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public void sort() {

    }
}
