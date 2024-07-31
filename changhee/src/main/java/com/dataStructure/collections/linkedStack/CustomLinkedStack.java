package com.dataStructure.collections.linkedStack;

public interface CustomLinkedStack<E> {
    /*스택이 비어있는지 확인하는 메서드*/
    boolean isEmpty();

    /*스택에서 객체를 제거하지 않고 스택의 맨 위에 있는 객체를 확인하는 메서드*/
    E peek();

    /*스택의 맨 위에 있는 객체를 제거하고 해당 객체를 return 값으로 반환하는 메서드*/
    E pop();

    /*스택의 맨 위에 항목을 추가하는 메서드*/
    E push(E item);

    /*스택에서 객체의 위치를 1부터 시작하여 위치 값을 반환하는 메서드*/
    int search(E o);
}