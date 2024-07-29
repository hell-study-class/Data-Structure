package com.dataStructure;

import java.util.EmptyStackException;

public class LinkedStack<E> implements CustomStack<E>{

    class Node<E> {

        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }

    }

    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }


    @Override
    public boolean empty() {
        return size==0;
    }

    @Override
    public E peek() {
        if (empty()){
            throw new EmptyStackException();
        }
        else{
            return top.data;
        }
    }

    @Override
    public E pop() {
        if (empty()){
            throw new EmptyStackException();
        }
        else{
            E element = top.data;
            top = top.next;
            size--;
            return element;
        }
    }

    @Override
    public E push(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
        return newNode.data;
    }

    @Override
    public int search(E o) {
        if(empty()){
            return -1;
        }
        else{
            Node<E> current = top;
            for (int i = 0; i < size; i++) {
                if(current.data.equals(o)){
                    return i;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = top;
        for (int i = 0; i < size; i++) {
            if (current.next == null) {
                sb.append(current.data);
            }else{
                sb.append(current.data+", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
