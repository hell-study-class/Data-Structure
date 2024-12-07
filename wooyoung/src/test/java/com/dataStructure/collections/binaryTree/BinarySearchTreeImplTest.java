package com.dataStructure.collections.binaryTree;

import org.junit.jupiter.api.Test;

class BinarySearchTreeImplTest {

    @Test
    void 왼쪽자식노드만_존재하는경우_삭제_테스트() {
        BinarySearchTree tree = new BinarySearchTreeImpl(3);
        tree.add(1);
        tree.add(2);
        tree.add(6);
        tree.add(4);
        tree.add(5);

        tree.remove(6);

        tree.preorder();
    }

    @Test
    void 리프노드_식제_테스트() {
        BinarySearchTree tree = new BinarySearchTreeImpl(3);
        tree.add(1);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.add(4);
        tree.add(5);

        tree.remove(4);
        tree.preorder();
    }

    @Test
    void 오른쪽_노드가_존재하는경우_삭제_테스트() {
        BinarySearchTree tree = new BinarySearchTreeImpl(3);
        tree.add(1);
        tree.add(2);
        tree.add(6);
        tree.add(4);
        tree.add(5);

        tree.remove(4);
        tree.preorder();
    }

    @Test
    void 전위순회_테스트() {
        BinarySearchTree tree = new BinarySearchTreeImpl(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.preorder();
    }

    @Test
    void 중위순회_테스트() {
        BinarySearchTree tree = new BinarySearchTreeImpl(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.inorder();
    }

    @Test
    void 후위순회_테스트() {
        BinarySearchTree tree = new BinarySearchTreeImpl(3);
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.preorder();
    }

}