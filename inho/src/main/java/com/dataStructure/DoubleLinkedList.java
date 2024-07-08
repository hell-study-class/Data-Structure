package com.dataStructure;

public class DoubleLinkedList<E> implements CustomList<E> {
    class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null || tail == null) {
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public boolean add(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null || tail == null) {
            addFirst(value);
        }else{
            Node<E> current = tail;
            current.next = newNode;
            newNode.prev = current;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
            size++;
        }
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(value);
        if (index == 0) {
            addFirst(value);
        }else if(index == size) {
            add(value);
        }else{
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = newNode;
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }else{
            remove(index);
            return true;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E element;
        if(index == 0) {
            Node<E> current = head;
            element = current.data;
            current = current.next;
            current.prev = tail;
            tail.next = current;
            head = current;
        }else if(index == size - 1) {
            Node<E> current = tail;
            element = current.data;
            current = current.prev;
            current.next = head;
            head.prev = current;
            tail = current;
        }
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            element = current.data;
            Node<E> current1 = current.prev;
            Node<E> current2 = current.next;
            current1.next = current2;
            current2.prev = current1;
        }
        size--;
        return element;
    }

    @Override
    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void set(int index, E value) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = value;
    }

    @Override
    public boolean contains(Object o) {

        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(o)) {
                return i;
            }
        }
        return -1;
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
        return size==0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return "[ "+sb.toString()+" ]";
    }
}
