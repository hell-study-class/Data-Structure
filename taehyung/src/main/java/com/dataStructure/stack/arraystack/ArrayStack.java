package com.dataStructure.stack.arraystack;

import com.dataStructure.stack.Stack;
import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {

    private static int DEFAULT_SIZE = 5;
    private Object[] elementData;
    private int size;

    private void resize() {
        if (elementData.length == size) {
            elementData = Arrays.copyOf(elementData, size * 2);
        } else if (size == 0) {
            elementData = new Object[DEFAULT_SIZE];
        }
    }

    public ArrayStack() {
        elementData = new Object[DEFAULT_SIZE];
        size = 0;
    }
    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (empty()) {
            throw new RuntimeException("stack is empty");
        }
        return (E) elementData[size-1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if (empty()) {
            throw new RuntimeException("stack is empty");
        }
        E data = (E) elementData[size-1];
        elementData[size-1] = null;
        size--;
        resize();
        return data;
    }

    @Override
    public E push(E item) {
        resize();
        elementData[size++] = item;
        return item;
    }

    @Override
    public int search(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
