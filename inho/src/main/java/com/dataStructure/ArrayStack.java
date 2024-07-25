package com.dataStructure;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements CustomStack<E> {

    private final static int DEFAULT_CAPACITY = 10;
    private final static Object[] EMPTY_ARRAYSTACK = {};

    private Object[] arrStack;
    private int size;
    private int top;

    public ArrayStack() {
        arrStack = EMPTY_ARRAYSTACK;
        size = 0;
        top = -1;
    }

    public ArrayStack(int capacity) {
        arrStack = new Object[capacity];
        size = 0;
        top = -1;
    }

    private void resize() {
        if(arrStack == EMPTY_ARRAYSTACK) {
            arrStack = new Object[DEFAULT_CAPACITY];
        }
        else if(size == arrStack.length) {
            Arrays.copyOf(arrStack, arrStack.length * 2);
        }
        else if(size < arrStack.length/2) {
            int change = arrStack.length/2;
            if(change < DEFAULT_CAPACITY){
                change = DEFAULT_CAPACITY;
            }
            Arrays.copyOf(arrStack, change);
        }
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public E peek() {
        if(empty()) {
            throw new NoSuchElementException();
        }

        return (E) arrStack[top];
    }

    @Override
    public E pop() {
        if(empty()) {
            throw new NoSuchElementException();
        }
        E element = (E) arrStack[top];
        arrStack[top--] = null;
        size--;
        resize();
        return element;
    }

    @Override
    public E push(E item) {
        resize();
        arrStack[++top] = item;
        size++;
        return item;
    }

    @Override
    public int search(E o) {
        if(o == null) {
            throw new NullPointerException();
        }
        if(empty()){
            throw new NoSuchElementException();
        }
        for(int i = top; i >= 0; i--) {
            if(o.equals(arrStack[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "arrStack=" + Arrays.toString(arrStack);
    }
}
