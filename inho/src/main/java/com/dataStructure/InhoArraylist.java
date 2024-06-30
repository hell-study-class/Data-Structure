package com.dataStructure;

import java.util.Arrays;

public class InhoArraylist<E> implements CustomList<E>{

    private final static int DEFAULT_CAPACITY = 10;
    private final static Object[] EMPTY_ARRAY = {};

    private Object[] array;
    private int size;

    public InhoArraylist(){
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public InhoArraylist(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize(){
        int new_capacity = array.length;

        //리스트의 크기가 부족한 경우
        if(array.length <= this.size){
            new_capacity = array.length+DEFAULT_CAPACITY;
            array = Arrays.copyOf(array, new_capacity);
        }

        //리스트의 크기가 너무 큰 경우
        if((array.length/2) > this.size ){
            new_capacity = array.length/2;
            if(new_capacity < DEFAULT_CAPACITY) new_capacity = DEFAULT_CAPACITY;
            array = Arrays.copyOf(array, new_capacity);
        }
    }


    @Override
    public boolean add(E value) {
        add(size,value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if(size == array.length){
            resize();
        }

        for(int i = size; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = value;
        size++;

    }

    @Override
    public boolean remove(Object value) {
        int removeIndex = indexOf(value);

        if(removeIndex >= 0){
            remove(removeIndex);
            return true;
        }
        return false;
    }

    @Override
    public E remove(int index) {

        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }else{
            E removeValue = (E) array[index];
            for(int i = index; i < size - 1; i++){
                array[i] = array[i+1];
            }
            array[size-1] = null;
            size--;
            return removeValue;
        }
    }

    @Override
    public E get(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }else{
            return (E) array[index];
        }
    }

    @Override
    public void set(int index, E value) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }else{
            array[index] = value;
        }
    }

    @Override
    public boolean contains(Object value) {
        if(indexOf(value) >=0 ){
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(value)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for(int i = size - 1; i >= 0; i--){
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        resize();
        size = 0;
    }

    @Override
    public String toString() {
        return "InhoArraylist{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
