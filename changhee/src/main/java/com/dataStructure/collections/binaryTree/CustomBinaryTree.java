package com.dataStructure.collections.binaryTree;


public interface CustomBinaryTree<T extends Comparable<T>> {

    Node<T> getRoot();

    void setRoot(Node<T> root);

    // 데이터 제일 마지막에 삽입
    boolean add(T data);

    // 해당 data와 일치하는 데이터 지우기 맨 마지막 값 삭제하기
    boolean remove(T data);

    // 검색 메서드
    boolean search(T data);

    // 중위 순회 출력하기
    void inorderTraversal();

    // 전위 순회 메서드
    void preorderTraversal();

    // 후위 순회 메서드
    void postorderTraversal();

}
