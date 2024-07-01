package com.dataStructure.collections.arrayList;

public class ArrayList implements MyList{

    private Object[] array;
    private int size;
    public static final int DEFAULT_SIZE = 10;

    public ArrayList() {
        this.array = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public ArrayList(int size) {
        this.array = new Object[size];
        this.size = size;
    }

    @Override
    public boolean add(Object value) {
        Object[] temp = new Object[size+1];
        temp[size++] = value;
        this.array = temp;
        //this.array[size++] = value;
        return true;
    }

    @Override
    public void add(int index, Object value) {
        Object[] temp = new Object[size+1];

        for(int i=size; i > index; i--){
            temp[i] = temp[i-1];
        }

        temp[index] = value;
        this.array = temp;
    }

    @Override
    public boolean remove(Object o) {
        int index = -1;
        for(int i=0; i<size; i++){
            if(this.array[i].equals(o)){
                index = i;
                break;
            }
        }
        if(index != -1){
            for(int j=index; j<size-1; j++){
                this.array[j] = array[j+1];
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        Object temp = array[index];

        for(int j=index; j<size-1; j++){
            this.array[j] = array[j+1];
        }
        size--;
        return temp;
    }

    @Override
    public Object get(int index) {
        if(index > size-1){
            return -1;
        }
        return this.array[index];
    }

    @Override
    public void set(int index, Object value) {
        this.array[index] = value;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0; i<size; i++){
            if(this.array[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0; i<size; i++){
            if(this.array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i=size-1; i>=0; i--){
            if(this.array[i].equals(o)){
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
        if(this.size > 0){
            return false;
        }
        return true;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.array = new Object[0];
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
