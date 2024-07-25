package com.dataStructure.collections.arrayStack;

import java.util.Arrays;

public class MyArrayStack implements CustomArrayStack {

    private Object[] arr;
    private int size;

    public MyArrayStack(){
        this.arr = new Object[10];
        this.size = 0;
    }

    private void resize(int newSize){
        Object[] newArr = new Object[newSize];
        for(int i=0; i<size; i++){
            newArr[i] = arr[i];
        }
        this.arr = newArr;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public Object peek() {
        if(size <= 0){
            return null;
        }else{
            return arr[size-1];
        }
    }

    @Override
    public Object pop() {
        if(size <= 0){
            return null;
        }
        Object result = arr[--size];
        arr[size] = null;
        return result;
    }

    @Override
    public Object push(Object item) {
        if(size > arr.length -1){
            resize(arr.length * 2);
        }
        arr[size++] = item;
        return item;
    }

    @Override
    public int search(Object o) {
        for(int i=0; i<size; i++){
            if(arr[i].equals(o)){
                return i+1;
            }
        }
        return -1;
    }

    public int size(){
        return this.size;
    }

    public void clear(){
        this.size = 0;
        this.arr = new Object[10];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            sb.append(arr[i]).append(" ");
        }
        return "ArrayStack{" +
                "array=" + sb.toString() +
                '}';
    }
}
