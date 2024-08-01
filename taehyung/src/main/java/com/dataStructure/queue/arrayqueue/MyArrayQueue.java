//package com.dataStructure.queue.arrayqueue;
//
//import com.dataStructure.queue.Queue;
//import java.util.Arrays;
//
//public class MyArrayQueue<E> implements Queue<E> {
//
//    private static final int DEFAULT_SIZE = 5;
//    private Object[] elementData;
//    private int size;
//    private int front;
//    private int rear;
//
//    public MyArrayQueue() {
//        this.elementData = new Object[DEFAULT_SIZE];
//        this.size = DEFAULT_SIZE;
//        this.front = 0;
//        this.rear = 0;
//    }
//
//    @Override
//    public void resize(int newSize) {
//        elementData = Arrays.copyOf(elementData, newSize);
//    }
//
//    @Override
//    public boolean offer(E e) {
//        rear = (rear + 1) % size;
//        return true;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public E poll() {
//        front = (front + 1) % size;
//        size--;
//        return (E) elementData[front];
//    }
//
//    @Override
//    public E remove() {
//        return null;
//    }
//
//    @Override
//    public E peek() {
//        return (E) elementData[rear];
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    @Override
//    public boolean contains(E value) {
//        for (int i = 0; i < size; i++) {
//            if (elementData[i].equals(value)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void clear() {
//        elementData = new Object[DEFAULT_SIZE];
//        size = DEFAULT_SIZE;
//        this.rear = 0;
//    }
//
//    @Override
//    public Object[] toArray() {
//        return elementData;
//    }
//
//    @Override
//    public Object clone() {
//        return null;
//    }
//
//    @Override
//    public void sort() {
//
//    }
//}
