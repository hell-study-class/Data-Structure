package com.dataStructure.collections.linkedList;

import java.util.Collection;

public class MyLinkedListImpl<T> implements MyLinkedList {

    private int size = 0;

    private Node<T> firstNode;

    private Node<T> lastNode;


    public MyLinkedListImpl() {
        firstNode = new Node();
        lastNode = firstNode;
    }

    @Override
    public boolean add(Object value) {
        Node<T> newNode = new Node(value);

        if (firstNode.getValue() == null && firstNode.getNextNode() == null) {
            firstNode = newNode;
            lastNode = newNode;
            size++;
            return true;
        }
        lastNode.setNextNode(newNode);
        lastNode = newNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, Object value) {
        Node<T> newNode = new Node(value);

        Node<T> previousNode = search(index - 1);
        previousNode.setNextNode(newNode);
        Node<T> nextNode = search(index);
        newNode.setNextNode(nextNode);
        size++;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void addFirst(Object value) {
        Node<T> newNode = new Node(value);
        newNode.setNextNode(firstNode);
        firstNode = newNode;
        size++;
    }

    @Override
    public void addLast(Object value) {
        Node<T> newNode = new Node(value);
        lastNode.setNextNode(newNode);
        lastNode = newNode;
        size++;
    }

    @Override
    public void clear() {
        firstNode = new Node<>();
        lastNode = firstNode;
        size = 0;
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
    public Object get(int index) {
        validateIndex(index);
        Node<T> searchNode = search(index);
        return searchNode.getValue();
    }

    @Override
    public Object getFirst() {
        return firstNode.getValue();
    }

    @Override
    public Object getLast() {
        return lastNode.getValue();
    }

    @Override
    public int indexOf(Object o) {
        Node<T> searchNode = firstNode;

        for (int i = 0; i < size; i++) {
            if (searchNode.getValue().equals(o)) {
                return i;
            }
            searchNode = searchNode.getNextNode();
        }
        throw new IllegalArgumentException("존재하지 않는 데이터입니다.");
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> searchNode = firstNode;

        int index = -1;

        for (int i = 0; i < size; i++) {
            if (searchNode.getValue().equals(o)) {
                index = i;
            }
            searchNode = searchNode.getNextNode();
        }
        return index;
    }

    @Override
    public Object remove() {
        if (size < 1) {
            throw new IndexOutOfBoundsException("삭제할 데이터가 없습니다.");
        }
        Node<T> removeNode = firstNode;

        Node<T> tempNode = firstNode.getNextNode();
        firstNode = tempNode;
        size--;

        return removeNode.getValue();
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);

        Node<T> previousNode = search(index - 1);

        Node<T> removeNode = search(index);

        previousNode.setNextNode(removeNode.getNextNode());

        return removeNode.getValue();
    }

    @Override
    public boolean remove(Object o) {
        if (size < 1) {
            throw new IndexOutOfBoundsException("삭제할 데이터가 없습니다.");
        }

        Node<T> previousNode = firstNode;
        Node<T> removeNode = null;

        while (previousNode.getNextNode() != null) {
            if (previousNode.getNextNode().getValue().equals(o)) {
                removeNode = previousNode.getNextNode();
                previousNode.setNextNode(removeNode.getNextNode());
                return true;
            }
            previousNode = previousNode.getNextNode();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
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
