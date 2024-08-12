package com.dataStructure.collections.binaryTree;

import java.util.Comparator;

public class MyBinaryTree<E> {

    private Node<E> root;
    private int size;

    private final Comparator<? super E> comparator;

    public MyBinaryTree(){
        this(null);
    }

    public MyBinaryTree(Comparator<? super E> comparator){
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
    }

    public boolean add(E value){
        if(comparator == null){
            return addUsingComparable(value) == null;
        }
        return addUsingComparator(value, comparator) == null;
    }

    private E addUsingComparable(E value) {
        Node<E> current = root;

        if(current == null){
            root = new Node<E>(value);
            size++;
            return null;
        }

        Node<E> currentParent;

        Comparable<? super E> compValue = (Comparable<? super E>) value;

        int compResult;

        do{
            currentParent = current;

            compResult = compValue.compareTo(current.value);

            if(compResult < 0){
                current = current.left;
            }else if(compResult > 0){
                current = current.right;
            }else{
                return value;
            }

        }while(current != null);

        Node<E> newNode = new Node<E>(value, currentParent);

        if(compResult < 0){
            currentParent.left = newNode;
        }else{
            currentParent.right = newNode;
        }
        size++;
        return null;
    }

    private E addUsingComparator(E value, Comparator<? super E> comparator) {

        Node<E> current = root;

        if(current == null){
            root = new Node<E>(value, null);
            size++;
            return null;
        }

        Node<E> currentParent;
        int compResult;
        do{
            currentParent = current;
            compResult = comparator.compare(value, current.value);

            if(compResult < 0){
                current = current.left;
            }else if(compResult > 0){
                current = current.right;
            }else{
                return value;
            }
        }while(current != null);

        Node<E> newNode = new Node<E>(value, currentParent);
        if(compResult < 0){
            currentParent.left = newNode;
        }else {
            currentParent.right = newNode;
        }
        size++;
        return null;
    }

    // 삭제 메소드

    /**
     * 삭제되는 노드의 자리를 대체할 노드(후계자)를 찾는 메소드
     * (오른쪽 자식 노드 중 가장 작은 노드를 찾음)
     *
     * @param node 삭제되는 노드(=대체되어야 할 노드)
     * @return 대체할 노드
     * */
    private Node<E> getSuccessorAndUnlink(Node<E> node){

        Node<E> currentParent = node;   // 대체 할 노드의 부모노드를 가리키는 노드
        Node<E> current = node.right;   // 초기에 오른쪽 자식 노드를 가리키도록 한다.

        /**
         * 처음 탐색하게되는 오른쪽 자식 노드(current)에서
         * current의 왼쪽 자식이 없다는 것은 current 노드,
         * 즉 오른쪽 첫 자식노드가 대체되는 노드가 된다는 것이다.
         *
         * 그렇기 때문에 대체해야하는 노드는 삭제되는 노드의 오른쪽 자식이 되며
         * 이에 대체되는 노드 자리(currentParent)의 오른쪽 자식은
         * current의 오른쪽 자식을 가리키고, currentParent는 이후
         * current의 값이 반환되고, 상위 메소드에서 currentParent자리에
         * 값이 대체되게 된다.
         * */
        if(currentParent.left == null){
            currentParent.right = current.right;
            if(currentParent.right != null){
                currentParent.right.parent = currentParent;
            }
            current.right = null;
            return current;
        }

        // 가장 작은 노드를 찾을 때까지 반복한다.
        while(current.left != null){
            currentParent = current;
            current = current.left;
        }

        /**
         * 만약 후계자가 될 노드(가장 작은 노드)의 오른쪽 노드가 존재한다면
         * currentParent의 왼쪽 자식노드는 오른쪽 자식노드와 연결되어야 한다.
         *
         * 만약 current.right = null 이라면
         * 후계자가 될 노드의 자식노드는 존재하지 않으므로 자연스럽게
         * 후계자 노드의 부모노드는 후계자가 다른노드로 대체되러 가기 때문에
         * 후계자의 부모노드의 왼쪽자식노드는 자연스럽게 null을 가르키게 된다.
         * */
        currentParent.left = current.right;
        if(currentParent.left != null){
            currentParent.left.parent = currentParent;
        }

        current.right = null;
        return current;
    }

    /**
     * 삭제 할 노드에 대해 삭제를 수행하는 메소드
     *
     * @param node 삭제 할 노드
     * @return 삭제 후 대체 되고 난 뒤의 해당 위치의 노드를 반환
     * */
    private Node<E> deleteNode(Node<E> node){
        if(node != null){
            // 자식노드가 없을 경우
            if(node.left == null && node.right == null){
                // 삭제하려는 노드가 root일 경우 root를 끊어버리고 종료한다.
                if(node == root){
                    root = null;
                }
                // 그 외에는 단말 노드이므로 해당 노드만 삭제한다.
                // 자연스럽게 node의 부모노드는 null을 참조하게 됨
                else{
                    node = null;
                }
                return null;
            }

            // 양쪽의 자식노드가 모두 있을 경우
            if(node.left != null && node.right != null){
                // 대체 노드를 찾아온다. (앞선 만들었던 후계자를 찾는 메소드다)
                Node<E> replacement = getSuccessorAndUnlink(node);
                // 삭제 된 노드에 대체 노드의 값을 대체해준다.
                node.value = replacement.value;
            }
            // 왼쪽 노드만 존재할 경우
            else if(node.left != null){
                /**
                 * 삭제할 노드가 root일 경우 왼쪽자식 노드(대체되는 노드)를
                 * 삭제할 노드로 옮긴 다음 root를 대체노드를 가리키도록 변경한다.
                 * */
                if(node == root){
                    node = node.left;
                    root = node;
                    root.parent = null;
                }else{
                    node = node.left;
                }
            }
            // 오른쪽 노드만 존재할 경우
            else{
                /**
                 * 삭제할 노드가 root일 경우 오른쪽 자식 노드(대체되는 노드)를
                 * 삭제할 노드로 옮긴 다음 root를 대체노드를 가리키도록 변경한다.
                 * */
                if(node == root){
                    node = node.right;
                    root = node;
                    root.parent = null;
                }else {
                    node = node.right;
                }
            }
        }
        return node;
    }

    /**
     * 삭제 메소드
     * @param o 삭제할 값
     * @return 삭제 된 노드의 value 값 혹은 매칭 값이 없을 경우 null을 반환한다.
     * */
    public E remove(Object o){
        if(root == null){
            return null;
        }
        if(comparator == null){
            return removeUsingComparable(o);
        }else{
            return removeUsingComparator(o, comparator);
        }
    }

    private E removeUsingComparable(Object value){
        E oldVal = (E) value;
        Node<E> parent = null;
        Node<E> current = root;

        boolean hasLeft = false;

        if(root == null){
            return null;
        }

        Comparable<? super E> compValue = (Comparable<? super E>) value;

        do{
            int resComp = compValue.compareTo(current.value);
            if(resComp == 0){
                break;
            }

            parent = current;
            if(resComp < 0){
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

        if(parent == null){
            deleteNode(current);
            size--;
            return oldVal;
        }

        if(hasLeft){
            parent.left = deleteNode(current);
            if(parent.left != null){
                parent.left.parent = parent;
            }
        }else{
            parent.right = deleteNode(current);
            if(parent.right != null){
                parent.right.parent = parent;
            }
        }
        size--;
        return oldVal;
    }

    private E removeUsingComparator(Object value, Comparator<? super E> comp){
        E oldVal = (E) value;
        Node<E> parent = null;
        Node<E> current = root;
        boolean hasLeft = false;

        if(root == null){
            return null;
        }

        E compValue = (E) value;

        do{
            int resComp = comp.compare(compValue, current.value);
            if(resComp == 0){
                break;
            }

            parent = current;
            if(resComp < 0){
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

        if(parent == null){
            deleteNode(current);
            size--;
            return oldVal;
        }

        if(hasLeft){
            parent.left = deleteNode(current);
            if(parent.left != null){
                parent.left.parent = parent;
            }
        }else{
            parent.right = deleteNode(current);
            if(parent.right != null){
                parent.right.parent = parent;
            }
        }
        size--;
        return oldVal;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean contains(Object o){
        if(comparator == null){
            return containsUsingComparable(o);
        }
        return containsUsingComparator(o, comparator);
    }

    private boolean containsUsingComparable(Object o){
        Comparable<? super E> value = (Comparable<? super E>) o;

        Node<E> node = root;
        while(node != null){
            int res = value.compareTo(node.value);
            if(res == 0){
                return true;
            }else if(res < 0){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return false;
    }

    private boolean containsUsingComparator(Object o, Comparator<? super E> comparator){
        E value = (E) o;
        Node<E> node = root;
        while(node != null){
            int res = comparator.compare(value, node.value);
            if(res < 0){
                node = node.left;
            }else if(res > 0){
                node = node.right;
            }else{
                return true;
            }
        }
        return false;
    }

    public void clear(){
        size = 0;
        root = null;
    }

    public void preorder(){
        preorder(this.root);
    }

    public void preorder(Node<E> o){
        if(o != null){
            System.out.print(o.value + " ");
            preorder(o.left);
            preorder(o.right);
        }
    }

    public void inorder(){
        inorder(this.root);
    }

    public void inorder(Node<E> o){
        if(o != null){
            inorder(o.left);
            System.out.print(o.value + " ");
            inorder(o.right);
        }
    }

    public void postorder(){
        postorder(this.root);
    }

    public void postorder(Node<E> o){
        if(o != null){
            postorder(o.left);
            postorder(o.right);
            System.out.print(o.value + " ");
        }
    }
}
