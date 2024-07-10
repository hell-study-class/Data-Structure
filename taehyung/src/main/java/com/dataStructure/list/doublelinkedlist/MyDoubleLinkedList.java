package com.dataStructure.list.doublelinkedlist;

import com.dataStructure.list.MyList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyDoubleLinkedList<E> implements MyList<E> {

    private static class Node<E> {
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

    private Node<E> search(int index) {
        Node<E> node;

        if ((size / 2) > index) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
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
        }
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node<E> nextNode = search(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> newNode = new Node<>(value, prevNode, nextNode);
            size++;
            prevNode.next = newNode;
            newNode.prev = newNode;
        }
    }

    private void addLast(E value) {
        Node<E> last = tail;
        Node<E> newNode = new Node<>(value, last, null);
        tail = newNode;
        size++;
        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
    }

    private void addFirst(E value) {
        Node<E> first = head;
        Node<E> newNode = new Node<>(value, null, first);
        head = newNode;
        size++;

        if (first == null) {
            tail = newNode;
        } else {
            first.prev = newNode;
        }
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        E value = head.data;
        Node<E> first = head.next;
        size--;

        if (first == null) {
            tail = null;
        } else {
            first.prev = null;
        }
        return value;
    }

    public E removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        E value = tail.data;
        Node<E> last = tail.prev;
        size--;
        tail = last;

        if (last == null) {
            head = null;
        } else {
            last.next = null;
        }
        return value;
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
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        }

        Node<E> deleteNode = search(index);
        Node<E> prevNode = deleteNode.prev;
        Node<E> nextNode = deleteNode.next;
        E value = deleteNode.data;
        size--;

        prevNode.next = nextNode;
        prevNode.prev = prevNode;

        return value;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> updateNode = search(index);
        updateNode.data = value;
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
