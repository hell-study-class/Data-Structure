package com.dataStructure.collections.linkedQue;


public class LinkedQueImpl<T> implements LinkedQue {

    private int size = 0;

    private Node<T> firstNode;

    private Node<T> lastNode;

    public LinkedQueImpl() {
        firstNode = null;
        lastNode = null;
    }

    /**
     * 큐의 가장 마지막에 요소를 추가합니다.
     *
     * @param o 큐에 추가할 요소
     * @return 큐에 요소가 정상적으로 추가되었을 경우 true를 반환
     */
    @Override
    public boolean offer(Object o) {
        Node<T> newNode = new Node(o);

        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        size++;

        return true;
    }

    /**
     * 큐의 첫 번째 요소를 삭제하고 삭제 된 요소를 반환합니다.
     *
     * @return 큐의 삭제 된 요소 반환
     */
    @Override
    public Object poll() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        Node removeNode = firstNode;
        firstNode = removeNode.getNextNode();
        size--;

        return removeNode.getValue();
    }

    /**
     * 큐의 첫 번째 요소를 반환합니다.
     *
     * @return 큐의 첫 번째 요소 반환
     */
    @Override
    public Object peek() {
        return firstNode.getValue();
    }
}
