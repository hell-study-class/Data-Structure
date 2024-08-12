package com.dataStructure.collections.binarySearchTree;


public class MyBinarySearchTree implements CustomBinarySearchTree{

    private Node root;
    private int size;
    public MyBinarySearchTree(){
        this.root = null;
        size = 0;
    }


    public class Node{
        private Object value;
        private Node leftChild;
        private Node rightChild;

        public Node(Object value){
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    @Override
    public boolean add(Object value) {

        if(root == null){
            Node newNode = new Node(value);
            root = newNode;
            size++;
        }
        Node current = root;
        return false;
    }

    @Override
    public Object remove(Object o) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void preorder() {

    }

    @Override
    public void inorder() {

    }

    @Override
    public void postorder() {

    }

}
