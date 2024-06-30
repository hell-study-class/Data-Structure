package com.dataStructure.collections.arrayList;

public class MyListImpl<T> implements MyList<T> {

    private static final long serialVersionUID = 8683452581122892189L;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_SIZE = 10;
    private Object[] elementData = {};
    private int size = 0;


    public MyListImpl() {
        elementData = new Object[DEFAULT_SIZE];
    }

    @Override
    public boolean add(T value) {
        if (size == elementData.length) {
            Object[] tmp = new Object[elementData.length * 2];
            for (int i = 0; i < elementData.length; i++) {
                tmp[i] = elementData[i];
            }
            elementData = tmp;
            size++;
        } else {
            elementData[size] = value;
            size++;
        }
        return true;
    }

    @Override
    public void add(int index, T value) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("범위를 초과했습니다.");
        }
        if (size == elementData.length) {
            Object[] tmp = new Object[elementData.length * 2];
            for (int i = 0; i < index; i++) {
                tmp[i] = elementData[i];
            }
            tmp[index] = value;
            for (int i = index + 1; i < size; i++) {
                tmp[i] = elementData[i - 1];
            }
            elementData = tmp;
            size++;
        } else {
            for (int i = size - 1; i > index; i--) {
                elementData[i + 1] = elementData[i];
            }
            elementData[index] = value;
            size++;
        }
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == o) {
                Object[] tmp = new Object[elementData.length - 1];
                for (int j = 0; j < i; j++) {
                    tmp[j] = elementData[j];
                }
                for (int j = i; j < tmp.length; j++) {
                    tmp[j] = elementData[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("범위를 초과했습니다.");
        }
        Object[] tmp = new Object[elementData.length - 1];
        T removeValue = (T) elementData[index];
        for (int i = 0; i < index; i++) {
            tmp[i] = elementData[i];
        }
        for (int i = index; i < tmp.length; i++) {
            tmp[i] = elementData[i + 1];
        }
        elementData = tmp;
        size--;
        return removeValue;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("범위를 초과했습니다.");
        }
        return (T) elementData[index];
    }

    @Override
    public void set(int index, T value) {

    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (elementData[size - 1] == o) {
            return 1;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        elementData = EMPTY_ELEMENTDATA;
        size = 0;
    }
}
