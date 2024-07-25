package com.dataStructure.collections.arrayStack;

public class ArrayStackImpl implements ArrayStack {

    private static final int DEFAULT_SIZE = 10;
    private Object[] elementData = {};
    private int size = 0;

    ArrayStackImpl() {
        elementData = new Object[DEFAULT_SIZE];
    }

    /*스택이 비어있는지 확인하는 메서드*/
    @Override
    public boolean empty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /*스택에서 객체를 제거하지 않고 스택의 맨 위에 있는 객체를 확인하는 메서드*/
    @Override
    public Object peek() {
        if (size == 0) {
            return null;
        }
        return elementData[size - 1];
    }

    /*스택의 맨 위에 있는 객체를 제거하고 해당 객체를 return 값으로 반환하는 메서드*/
    @Override
    public Object pop() {
        if (size == 0) {
            throw new IllegalArgumentException("제거할 데이터가 없습니다.");
        }
        if (DEFAULT_SIZE - 1 == (elementData.length - size)) {
            if (elementData.length != DEFAULT_SIZE) {
                Object[] tmp = elementData;
                elementData = new Object[elementData.length / 2];
                for (int i = 0; i < tmp.length; i++) {
                    elementData[i] = tmp[i];
                }
            }
        }
        Object removeObj = elementData[size - 1];
        elementData[size - 1] = null;
        size--;
        return removeObj;
    }

    /*스택의 맨 위에 항목을 추가하는 메서드*/
    @Override
    public Object push(Object item) {
        // 배열의 길이 2배로 증가
        if (size == elementData.length) {
            Object[] tmp = elementData;
            elementData = new Object[elementData.length * 2];
            for (int i = 0; i < tmp.length; i++) {
                elementData[i] = tmp[i];
            }
        }
        elementData[size] = item;
        size++;
        return item;
    }

    /*스택에서 객체의 위치를 1부터 시작하여 위치 값을 반환하는 메서드*/
    @Override
    public int search(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == o) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
}
