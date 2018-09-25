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
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

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

        if(e.compareTo(e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(e) > 0){
            node.right = add(node.right, e);
        }

        return node;
    }
}
