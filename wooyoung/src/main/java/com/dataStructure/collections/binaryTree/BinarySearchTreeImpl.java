package com.dataStructure.collections.binaryTree;

public class BinarySearchTreeImpl implements BinarySearchTree {

    Node root;
    int size;

    public BinarySearchTreeImpl() {
        root = new Node();
        size = 0;
    }

    public BinarySearchTreeImpl(Integer value) {
        root = new Node(value);
        size = 1;
    }

    @Override
    public boolean add(Object data) {
        Node newNode = new Node((Integer) data);
        Node node = root;
        while (true) {
            if (node.compareTo(newNode) > 0) {      // 추가할 값이 노드보다 작다면
                if (node.getLeft() == null) {       // 노드의 왼쪽 자식이 없다면
                    newNode.setParent(node);        // 노드를 추가할 값 노드의 부모로 지정한다.
                    node.setLeft(newNode);          // 노드의 왼쪽 자식을 추가할 값의 노드로 지정한다.
                    size++;
                    return true;
                } else {
                    node = node.getLeft();          // 왼쪽 자식이 있으면 계속해서 탐색하도록 노드의 포인터를 왼쪽 자식으로 다시 지정한다.
                }
            } else if (node.compareTo(newNode) < 0) {   // 추가할 값이 노드보다 크다면
                if (node.getRight() == null) {          // 노드의 오른쪽 자식이 없다면
                    newNode.setParent(node);            // 노드를 추가할 값 노드의 부모로 지정한다.
                    node.setRight(newNode);             // 노드의 오른쪽 자식을 추가할 값의 노드로 지정한다.
                    size++;
                    return true;
                } else {
                    node = node.getRight();             // 오른쪽 자식이 있으면 계속해서 탐색하도록 노드의 포인터를 오른 자식으로 다시 지정한다.
                }
            } else {
                return false;           // 데이터가 이미 존재하는 경우 false 반환
            }
        }
    }

    @Override
    public Object remove(Object data) {
        Node node = findNode((Integer) data);                   // 매개변수 값을 가진 노드의 위치를 찾는다.
        Node parentNode = node.getParent();                     // 찾은 노드의 부모를 꺼낸다.
        if (node == null) {                                     // 삭제할 노드가 null인 경우
            return null;
        }
        if (node.getLeft() == null
            && node.getRight()
            == null) {                                                  // 삭제할 노드의 오른쪽, 왼쪽 자식 모두 없는 경우
            if (parentNode.getRight() == node) {                        // 삭제할 노드가 부모의 오른쪽 자식인 경우
                parentNode.setRight(null);                                  // 부모의 오른쪽 노드를 지운다.
            } else {                                                    // 삭제할 노드가 부모의 왼쪽 자식인 경우
                parentNode.setLeft(null);                                   // 부모의 왼쪽 노드를 지운다.
            }
            node.setParent(null);
        } else if (node.getRight() == null
            && node.getLeft()
            != null) {                                                  // 삭제할 노드의 오른쪽 자식이 null이면서 왼쪽 자식이 존재하는 경우
            if (parentNode.getRight().equals(node)) {                   // 삭제할 노드가 오른쪽 자식이라면
                parentNode.setRight(
                    node.getLeft());                                        // 부모의 오른쪽 자식을 삭제할 노드의 왼쪽 자식으로 설정
                node.getLeft().setParent(parentNode);
            } else {                                                    // 삭제할 노드가 왼쪽 자식이라면
                parentNode.setLeft(
                    node.getRight());                                        // 부모의 왼쪽 자식을 삭제할 노드의 오른쪽 자식으로 설정
                node.getRight().setParent(parentNode);
            }
        } else if (node.getRight()
            != null) {                                                   // 오른쪽 자식이 존재하는 경우
            Node changeNode = node.getRight();                           // 삭제할 노드의 오른쪽 노드 추출
            while (changeNode.getLeft()
                != null) {                       // 왼쪽 자식이 null일 때 까지 탐색 ( 가장 작은 값 추출 )
                changeNode = changeNode.getLeft();
            }
            if (parentNode.getRight() == node) {                         // 부모 노드의 오른쪽 자식이 삭제할 노드라면
                parentNode.setRight(changeNode);                            // 오른쪽 자식을 가장 작은 값으로 설정
            } else {                                                     // 왼쪽 자식이 삭제할 노드라면
                parentNode.setLeft(changeNode);                             // 왼쪽 자식을 가장 작은 값으로 설정
            }
            changeNode.setParent(parentNode);
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public boolean contains(Object o) {
        return findNode((Integer) o) != null ? true : false;
    }

    @Override
    public void clear() {
        root = new Node();
        size = 0;
    }

    private Node findNode(int value) {
        Node findNode = new Node((Integer) value);
        Node node = root;
        while (node != null) {
            if (node.compareTo(findNode) > 0) {
                node = node.getLeft();
            } else if (node.compareTo(findNode) < 0) {
                node = node.getRight();
            } else {
                return node;
            }
        }
        return null;
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            inorder(node.getLeft());
        }
        System.out.print(node.getValue() + " ");
        if (node.getRight() != null) {
            inorder(node.getRight());
        }

    }

    @Override
    public void postorder() {
        postorder(root);
    }

    public static void postorder(Node node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            postorder(node.getLeft());
        }
        if (node.getRight() != null) {
            postorder(node.getRight());
        }
        System.out.print(node.getValue() + " ");
    }

}
