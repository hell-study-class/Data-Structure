package com.dataStructure.list.linkedlist;

import com.dataStructure.list.MyList;
import java.util.Arrays;

public class MyLinkedList<E> implements MyList<E> {

    private static class Node<E> {
        private Node<E> next;
        private E data;

        public Node(E data) {
            this.next = null;
            this.data = data;
        }

        public Node(Node<E> next, E data) {
            this.next = next;
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void addFirst(E value) {
        if (head == null) {
            Node<E> newNode = new Node<>(value);
            head = newNode;
            tail = newNode;
        } else {
            head = new Node<>(head, value);
        }
        size++;
    }

    private void addLast(E value) {
        if (head == null) {
            Node<E> newNode = new Node<E>(value);
            head = newNode;
            tail = newNode;
        } else {
            Node<E> newNode = new Node<E>(value);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index >= size) {
            addLast(value);
        } else if (index == 0) {
            addFirst(value);
        } else {
            Node<E> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            node.next = new Node<>(node.next, value);
            size++;
        }
    }

    @Override
    public boolean remove(Object o) {
        int idx = indexOf(o);
        if (idx == -1) return false;
        remove(idx);
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (isEmpty()) {
            throw new IllegalStateException();
        } else if (index == 0) {
            E e = head.data;
            head = head.next;
            size--;
            return e;
        } else {
            Node<E> node = head;
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }
            Node<E> removedNode = node.next;
            node.next = removedNode.next;
            size--;
            return removedNode.data;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.data = value;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> node = head;
        if (o == null) {
            while (node != null) {
                if (node.data == null) {
                    return true;
                }
                node = node.next;
            }
        } else {
            while (node != null) {
                if (node.data.equals(o)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> node = head;
        int idx = 0;
        if (o == null) {
            while (node != null) {
                if (node.data == null) {
                    return idx;
                }
                node = node.next;
                idx++;
            }
        } else {
            while (node != null) {
                if (node.data.equals(o)) {
                    return idx;
                }
                node = node.next;
                idx++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return -1;
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
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        Object[] objects = new Object[size];
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            objects[i] = node.data;
            node = node.next;
        }
        return Arrays.toString(objects);
    }
}
