package com.dataStructure.collections.linkedList;

import com.dataStructure.collections.arrayList.MyList;

public class MyDoublyLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private Node<E> tail;

    private int size;

    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> search(int index){

        Node<E> n;

        if((size/2) > index){
            n = head;
            for(int i=0; i<index; i++){
                n = n.next;
            }
        }else{
            n = tail;
            for(int i=size-1; i > index; i--){
                n = n.prev;
            }
        }
        return n;
    }

    public E getFirst(){
        Node<E> n = head;
        if(isEmpty()){
            return (E) "-1";
        }
         return n.item;
    }

    public E getLast(){
        Node<E> n = tail;
        if(isEmpty()){
            return (E) "-1";
        }
        return n.item;
    }

    public E removeFirst(){
        Node<E> n = head;
        if(isEmpty()){
            return (E) "-1";
        }
        head = n.next;
        n.next.prev = null;
        size--;
        return n.item;
    }

    public E removeLast(){
        Node<E> n = tail;
        if(isEmpty()){
            return (E) "-1";
        }
        tail = n.prev;
        n.prev.next = null;
        size--;
        return n.item;
    }

    public boolean remove(Object o){
        if(isEmpty()){
            return false;
        }
        Node<E> n = head;
        for(int i=0; i<size; i++){
            if(n.item.equals(o)){
                Node<E> temp = n.prev;
                n.prev.next = n.next;
                n.next.prev = temp;
                size--;
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public E remove(int index){
        if(isEmpty()){
            return (E) "-1";
        }
        if(index < 0 || index >= size){
            return (E) "-1";
        }
        Node<E> n = search(index);

        if (n.prev == null && n.next == null) {
            head = null;
            tail = null;
            size--;
            return n.item;
        }else if(n.prev == null && n.next != null) {
            head = n.next;
            n.next.prev = null;
            size--;
            return n.item;
        }else if(n.prev != null && n.next == null){
            tail = n.prev;
            n.prev.next = null;
            size--;
            return n.item;
        }else{
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
            return n.item;
        }

    }

    public boolean add(E e){
        addLast(e);
        return true;
    }

    public void add(int index, E element){
        if(index < 0 || index > size){
            System.out.println("-1");
        }
        if(index == 0){
            addFirst(element);
            return;
        }
        Node<E> prev = head;
        for(int i=0; i<index-1; i++){
            prev = prev.next;
        }

        Node<E> n = new Node<E>(prev, element, prev.next);
        prev.next.prev = n;
        prev.next = n;
        size++;
    }

    public void addFirst(E e){
        Node<E> next = head;
        Node<E> n = new Node<>(null, e, next);
        next.prev = n;
        head = n;
        size++;
    }

    public void addLast(E e){
        Node<E> prev = tail;
        Node<E> n = new Node<E>(prev, e ,null);
        if(prev == null){
            head = n;
        }else{
            prev.next = n;
        }
        tail = n;
        size++;
    }

    public boolean contains(Object o){
        Node<E> n = head;
        for(int i=0; i<size; i++){
            if(n.item.equals(o)){
                return true;
            }
            n = n.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> n = head;
        for(int i=0; i<size; i++) {
            if (n.item.equals(o)) {
                return i;
            }
            n = n.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> n = tail;
        for(int i=size-1; i>=0; i--) {
            if (n.item.equals(o)) {
                return i;
            }
            n = n.prev;
        }
        return -1;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            return (E) "-1";
        }
        return search(index).item;
    }

    public void set(int index, E element){
        if(index < 0 || index >= size){
            System.out.println("-1");
        }
        Node<E> n = head;
        for(int i=0; i<size; i++){
            if(i == index){
                n.item = element;
            }
            n = n.next;
        }
    }

    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        String result = "";
        Node<E> n = head;
        for(int i=0; i<size; i++){
            result = result + n.item + " ";
            n = n.next;
        }
        return "MyDoublyLinkedList{" +
                result +
                '}';
    }
}
