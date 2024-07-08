package com.dataStructure.list.doublelinkedlist;

import com.dataStructure.list.MyList;
import java.util.Arrays;

public class MyDoubleLinkedList<E> implements MyList<E> {

    static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            prev = null;
            next = null;
        }

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyDoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private boolean startFromHead(int index) {
        return index < size / 2;
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
            addFirst(value);
        } else {
            if (startFromHead(index)) {
                Node<E> node = head;
                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }
                Node<E> newNode = new Node<>(value, node, node.next);
                node.next.prev = newNode;
                node.next = newNode;
            } else {
                Node<E> node = tail;
                for (int i = size - 1; i > index; i--) {
                    node = node.prev;
                }
                Node<E> newNode = new Node<>(value, node.prev, node);
                node.prev.next = newNode;
                node.prev = newNode;
            }
            size++;
        }
    }

    private void addLast(E value) {
        if (head == null) {
            Node<E> node = new Node<>(value);
            head = node;
            tail = node;
        } else {
            Node<E> node = new Node<>(value, tail, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    private void addFirst(E value) {
        if (head == null) {
            Node<E> node = new Node<>(value);
            head = node;
            tail = node;
        } else {
            Node<E> node = new Node<>(value, null, head);
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        System.out.println("index = " + index);
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
        if (startFromHead(index)) {
            Node<E> node = head;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            E e = node.next.data;
            node.next.prev = node;
            return e;
        } else {
            Node<E> node = tail;

            for (int i = size - 1; i > index + 1; i--) {
                node = node.prev;
            }
            E e = node.prev.data;
            System.out.println("e = " + e);
            node.prev = node.prev.prev;
            node.prev.next = node;
            return e;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (startFromHead(index)) {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.data;
        } else {
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node.data;
        }
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (startFromHead(index)) {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.data = value;
        } else {
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            node.data = value;
        }
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> node = head;
        int index = 0;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (node.data == null) {
                    return index;
                }
                node = node.next;
                index++;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.data.equals(o)) {
                    return index;
                }
                node = node.next;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> node = tail;
        int index = size - 1;
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (node.data == null) {
                    return index;
                }
                node = node.prev;
                index--;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (node.data.equals(o)) {
                    return index;
                }
                node = node.prev;
                index--;
            }
        }
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
        head = null;
        tail = null;
        size = 0;
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
