package com.dataStructure;


public interface CustomBinaryTree<T> {

    // 데이터 제일 마지막에 삽입
    void insert(T data);

    // 해당 data와 일치하는 데이터 지우기 맨 마지막 값 삭제하기
    boolean remove(T data);

    boolean search(T data);

    // 왼쪽 서브 트리 지우기
    void removeLeftSubTree(T node);

    // 오른쪽 서브 트리 지우기
    void removeRightSubTree(T node);

    // 중위 순회 출력하기
    void inorderTraversal();

    // 전위 순회 메서드
    void preorderTraversal();

    // 후위 순회 메서드
    void postorderTraversal();

}
