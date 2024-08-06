package com.dataStructure.collections.binaryTree;

public interface BinarySearchTree<T> {

    // 데이터 제일 마지막에 삽입
    boolean add(T value);

    // 해당 data와 일치하는 데이터 지우기 맨 마지막 값 삭제하기
    T remove(Object o);

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    void clear();

    // 전위 순회 메서드
    void preorder();

    // 중위 순회 출력하기
    void inorder();

    // 후위 순회 메서드
    void postorder();

}

