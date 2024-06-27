package com.dataStructure.collections.arrayList;

public class MyListImpl<T> implements MyList<T> {

    private static final long serialVersionUID = 8683452581122892189L;
    private static Object[] elementData = {};
    private static final int DEFAULT_SIZE = 10;

    public MyListImpl() {
        elementData = new Object[0];
    }

    @Override
    public boolean add(T value) {
        if (elementData.length == 0) {
            elementData = new Object[1];
            elementData[elementData.length - 1] = value;

            return true;
        }

        Object[] tmp = new Object[elementData.length];

        for (int i = 0; i < elementData.length; i++) {
            tmp[i] = elementData[i];
        }

        elementData = new Object[elementData.length + 1];

        for (int i = 0; i < tmp.length; i++) {
            elementData[i] = tmp[i];
        }

        elementData[elementData.length - 1] = value;

        return true;
    }

    @Override
    public void add(int index, T value) {

    }

    @Override
    public boolean remove(T value) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == value) {
                // 임시 배열 생성
                Object[] tmp = new Object[elementData.length - 1];

                for (int j = 0; j < i; j++) {
                    tmp[j] = elementData[j];
                }
                for (int j = i; j < tmp.length; j++) {
                    tmp[j] = elementData[j + 1];
                }

                elementData = tmp;
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T get(int index) {
        return (T) elementData[index];
    }

    @Override
    public void set(int index, T value) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public int size() {
        return elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
