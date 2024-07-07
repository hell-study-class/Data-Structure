package com.dataStructure.collections.circularSinglyLinkedList;

import com.dataStructure.collections.arrayList.MyList;
import com.dataStructure.collections.linkedList.MyDoublyLinkedList;

public class CircularSinglyLinkedList<T> implements MyList<T> {

    private Node<T> tail;
    private int size;

    public CircularSinglyLinkedList(){
        this.tail = null;
        this.size = 0;
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public boolean add(T value) {
        Node<T> newNode = new Node<>(value, null);
        if(size == 0){
            tail = newNode;
            newNode.next = newNode;
            size++;
        }else{
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
            size++;
        }

        return true;
    }

    @Override
    public void add(int index, T value) {
        if(index < 0 || index > size){
            System.out.println(-1);
            return;
        }
        Node<T> newNode = new Node<>(value, null);
        if(index == 0){
            newNode.next = tail.next;
            tail.next = newNode;
        }else if(index == size-1){
            newNode.next = tail.next;
            tail = newNode;
        }else{
            Node<T> current = tail.next;
            for(int i=0; i<index-1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = tail.next;
        if(current.item.equals(o)){
            tail.next = current.next;
            size--;
            return true;
        }

        for(int i=0; i<size-1; i++){
            if(current.next.item.equals(o)){
                current.next = current.next.next;
                size--;
                return true;
            }else if(i == size-2 && current.next.item.equals(o)){
                tail = current;
                size--;
                return true;
            }else{
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= size){
            System.out.println(-1);
        }
        Node<T> current = tail.next;

        if(index == 0){
            tail.next = current.next;
            return current.item;
        }

        for(int i=0; i<index-1; i++){
            current = current.next;
        }
        T result = current.next.item;
        current.next = current.next.next;

        return result;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            System.out.println(-1);
        }
        Node<T> current = tail.next;
        for(int i=0; i<index; i++){
            current = current.next;
        }

        return current.item;
    }

    @Override
    public void set(int index, T value) {
        if(index < 0 || index >= size){
            System.out.println(-1);
        }
        Node<T> current = tail.next;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        current.item = value;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = tail.next;
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
        Node<T> current = tail.next;
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
        Node<T> current = tail.next;
        int lastIndex = -1;
        for(int i=0; i<size; i++){
            if(current.item.equals(o)){
                if(lastIndex < i){
                    lastIndex = i;
                }
            }
            current = current.next;
        }
        return lastIndex;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0 ? false : true;
    }

    @Override
    public void clear() {
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        String result = "";
        if(tail == null){
            return "CircularLinkedList{" +
                    result +
                    '}';
        }else{
            Node<T> n = tail.next;

            for(int i=0; i<size; i++){
                result = result + n.item + " ";
                n = n.next;
            }
            return "CircularLinkedList{" +
                    result +
                    '}';
        }
        }

}
