package com.dataStructure.collections.doubleLinkedList;

import java.util.NoSuchElementException;

public class MyDoubleLinkedListImpl<T> implements MyDoubleLinkedList {

    private int size = 0;

    private Node<T> firstNode;

    private Node<T> lastNode;

    public MyDoubleLinkedListImpl() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public boolean add(Object value) {
        Node<T> newNode = new Node(value);

        if (size == 0 || firstNode == null) {   // 데이터가 0개 있을 때
            firstNode = newNode;
            lastNode = newNode;
            size++;
            return true;
        }
        if (size > 0 && lastNode == firstNode) {  // 데이터가 1개 있을 때
            firstNode.setNext(newNode);
            newNode.setPrev(firstNode);
            lastNode = newNode;
            size++;
            return true;
        }
        newNode.setPrev(lastNode);
        lastNode.setNext(newNode);
        lastNode = newNode;
        size++;
        return true;
    }

    @Override
    public void add(int index, Object value) {
        validateIndex(index);
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size - 1) {
            addLast(value);
            return;
        }
        Node<T> searchNode = search(index);
        Node<T> prevNode = searchNode.getPrev();
        Node<T> newNode = new Node(value);

        newNode.setPrev(prevNode);
        newNode.setNext(searchNode);

    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (firstNode.getValue().equals(o)) {   // 삭제 데이터가 첫번째 원소일 때
            if (size == 1) {                    // 리스트 길이 == 1일인 경우 즉, firstNode == lastNode 경우
                clear();
                return true;
            }
            firstNode = firstNode.getNext();
            size--;
            return true;
        }
        if (lastNode.getValue().equals(o)) {    // 삭제 데이터가 마지막 원소일 때
            lastNode = lastNode.getPrev();
            size--;
            return true;
        }

        Node<T> searchNode = firstNode;

        for (int i = 0; i < size; i++) {
            if (searchNode.getValue().equals(o)) {
                break;
            }
            searchNode = searchNode.getNext();
        }
        Node<T> prevNode = searchNode.getPrev();
        prevNode.setNext(searchNode.getNext());
        size--;
        return true;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        Node<T> removeNode;

        if (index == 0) {
            removeNode = firstNode;
            firstNode = firstNode.getNext();
            size--;
            return removeNode.getValue();
        }
        if ((size - 1) / 2 > index) {
            removeNode = firstNode;
            for (int i = 1; i <= index; i++) {
                removeNode = removeNode.getNext();
            }
        } else {
            removeNode = lastNode;
            for (int i = size - 2; i >= index; i--) {
                removeNode = removeNode.getPrev();
            }
        }
        Node<T> prevNode = removeNode.getPrev();
        prevNode.setNext(removeNode.getNext());
        size--;

        return removeNode.getValue();
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        Node<T> search = search(index);

        return search.getValue();
    }

    @Override
    public void set(int index, Object value) {

    }

    @Override
    public boolean contains(Object o) {
        Node<T> searchNode = firstNode;

        for (int i = 0; i < size; i++) {
            if (searchNode.getValue().equals(o)) {
                return true;
            }
            searchNode = searchNode.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> searchNode = firstNode;

        int index = 0;

        for (int i = 0; i < size; i++) {
            if (searchNode.getValue().equals(o)) {
                return index;
            }
            searchNode = searchNode.getNext();
            index++;
        }

        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> searchNode = lastNode;
        int index = size - 1;
        for (int i = size - 1; i > 0; i--) {
            if (searchNode.getValue().equals(o)) {
                return index;
            }
            searchNode = searchNode.getPrev();
            index--;
        }
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    private Node<T> search(int index) {
        Node<T> searchNode;
        if (index == 0) {
            return firstNode;
        }
        if ((size / 2) < index) {
            searchNode = lastNode;

            for (int i = size - 2; i >= index; i--) {
                searchNode = searchNode.getPrev();
            }

        } else {
            searchNode = firstNode;
            for (int i = 1; i <= index; i++) {
                searchNode = searchNode.getNext();
            }
        }
        return searchNode;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {        // 0 미만 or size 이상 경우
            throw new NoSuchElementException(String.valueOf("인덱스 값은 배열 범위를 초과했습니다."));
        }
    }

    private void addLast(Object value) {
        Node<T> newNode = new Node(value);

        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
            size++;
        } else if (size == 1) {
            firstNode.setNext(newNode);
            newNode.setPrev(firstNode);
            lastNode = newNode;
            size++;
            return;
        }
        lastNode.setNext(newNode);
        newNode.setPrev(lastNode);
        lastNode = newNode;
        size++;
    }

    public void addFirst(Object value) {
        Node<T> newNode = new Node(value);

        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
            size++;
            return;
        }

        Node<T> tempNode = firstNode;
        newNode.setNext(tempNode);
        firstNode = newNode;
        size++;
    }
}
