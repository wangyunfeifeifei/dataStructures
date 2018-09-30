package javaImp.BST;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 二分搜索树元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的节点插入元素e
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {

        if(node == null) {
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查看二分搜索树是否包含某元素
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 以node为节点的二分搜索树是否包含e
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {

        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 以Node为根的二分搜索树的前序遍历
     * @param node
     */
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
}
