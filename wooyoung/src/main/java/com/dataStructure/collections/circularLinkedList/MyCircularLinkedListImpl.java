package com.dataStructure.collections.circularLinkedList;

import com.dataStructure.collections.linkedList.Node;
import java.util.NoSuchElementException;

public class MyCircularLinkedListImpl<T> implements MyCircularLinkedList {

    private int size = 0;

    private Node<T> firstNode;

    private Node<T> lastNode;

    public MyCircularLinkedListImpl() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public boolean add(Object value) {
        Node<T> newNode = new Node(value);

        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
            lastNode.setNextNode(firstNode);
            size++;
            return true;
        }
        lastNode.setNextNode(newNode);
        lastNode = newNode;
        lastNode.setNextNode(firstNode);
        size++;
        return true;
    }

    @Override
    public void add(int index, Object value) {
        Node<T> newNode = new Node(value);

        validateIndex(index);

        if (index == 0) {
            lastNode.setNextNode(newNode);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
            size++;
            return;
        }

        if (index == size - 1) {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
            lastNode.setNextNode(firstNode);
            size++;
            return;
        }

        Node<T> searchNode = search(index);
        Node<T> nextNode = searchNode.getNextNode();
        searchNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        size++;
    }

    @Override
    public boolean remove(Object o) {
        if (firstNode.getValue().equals(o)) {
            lastNode.setNextNode(firstNode.getNextNode());
            firstNode = firstNode.getNextNode();
            size--;
            return true;
        }
        Node<T> prevNode = firstNode;
        Node<T> removeNode = null;

        for (int i = 0; i < size - 1; i++) {
            if (prevNode.getNextNode().getValue().equals(o)) {
                if (i == size - 2) {
                    prevNode.setNextNode(firstNode);
                    lastNode = prevNode;
                    return true;
                }
                removeNode = prevNode.getNextNode();
                prevNode.setNextNode(removeNode.getNextNode());
                size--;

                return true;
            }
            prevNode = prevNode.getNextNode();
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        if (index == 0) {
            Node<T> removeNode = firstNode;
            firstNode = firstNode.getNextNode();
            size--;
            return removeNode.getValue();
        }

        if (index == size - 1) {
            Node<T> prevNode = search(index - 1);
            Node<T> removeNode = prevNode.getNextNode();
            prevNode.setNextNode(firstNode);
            lastNode = prevNode;
            size--;
            return removeNode.getValue();
        }

        Node<T> prevNode = search(index - 1);
        Node<T> removeNode = prevNode.getNextNode();
        prevNode.setNextNode(removeNode.getNextNode());
        size--;

        return removeNode.getValue();
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        Node<T> searchNode = search(index);
        return searchNode.getValue();
    }

    @Override
    public void set(int index, Object value) {
        validateIndex(index);

        Node<T> searchNode = search(index);
        searchNode.setValue((T) value);
    }

    @Override
    public boolean contains(Object o) {
        Node<T> searchNode = firstNode;

        for (int i = 0; i < size; i++) {
            if (searchNode.getValue().equals(o)) {
                return true;
            }
            searchNode = searchNode.getNextNode();
        }

        return false;
    }

    @Override
    public int indexOf(Object o) {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Node<T> searchNode = firstNode;

        for (int i = 0; i < size; i++) {
            if (searchNode.getValue().equals(o)) {
                return i;
            }
            searchNode = searchNode.getNextNode();
        }
        throw new NoSuchElementException();
    }

    @Override
    public int lastIndexOf(Object o) {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Node<T> searchNode = firstNode;
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (searchNode.getValue().equals(o)) {
                index = i;
            }
            searchNode = searchNode.getNextNode();
        }
        if (index == -1) {
            throw new NoSuchElementException();
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
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {        // 0 미만 or size 이상 경우
            throw new ArrayIndexOutOfBoundsException(String.valueOf("인덱스 값은 배열 범위를 초과했습니다."));
        }
    }

    private Node<T> search(int index) {
        Node<T> searchNode = firstNode;

        for (int i = 0; i < index; i++) {
            searchNode = searchNode.getNextNode();
        }
        return searchNode;
    }
}
