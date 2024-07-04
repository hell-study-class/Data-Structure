package com.dataStructure;

public class CircularList<E> implements CustomList<E>{
    class Node<E> {

        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }


    private Node<E> tail;
    private int size;
    private Node<E> ptr;



    public CircularList() {
        this.tail = null;
        this.size = 0;
        this.ptr =null;
    }

    @Override
    public boolean add(E value) {
        Node<E> newNode = new Node<>(value);
        if(this.tail == null){
            this.tail = newNode;
            newNode.next = this.tail;
        }else{
            newNode.next = this.tail.next;
            this.tail.next = newNode;
            tail = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public void add(int index, E value) {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(value);
        if(index == 0){
            this.tail = newNode;
            newNode.next = this.tail;
        }
        else if(index == this.size-1){
            add(value);
        }else{
            ptr = this.tail;
            for(int i = 0; i < index-1; i++){
                ptr = ptr.next;
            }
            newNode.next = ptr.next;
            ptr.next = newNode;
        }
        this.size++;
    }

    @Override
    public boolean remove(Object o) {
        ptr = tail;
        for(int i = 0; i < size; i++){
            ptr = ptr.next;
            if(o.equals(ptr.data)){
                break;
            }
        }
        if(ptr == null){
            return false;
        }
        ptr.next = ptr.next.next;
        this.size--;

        return false;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        E data = get(index);
        remove(data);
        return data;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        ptr = tail;
        for(int i = 0; i < index; i++){
            ptr = ptr.next;
        }
        E element = ptr.data;
        ptr = tail;
        return element;
    }

    @Override
    public void set(int index, E value) {
        if(index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        ptr = tail;
        for(int i = 0; i < index; i++){
            ptr = ptr.next;
        }
        ptr.data = value;
        ptr = tail;
    }

    @Override
    public boolean contains(Object o) {
        int index = indexOf(o);
        return index != -1;
    }

    @Override
    public int indexOf(Object o) {
        ptr = this.tail;
        for(int i = 0; i < size; i++){
            if(o.equals(ptr.data)){
                return i;
            }
        }
        ptr = tail;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        while(ptr != null){
            remove(ptr.data);
            ptr = ptr.next;
        }
    }


}
