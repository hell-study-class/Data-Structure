package com.dataStructure.collections.arrayDeque;

public class MyArrayDeque<E> implements CustomQueue<E> {

    private int size;
    private int front;
    private int rear;
    private Object[] array;

    public MyArrayDeque(){
        this.front = 0;
        this.rear = 0;
        this.array = new Object[16];
        this.size = 0;
    }
    public MyArrayDeque(int capacity){
        this.array = new Object[16];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public void resize(int newSize) {
        int current_size = array.length;
        Object[] newArray = new Object[newSize];
        for(int i=1, j = front+1; i<=size; i++, j++){
            newArray[i] = array[j % current_size];
        }
        this.array = newArray;
        front = 0;
        rear = size;
    }

    @Override
    public boolean offer(E e) {
        if((rear+1) % array.length == front){
            resize(array.length * 2);
        }

        rear = (rear+1) % array.length;

        this.array[rear] = e;
        size++;

        return true;
    }

    @Override
    public E poll() {
        if(front==rear){
            return null;
        }
        E result = (E) this.array[front++];
        size--;
        return result;
    }

    @Override
    public E remove() {
        return poll();
    }

    @Override
    public E peek() {

        return (E) array[rear];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    @Override
    public boolean contains(E value) {
        for(int i=1; i<=size; i++){
            if(array[(front+i)%size].equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        return array;
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
        for(int i=(front+1); i<=rear; i++){
            sb.append(array[i%size]).append(" ");
        }
        return "ArrayDeque : {"
                +sb.toString()+
                "}";
    }
}
