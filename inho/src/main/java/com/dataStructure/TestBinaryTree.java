package com.dataStructure;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Long> tree = new BinaryTree<>();

        tree.insert(5L);
        tree.insert(1L);
        tree.insert(3L);
        tree.insert(2L);
        tree.insert(4L);
        tree.insert(6L);
        tree.insert(9L);
        tree.insert(7L);
        tree.insert(10L);

//        System.out.println(tree.searchNode(1L).left.data);
//        System.out.println(tree.searchNode(1L).right.data);
//        tree.preorderTraversal();
//        System.out.println();
//        tree.inorderTraversal();
//        System.out.println();
//        tree.postorderTraversal();
    }
}
