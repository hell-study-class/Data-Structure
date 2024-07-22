package com.dataStructure.collections.linkedQueue;

import com.dataStructure.collections.linkedList.MySingleLinkedList;

public class MyLinkedQueue<E> implements CustomLinkedQueue{

    private Node<E> head;
    private Node<E> tail;

    private int size;

    public static class Node<E>{
        private E item;
        private Node<E> next;

        Node(E item, Node<E> next){
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public boolean offer(Object o) {
        Node<E> newNode = new Node(o, null);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        return false;
    }

    public int size(){
        return size;
    }

    @Override
    public Object poll() {
        if(size == 0){
            return null;
        }else if(size == 1){
            Node<E> cur = head;
            head = tail = null;
            size--;
            return cur.item;
        }
        else{
            Node<E> cur = head;
            head = cur.next;
            size--;
            return cur.item;
        }

    }

    @Override
    public Object peek() {
        if(size == 0){
            return null;
        }
        return head.item;
    }

    public void clear(){
        size = 0;
        head = tail = null;
    }

    @Override
    public String toString() {
        String result = "";
        Node<E> n = head;
        for(int i=0; i<size; i++){
            result = result + n.item + " ";
            n = n.next;
        }
        return "MySingleLinkedList{" + result.toString() + "}";
    }
}
