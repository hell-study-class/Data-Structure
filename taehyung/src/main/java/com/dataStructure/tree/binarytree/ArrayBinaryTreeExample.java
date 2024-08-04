package com.dataStructure.tree.binarytree;

public class ArrayBinaryTreeExample {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>(100);
        System.out.println("tree.empty() = " + tree.empty());
        for (int i = 0; i < 11; i++) {
            tree.insert(i);
        }
        System.out.println("insert complete");
        System.out.println();

        System.out.println("preorder traversal");
        tree.preorderTraversal();

        System.out.println("inorder traversal");
        tree.inorderTraversal();

        System.out.println("postorder traversal");
        tree.postorderTraversal();
    }
}
