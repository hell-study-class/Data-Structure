package com.dataStructure.list.circularlinkedlist;

import com.dataStructure.list.MyList;
import java.util.Arrays;

public class MyCircularLinkedList<E> implements MyList<E> {

    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> tail;
    private int size;

    public MyCircularLinkedList() {
        this.tail = null;
        this.size = 0;
    }

    private void addLast(E value) {
        if (tail == null) {
            Node<E> newNode = new Node<>(value);
            tail = newNode;
            newNode.next = newNode;
        } else {
            Node<E> newNode = new Node<>(value, tail.next);
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            addLast(value);
        } else if (index == 0) {
            tail.next = new Node<>(value, tail.next);
            size++;
        } else {
            Node<E> node = tail;
            for (int i = -1; i < index-1; i++) {
                node = node.next;
            }
            node.next = new Node<>(value, node.next);
            size++;
        }
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 1) {
            tail = null;
        }

        Node<E> node = tail;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        E e = node.next.data;
        node.next = node.next.next;
        size--;
        return e;
    }

    @Override
    public E get(int index) {
        Node<E> node = tail;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size - 1) {
            return node.data;
        }

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public void set(int index, E value) {
        Node<E> node = tail;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size - 1) {
            node.data = value;
        }
        for (int i = -1; i < size - 1; i++) {
            if (i == index) {
                node.data = value;
            }
            node = node.next;
        }
    }

    @Override
    public boolean contains(Object o) {
        Node<E> node = tail;
        if (o == null) {
            for (int i = -1; i < size - 1; i++) {
                if (node.data == null) {
                    return true;
                }
                node = node.next;
            }
        } else {
            for (int i = -1; i < size - 1; i++) {
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
        Node<E> node = tail;
        if (o == null) {
            for (int i = -1; i < size - 1; i++) {
                if (node.data == null) {
                    if (i == -1) {
                        return size - 1;
                    } else {
                        return i;
                    }
                }
                node = node.next;
            }
        } else {
            for (int i = -1; i < size - 1; i++) {
                if (node.data.equals(o)) {
                    if (i == -1) {
                        return size - 1;
                    } else {
                        return i;
                    }
                }
                node = node.next;
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
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public void clear() {
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        Object[] objects = new Object[size];
        Node<E> node = tail;
        for (int i = 0; i < size; i++) {
            node = node.next;
            objects[i] = node.data;
        }
        return Arrays.toString(objects);
    }
}
