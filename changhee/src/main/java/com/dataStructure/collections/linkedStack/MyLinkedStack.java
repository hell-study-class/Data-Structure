package com.dataStructure.collections.linkedStack;

import java.util.ArrayList;
import java.util.Collections;

public class MyLinkedStack<T> implements CustomLinkedStack{
    private Node<T> top;
    private Node<T> bottom;
    private int size;
    private static class Node<T>{
        private T item;
        private Node<T> prev;

        public Node(T item, Node<T> prev){
            this.item = item;
            this.prev = prev;
        }
    }

    public MyLinkedStack(){
        this.top = null;
        this.bottom = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return bottom == null;
    }

    @Override
    public Object peek() {
        if(size <= 0 || top == null || bottom == null){
            return null;
        }
        return top.item;
    }

    @Override
    public Object pop() {
        if(size <= 0 || top == null || bottom == null){
            return null;
        }
        if(size == 1){
            bottom = null;
        }
        Object result = top.item;
        top = top.prev;
        size--;
        return result;
    }

    @Override
    public Object push(Object item) {
        Node<T> newNode = new Node<>((T) item, top);
        if(size == 0){
            bottom = newNode;
        }
        top = newNode;
        size++;

        return item;
    }

    @Override
    public int search(Object o) {
        Node<T> current = top;
        for(int i=0; i<size; i++){
            if(current.item.equals(o)){
                return size-i;
            }
            current = current.prev;
        }

        return -1;
    }

    public int size(){
        return size;
    }

    public void clear(){
        top = bottom = null;
        size = 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = top;
        ArrayList<T> list = new ArrayList<>();
        while(current!= null){
            list.add(current.item);
            current = current.prev;
        }
        Collections.reverse(list);
        for(T item : list){
            sb.append(item).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
