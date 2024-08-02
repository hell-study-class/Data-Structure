package com.dataStructure;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree<E> implements CustomBinaryTree<E> {


    private Node<E> root;
    private int size;
    private int level;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void insert(E data) {
        Node<E> newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node<E> temp = root;

            Queue<Node<E>> q = new ArrayDeque<>();

            q.add(root);

            while (!q.isEmpty()) {
                temp = q.poll();

                //좌측 서브트리 부터 우선 탐색
                if (!temp.hasLeft()) {
                    temp.setLeft(newNode);
                    break;
                }
                q.add(temp.getLeft());

                //우측 서브트리 탐색
                if (!temp.hasRight()) {
                    temp.setRight(newNode);
                    break;
                }
                q.add(temp.getRight());
            }
        }
        size++;
    }

    @Override
    public boolean remove(E data) {
        if (root == null)
            return false;

        Node<E> removedNode = recursionSearchNode(root, data);

        if (removedNode == null)
            return false;
        //자식이 없을 시
        if (!removedNode.hasLeft() && !removedNode.hasRight()) {
            if (removedNode.parent.getLeft() == removedNode) {
                removedNode.parent.setLeft(null);
            } else if (removedNode.parent.getRight() == removedNode) {
                removedNode.parent.setRight(null);
            }
        }
        //좌우 자식노드 모두 존재시
        else if (removedNode.hasLeft() && removedNode.hasRight()) {
            if (removedNode.parent.getLeft() == removedNode) {
                removedNode.parent.setLeft(removedNode.getRight());
            } else if (removedNode.parent.getRight() == removedNode) {
                removedNode.parent.setRight(removedNode.getLeft());
            }
        }//왼쪽 자식만 있는 경우
        else if (removedNode.hasLeft() && !removedNode.hasRight()) {
            if (removedNode.parent.getLeft() == removedNode) {
                removedNode.parent.setLeft(removedNode.getLeft());
            } else if (removedNode.parent.getRight() == removedNode) {
                removedNode.parent.setRight(removedNode.getLeft());
            }
        }//오른쪽 자식만 있는 경우
        else if (!removedNode.hasLeft() && removedNode.hasRight()) {
            if (removedNode.parent.getLeft() == removedNode) {
                removedNode.parent.setLeft(removedNode.getRight());
            } else if (removedNode.parent.getRight() == removedNode) {
                removedNode.parent.setRight(removedNode.getRight());
            }
        }
        removedNode.parent = null;
        size--;
        return true;
    }


    @Override
    public boolean search(E data) {
        if (root == null)
            return false;
        if (data == null)
            return false;
        return recursionSearchNode(root, data) != null;
    }

    private Node<E> recursionSearchNode(Node<E> node, E data) {
        if (node == null) {
            return null;
        }

        if (node.getData().equals(data)) {
            return node;
        }

        Node<E> leftChilde = recursionSearchNode(node.getLeft(), data);
        if (leftChilde != null) {
            return leftChilde;
        }

        return recursionSearchNode(node.getRight(), data);
    }

    @Override
    public void removeLeftSubTree(E data) {
        Node<E> node = recursionSearchNode(root, data);
        if (node == null)
            return;
        if (node.hasLeft()) {
            node.setLeft(null);
        }
    }

    @Override
    public void removeRightSubTree(E data) {
        Node<E> node = recursionSearchNode(root, data);
        if (node == null)
            return;
        if (node.hasRight()) {
            node.setRight(null);
        }
    }

    @Override
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<E> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    @Override
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node<E> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    @Override
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node<E> node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
}