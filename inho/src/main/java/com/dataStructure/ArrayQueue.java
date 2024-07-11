package com.dataStructure;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements CustomQueue<E>{

    private final static int DEFAULT_CAPACITY = 16;

    private Object[] array;
    private int size;

    private int front;
    private int rear;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayQueue(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }


    @Override
    public void resize(int newSize) {
        int arraySize = array.length;

        Object[] newArray = new Object[newSize];
        for(int i = 1, j =front+1; i < newSize; i++, j++) {
            newArray[i] = array[j % arraySize];
        }
        this.array = newArray;
        front = 0;
        rear = size;
    }

    @Override
    public boolean offer(E e) {

        if((rear+1)%array.length == front) {
            resize(2*array.length);
        }

        rear = (rear+1)%array.length;
        array[rear] = e;
        size++;
        return true;
    }

    @Override
    public E poll() {

        if(size == 0) return null;

        front = (front+1)%array.length;
        E item = (E) array[front];
        array[front] = null;
        size--;

        if(array.length > DEFAULT_CAPACITY && size == array.length/4) {
            resize(Math.max(array.length/2, DEFAULT_CAPACITY));
        }

        return item;
    }

    @Override
    public E remove() {
        E item = poll();

        if(item == null){
            throw new NoSuchElementException();
        }
        return item;
    }

    /**
     * @return 맨 처음에 들어온 값 반환
     */
    @Override
    public E peek() {
        if(size == 0) return null;

        return (E) array[(front+1) % array.length];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(E value) {
        int start = (front +1)%array.length;

        for(int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
            if(array[idx].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        int start = (front +1)%array.length;

        for(int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
            array[idx] = null;
        }
        front= rear =size = 0;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for(int i = 0, idx = front+1; i < size; i++, idx = (idx + 1) % array.length) {
            sb.append(array[idx].toString()).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
}
