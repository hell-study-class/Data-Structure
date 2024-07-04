package com.dataStructure;

public class LinkedList<E> implements CustomList {

    class Node<E>{

        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }

    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    private Node<E> search(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> p = head;

        for(int i = 0; i < index; i++){
            p = p.next;
        }

        return p;
    }

    public void addFirst(E e){
        Node<E> p = new Node<>(e);
        Node<E> q = head;

        if(head == null){
            head = p;
            tail = p;
            size++;
        }else{
            p.next = head.next;
            q.data = null;
            q.next = null;
            size++;
        }
    }

    @Override
    public boolean add(Object value) {
        Node<E> p = new Node<>((E) value);
        if(head == null){
            addFirst((E) value);
            size++;
        }else{
            Node<E> q = head;
            while(q.next != null){
                q = q.next;
            }
            q.next = p;
            tail = p;
            size++;
        }
        return true;
    }

    @Override
    public void add(int index, Object value) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            addFirst((E) value);
        }
        if(index == size-1){
            add(value);
        }
        Node<E> p = new Node<>((E) value);
        Node<E> q = head;
        for(int i =0; i<index; i++){
            q = q.next;
        }
        Node<E> temp = q.next;
        q.next = p;
        p.next = temp;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> p = head;
        Node<E> q = head;

        for(; q != null; q = q.next){
            if(q.data.equals(o)){
                break;
            }
            p = q;
        }

        if(q == null){
            return false;
        }

        p.next = q.next;
        q.data = null;
        q.next = null;
        size--;
        return true;
    }


    @Override
    public Object remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            Node<E> q = head;
            E element = q.data;
            Node<E> p = q.next;
            q.data = null;
            q.next = null;

            head = p;
            size--;

            return element;
        }else{
            Node<E> p = head;
            Node<E> q = head;
            for(int i =0; i<index-1; i++,q = q.next){
                if(i == index-2){
                    break;
                }
                p = q;
            }
            E element = q.data;
            p.next = q.next;
            q.data = null;
            q.next = null;
            size--;
            return element;
        }
    }

    @Override
    public Object get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, Object value) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> q = head;

        int index = 0;

        for(; q != null; q = q.next){
            index++;
            if(q.data.equals(o)){
                break;
            }
        }
        return index;

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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

    }
}