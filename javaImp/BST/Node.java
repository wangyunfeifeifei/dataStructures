package javaImp.BST;

public class Node<E extends Comparable<E>> {
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