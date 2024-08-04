package com.dataStructure.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayBinaryTree<T> implements BinaryTree<T> {

    private Object[] array;
    private static int DEFAULT_SIZE = 100;
    private int size;

    public ArrayBinaryTree(int size) {
        if (size < DEFAULT_SIZE) {
            this.array = new Object[DEFAULT_SIZE];
            this.size = DEFAULT_SIZE;
        } else {
            this.array = new Object[size];
            this.size = size;
        }
    }

    public ArrayBinaryTree() {
        this.array = new Object[DEFAULT_SIZE];
        this.size = DEFAULT_SIZE;
    }

    @Override
    public T getRoot() {
        if (this.array[1] == null) {
            throw new RuntimeException("tree is empty");
        }
        return (T) this.array[1];
    }

    @Override
    public void setRoot(T root) {
        this.array[1] = root;
    }

    @Override
    public void insert(T data) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Integer x = queue.poll();
                if (this.array[x] == null) {
                    this.array[x] = data;
                    return;
                }
                if (x * 2 < size)
                    queue.offer(x * 2);
                if (x * 2 + 1 < size)
                    queue.offer(x * 2 + 1);
            }
        }
    }

    @Override
    public boolean remove(T data) {
        return false;
    }

    @Override
    public boolean search(T data) {
        if (empty()) {
            throw new RuntimeException("tree is empty");
        }
        return recursiveSearch(1, data);
    }

    private boolean recursiveSearch(int idx, T data) {
        if (this.array[idx] == data) {
            return true;
        }
        boolean left = false, right = false;
        if (this.array[idx * 2] != null) {
            left = recursiveSearch(idx * 2, data);
        }
        if (this.array[idx * 2 + 1] != null) {
            right = recursiveSearch(idx * 2 + 1, data);
        }
        return left || right;
    }

    @Override
    public void inorderTraversal() {
        if (empty()) {
            throw new RuntimeException("tree is empty");
        }
        recursiveInorder(1);
        System.out.println();
    }

    private void recursiveInorder(int idx) {
        if (this.array[idx * 2] != null) {
            recursiveInorder(idx * 2);
        }
        System.out.print(this.array[idx] + " ");
        if (this.array[idx * 2 + 1] != null) {
            recursiveInorder(idx * 2 + 1);
        }
    }

    @Override
    public void preorderTraversal() {
        if (empty()) {
            throw new RuntimeException("tree is empty");
        }
        recursivePreorder(1);
        System.out.println();
    }

    private void recursivePreorder(int idx) {
        System.out.print(this.array[idx] + " ");
        if (idx * 2 < size && this.array[idx * 2] != null) {
            recursivePreorder(idx * 2);
        }
        if (idx * 2 + 1 < size && this.array[idx * 2 + 1] != null) {
            recursivePreorder(idx * 2 + 1);
        }
    }

    @Override
    public void postorderTraversal() {
        if (empty()) {
            throw new RuntimeException("tree is empty");
        }
        recursivePostOrder(1);
        System.out.println();
    }

    private void recursivePostOrder(int idx) {
        if (this.array[idx * 2] != null) {
            recursivePostOrder(idx * 2);
        }
        if (this.array[idx * 2 + 1] != null) {
            recursivePostOrder(idx * 2 + 1);
        }
        System.out.print(this.array[idx] + " ");
    }

    public boolean empty() {
        return this.array[1] == null;
    }
}
