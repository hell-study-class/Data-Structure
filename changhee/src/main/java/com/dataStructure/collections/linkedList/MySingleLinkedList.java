package com.dataStructure.collections.linkedList;

import com.dataStructure.collections.arrayList.MyList;

public class MySingleLinkedList<T> implements MyList {

    private Node<T> head;
    private Node<T> tail;

    private int size;

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public boolean add(Object value) {
        Node<T> newNode = new Node(value, null);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;

        return true;
    }

    @Override
    public void add(int index, Object value) {
        if(index < 0 || index >= size){
            System.out.println(-1);
            return;
        }
        Node<T> newNode = new Node(value, null);
        Node<T> current = head;

        if(index == 0){
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        for(int i=0; i<index-1; i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
        if(index == size-1){
            tail = newNode;
        }
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head;
        if(current.item.equals(o)){
            head = current.next;
            size--;
            return true;
        }
        for(int i=0; i<size-1; i++){
            if(current.next.item.equals(o)){
                current.next = current.next.next;
                size--;
                if(i == size-2){
                    tail = current.next;
                }
                return true;
            }

            current = current.next;

        }
        return false;
    }

    @Override
    public Object remove(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node<T> current = head;
        for(int i=0; i<index-1; i++){
            current = current.next;
        }
        Object result = current.next.item;
        current.next = current.next.next;
        size--;
        if(index == size-1){
            tail = current.next;
        }
        return result;

    }

    @Override
    public Object get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node<T> current = head;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        return current.item;
    }

    @Override
    public void set(int index, Object value) {
        if(index < 0 || index >= size){
            System.out.println(-1);
            return;
        }
        Node<T> current = head;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        current.item = (T) value;
    }

    @Override
    public boolean contains(Object o) {
        if(size < 1){
            return false;
        }
        Node<T> current = head;

        for(int i=0; i<size; i++){
            if(current.item.equals(o)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        if(size < 1){
            return -1;
        }
        Node<T> current = head;
        for(int i=0; i<size; i++){
            if(current.item.equals(o)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(size < 1){
            return -1;
        }
        Node<T> current = head;
        int index = -1;
        for(int i=0; i<size; i++){
            if(current.item.equals(o) && index < i){
                index = i;
            }
            current = current.next;
        }
        return index;
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
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        String result = "";
        Node<T> n = head;
        for(int i=0; i<size; i++){
            result = result + n.item + " ";
            n = n.next;
        }
        return "MySingleLinkedList{" + result.toString() + "}";
    }
}
