package com.dataStructure;

import java.util.Comparator;

public class InhoBinarySearchTree<E> implements CustomTree<E> {

    class Node<E>{

        E data;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node(E data, Node<E> parent){
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = parent;
        }
    }

    private Node<E> root;
    private int size;
    private final Comparator<? super E> comparator;

    public InhoBinarySearchTree() {
        root = null;
        size = 0;
        comparator = null;
    }

    public InhoBinarySearchTree(Comparator<? super E> comparator) {
        root = null;
        this.comparator = comparator;
        size = 0;
    }


    @Override
    public boolean add(E value) {
        if(comparator == null){
            return addByComparalbe(value) == null;
        }
        return addByComparator(value,comparator) == null;
    }

    private E addByComparalbe(E value){
        Node<E> current = root;

        if(root == null){
            root = new Node<>(value);
            size++;
            return null;
        }

        Node<E> currentParent;
        int compResult;

        Comparable<? super E> comValue = (Comparable<? super E>) value;

        do{
            currentParent = current;
            compResult = comValue.compareTo(current.data);

            if(compResult >0){
                current = currentParent.right;
            }else if(compResult < 0){
                current = currentParent.left;
            }else {
                return value;
            }
        }while(current != null);

        Node<E> newNode = new Node<>(value, currentParent);

        if(compResult > 0){
            currentParent.right = newNode;
        }else {
            currentParent.left = newNode;
        }

        size++;
        return null;
    }

    private E addByComparator(E value, Comparator<? super E> comparator){
        Node<E> current = root;
        if(root == null){
            root = new Node<>(value);
            size++;
            return null;
        }

        int compResult;
        Node<E> currentParent;
        do{
            currentParent = current;
            compResult = comparator.compare(current.data, value);
            if(compResult > 0){
                current = currentParent.right;
            }else if(compResult < 0){
                current = currentParent.left;
            }else{
                return value;
            }
        } while(current != null);

        Node<E> newNode = new Node<>(value, currentParent);

        if(compResult > 0){
            currentParent.right = newNode;
        }else{
            currentParent.left = newNode;
        }

        size++;
        return null;
    }

    @Override
    public E remove(Object o) {
        return null;
    }

    private E removeByComparalbe(E value){
        Node<E> current = root;
        E oldValue = value;
        if(root == null){
            return null;
        }

        Comparable<? super E> comValue = (Comparable<? super E>) value;

        int compResult;
        Node<E> currentParent = null;
        boolean hasLeft = false;
        do{
            compResult = comValue.compareTo(current.data);
            if(compResult == 0){
                break;
            }

            currentParent = current;

            if(compResult < 0){
                hasLeft = true;
                current = currentParent.left;
            }else {
                hasLeft = false;
                current = currentParent.right;
            }
        }while(current != null);

        if(current == null){
            return null;
        }

        if(currentParent == null){
            deleteNode(current);
            size--;
            return oldValue;
        }

        if(hasLeft){
            currentParent.left = deleteNode(current);
            if(currentParent.left != null){
                currentParent.left.parent = currentParent;
            }
        }else{
            currentParent.right = deleteNode(current);
            if(currentParent.right != null){
                currentParent.right.parent = currentParent;
            }
        }

        size--;
        return oldValue;
    }

    private E removeByComparator(E value, Comparator<? super E> comparator){
        Node<E> currentParent = null;
        Node<E> current = root;
        boolean hasLeft = false;

        if(root == null){
            return null;
        }

        do{
            int compResult = comparator.compare(current.data, value);
            if(compResult == 0){
                break;
            }
            currentParent = current;
            if(compResult < 0){
                hasLeft = true;
                current = current.left;
            }else{
                hasLeft = false;
                current = current.right;
            }
        }while(current != null);

        if(current == null){
            return null;
        }

        if(currentParent == null){
            deleteNode(current);
            size--;
            return value;
        }
        if(hasLeft){
            currentParent.left = deleteNode(current);
            if(currentParent.left != null){
                currentParent.left.parent = currentParent;
            }
        }else{
            currentParent.right = deleteNode(current);
            if(currentParent.right != null){
                currentParent.right.parent = currentParent;
            }
        }

        size--;
        return value;
    }

    private Node<E> deleteNode(Node<E> node){

        if(node != null){
            if(node.left == null && node.right == null){
                if(node == root){
                    root = null;
                }
                else{
                    node = null;
                }

                return null;
            }

            if(node.left != null && node.right != null){
                Node<E> replacement = getSuccessorAndUnlink(node);
                node.data = replacement.data;
            }
            else if(node.left !=null){
                if (node == root) {
                    node = node.left;
                    root = node;
                    root.parent = null;
                }else{
                    node = node.left;
                }
            }
            else{
                if(node == root){
                    node = node.right;
                    root = node;
                    root.parent = null;
                }else{
                    node = node.right;
                }
            }
        }
        return node;
    }

    public Node<E> getSuccessorAndUnlink(Node<E> node){
        Node<E> currentParent = node;
        Node<E> current = node.right;

        if(current.left == null){
            currentParent.right = current.right;
            if(current.right != null){
                currentParent.right.parent = currentParent;
            }
            return current;
        }

        while(current.left != null){
            currentParent = current;
            current = current.left;
        }

        currentParent.left = current.right;
        if(currentParent.left != null){
            currentParent.left.parent = currentParent;
        }
        current.right = null;
        current.parent = null;
        return current;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0 || root==null;
    }

    @Override
    public boolean contains(Object o) {

        if(comparator == null){
            return searchByComparable(o) == null;
        }
        return searchByComparator(o,comparator)==null;
    }

    private Object searchByComparable(Object o){

        Comparable<? super E> comparable = (Comparable<? super E>) o;
        Node<E> current = root;

        do{
            int compResult = comparable.compareTo(current.data);
            if(compResult == 0){
                return null;
            }

            if(compResult < 0){
                current = current.left;
            }
            if(compResult > 0){
                current = current.right;
            }
        }while(current != null);

        return o;
    }

    private Object searchByComparator(Object o,Comparator<? super E> comparator){

        Node<E> current = root;
        E compData = (E) o;
        do{
            int compResult = comparator.compare(compData,current.data);
            if(compResult == 0){
                return null;
            }
            if(compResult < 0){
                current = current.left;
            }
            if(compResult > 0){
                current = current.right;
            }
        }while(current != null);

        return o;
    }

    @Override
    public void clear() {
        size =0;
        root = null;
    }
}
